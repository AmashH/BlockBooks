package org.ebook;

import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.netty.GrpcSslContexts;
import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.shim.ChaincodeStub;
import com.google.gson.Gson;
import java.io.File;

// Import the generated classes
import org.ebook.LicenseProto.CreateLicenseRequest;
import org.ebook.LicenseProto.CreateLicenseResponse;
import org.ebook.LicenseProto.ReadLicenseRequest;
import org.ebook.LicenseProto.ReadLicenseResponse;
import org.ebook.LicenseProto.TransferLicenseRequest;
import org.ebook.LicenseProto.TransferLicenseResponse;
import org.ebook.LicenseServiceGrpc;

public class GRPCServer {
    private final static int PORT = 9999;
    private Server server;
    private final Gson gson = new Gson();
    private final EbookLicenseContract contract = new EbookLicenseContract();

    public void start() throws Exception {
        server = NettyServerBuilder.forPort(PORT)
                .sslContext(GrpcSslContexts.forServer(
                        new File(
                                "/home/amash/fabric-samples/test-network/organizations/peerOrganizations/org1.example.com/peers/peer0.org1.example.com/tls/server.crt"),
                        new File(
                                "/home/amash/fabric-samples/test-network/organizations/peerOrganizations/org1.example.com/peers/peer0.org1.example.com/tls/server.key"))
                        .build())
                .addService(new LicenseService())
                .build()
                .start();

        System.out.println("gRPC Server with TLS started, listening on " + PORT);
        server.awaitTermination();
    }

    public static void main(String[] args) throws Exception {
        GRPCServer server = new GRPCServer();
        server.start();
    }

    static class LicenseService extends LicenseServiceGrpc.LicenseServiceImplBase {

        @Override
        public void createLicense(CreateLicenseRequest request,
                StreamObserver<CreateLicenseResponse> responseObserver) {
            // For now, just send back a success response without touching the blockchain
            try {
                CreateLicenseResponse response = CreateLicenseResponse.newBuilder()
                        .setMessage("License created successfully")
                        .setLicenseId(request.getLicenseId())
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } catch (Exception e) {
                responseObserver.onError(e);
            }
        }

        @Override
        public void readLicense(ReadLicenseRequest request,
                StreamObserver<ReadLicenseResponse> responseObserver) {
            // For now, just create a dummy response
            try {
                ReadLicenseResponse response = ReadLicenseResponse.newBuilder()
                        .setLicenseId(request.getLicenseId())
                        .setBookId("dummy-book-id")
                        .setOwnerId("dummy-owner-id")
                        .setIssueDate("2025-05-20")
                        .setStatus("ACTIVE")
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } catch (Exception e) {
                responseObserver.onError(e);
            }
        }

        @Override
        public void transferLicense(TransferLicenseRequest request,
                StreamObserver<TransferLicenseResponse> responseObserver) {
            // For now, just send back a success response
            try {
                TransferLicenseResponse response = TransferLicenseResponse.newBuilder()
                        .setMessage("License transferred successfully")
                        .setLicenseId(request.getLicenseId())
                        .setNewOwnerId(request.getNewOwnerId())
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } catch (Exception e) {
                responseObserver.onError(e);
            }
        }
    }
}