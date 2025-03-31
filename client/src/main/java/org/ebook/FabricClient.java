package org.ebook;

import org.hyperledger.fabric.gateway.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FabricClient {

    private final String channelName = "mychannel";
    private final String contractName = "ebooklicensing";
    private Gateway gateway;

    // For a quick demo, let's add a mock mode flag
    private boolean mockMode = true; // Set to true to avoid real blockchain connection

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
        // Simplified connection code
        Path networkConfigPath = Paths
                .get("../test-network/organizations/peerOrganizations/org1.example.com/connection-org1.yaml");
        Gateway.Builder builder = Gateway.createBuilder()
                .identity(Identities.newX509Identity("Org1MSP", Identities.readX509Certificate("path/to/cert"),
                        Signers.newPrivateKeySigner(Identities.readPrivateKey("path/to/key"))))
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