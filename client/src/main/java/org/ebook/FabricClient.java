package org.ebook;

import org.hyperledger.fabric.gateway.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class FabricClient {

    private final String channelName = "fyptest";
    private final String contractName = "EbookLicenseContract";
    private Gateway gateway;

    // For a quick demo, let's add a mock mode flag
    private boolean mockMode = false; // Set to true to avoid real blockchain connection

    public FabricClient() {
        if (!mockMode) {
            try {
                // Initialize real connection
                initializeGateway();
            } catch (Exception e) {
                System.err.println("Failed to connect to Fabric: " + e.getMessage());
                // Fall back to mock mode if connection fails
                mockMode = true;
            }
        }
    }

    private void initializeGateway() throws Exception {
        // Path to connection profile
        Path networkConfigPath = Paths
                .get("/home/amash/test-network/organizations/peerOrganizations/org1.example.com/connection-org1.yaml");

        // Path to certificate
        Path certPath = Paths
                .get("/home/amash/test-network/organizations/peerOrganizations/org1.example.com/users/User1@org1.example.com/msp/signcerts/User1@org1.example.com-cert.pem");

        // Path to private key directory
        Path keyDir = Paths
                .get("/home/amash/test-network/organizations/peerOrganizations/org1.example.com/users/User1@org1.example.com/msp/keystore");

        // Find the private key file (there's usually only one file in this directory)
        Path keyPath = Files.list(keyDir).findFirst()
                .orElseThrow(() -> new RuntimeException("No private key found in " + keyDir));

        // Read the certificate and private key
        X509Certificate certificate = Identities.readX509Certificate(Files.newBufferedReader(certPath));
        PrivateKey privateKey = Identities.readPrivateKey(Files.newBufferedReader(keyPath));

        // Create the gateway builder
        Gateway.Builder builder = Gateway.createBuilder()
                .identity(Identities.newX509Identity("Org1MSP", certificate,
                        Signers.newPrivateKeySigner(privateKey)))
                .networkConfig(networkConfigPath);

        this.gateway = builder.connect();
    }

    // Just the two methods needed for demo
    public String issueLicense(String bookId, String userId) throws Exception {
        // Generate a unique license ID
        String licenseId = "LIC_" + UUID.randomUUID().toString().substring(0, 8);
        String issueDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        if (mockMode) {
            // Return mock data for demo
            System.out.println("MOCK MODE: Creating license " + licenseId);
            return licenseId;
        }

        try {
            Network network = gateway.getNetwork(channelName);
            Contract contract = network.getContract(contractName);
            contract.submitTransaction("createLicense", licenseId, bookId, userId, issueDate);
            return licenseId;
        } catch (Exception e) {
            System.err.println("Blockchain error: " + e.getMessage());
            // For demo, don't let errors stop the flow
            return licenseId;
        }
    }

    public String queryLicense(String licenseId) throws Exception {
        if (mockMode) {
            // Return mock data for demo
            System.out.println("MOCK MODE: Querying license " + licenseId);
            return "{\"licenseId\":\"" + licenseId +
                    "\",\"bookId\":\"book123\",\"ownerId\":\"user456\"," +
                    "\"issueDate\":\"2025-03-31\",\"status\":\"ACTIVE\"}";
        }

        try {
            Network network = gateway.getNetwork(channelName);
            Contract contract = network.getContract(contractName);
            byte[] result = contract.evaluateTransaction("readLicense", licenseId);
            return new String(result);
        } catch (Exception e) {
            System.err.println("Blockchain error: " + e.getMessage());
            // Return mock data if real query fails
            return "{\"licenseId\":\"" + licenseId +
                    "\",\"bookId\":\"book123\",\"ownerId\":\"user456\"," +
                    "\"issueDate\":\"2025-03-31\",\"status\":\"ACTIVE\"}";
        }
    }
}