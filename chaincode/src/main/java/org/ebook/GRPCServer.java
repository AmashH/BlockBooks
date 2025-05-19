package org.ebook;

import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.netty.GrpcSslContexts;
import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.shim.ChaincodeStub;
import com.google.gson.Gson;
import java.io.File;

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
            Context ctx = new Context(new ChaincodeStub());
            try {
                EbookLicense license = new EbookLicense(
                        request.getLicenseId(),
                        request.getBookId(),
                        request.getOwnerId(),
                        request.getIssueDate(),
                        "ACTIVE");

                String licenseState = new Gson().toJson(license);
                ctx.getStub().putStringState(request.getLicenseId(), licenseState);

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
        public void readLicense(ReadLicenseRequest request, StreamObserver<ReadLicenseResponse> responseObserver) {
            Context ctx = new Context(new ChaincodeStub());
            try {
                String licenseState = ctx.getStub().getStringState(request.getLicenseId());
                if (licenseState.isEmpty()) {
                    responseObserver.onError(new RuntimeException("License not found"));
                    return;
                }
                EbookLicense license = gson.fromJson(licenseState, EbookLicense.class);
                ReadLicenseResponse response = ReadLicenseResponse.newBuilder()
                        .setLicenseId(license.getLicenseId())
                        .setBookId(license.getBookId())
                        .setOwnerId(license.getOwnerId())
                        .setIssueDate(license.getIssueDate())
                        .setStatus(license.getStatus())
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
            Context ctx = new Context(new ChaincodeStub());
            try {
                String licenseState = ctx.getStub().getStringState(request.getLicenseId());
                if (licenseState.isEmpty()) {
                    responseObserver.onError(new RuntimeException("License not found"));
                    return;
                }
                EbookLicense license = gson.fromJson(licenseState, EbookLicense.class);
                license.setOwnerId(request.getNewOwnerId());
                ctx.getStub().putStringState(request.getLicenseId(), gson.toJson(license));

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
