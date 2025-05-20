package org.ebook;

import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.netty.GrpcSslContexts;
import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.shim.ChaincodeStub;
import com.google.gson.Gson;
import java.io.File;

import org.ebook.LicenseProto.CreateLicenseRequest;
import org.ebook.LicenseProto.CreateLicenseResponse;
import org.ebook.LicenseProto.ReadLicenseRequest;
import org.ebook.LicenseProto.ReadLicenseResponse;
import org.ebook.LicenseProto.TransferLicenseRequest;
import org.ebook.LicenseProto.TransferLicenseResponse;
import org.ebook.LicenseProto.LicenseServiceGrpc;

public class GRPCServer {
    private final static int PORT = 9999;
    private Server server;
    private static final Gson gson = new Gson();
    private final EbookLicenseContract contract = new EbookLicenseContract();

    public void start() throws Exception {
        server = NettyServerBuilder.forPort(PORT)
                .sslContext(GrpcSslContexts.forServer(
                        new File(
                                "/home/amash/fabric-samples/test-network/organizations/peerOrganizations/org1.example.com/peers/peer0.org1.example.com/tls/server.crt"),
                        new File(
                                "/home/amash/fabric-samples/test-network/organizations/peerOrganizations/org1.example.com/peers/peer0.org1.example.com/tls/server.key"))
                        .build())
                .addService(new GRPCServer.LicenseService())
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
        public void createLicense(License.CreateLicenseRequest request,
                StreamObserver<License.CreateLicenseResponse> responseObserver) {
            Context ctx = new Context(new ChaincodeStubImpl());
            try {
                EbookLicense license = new EbookLicense(
                        request.getLicenseId(),
                        request.getBookId(),
                        request.getOwnerId(),
                        request.getIssueDate(),
                        "ACTIVE");

                String licenseState = new Gson().toJson(license);
                ctx.getStub().putStringState(request.getLicenseId(), licenseState);

                License.CreateLicenseResponse response = License.CreateLicenseResponse.newBuilder()
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
        public void readLicense(License.ReadLicenseRequest request,
                StreamObserver<License.ReadLicenseResponse> responseObserver) {
            Context ctx = new Context(new ChaincodeStubImpl());
            try {
                String licenseState = ctx.getStub().getStringState(request.getLicenseId());
                if (licenseState.isEmpty()) {
                    responseObserver.onError(new RuntimeException("License not found"));
                    return;
                }
                EbookLicense license = gson.fromJson(licenseState, EbookLicense.class);
                License.ReadLicenseResponse response = License.ReadLicenseResponse.newBuilder()
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
        public void transferLicense(License.TransferLicenseRequest request,
                StreamObserver<License.TransferLicenseResponse> responseObserver) {
            Context ctx = new Context(new ChaincodeStubImpl());
            try {
                String licenseState = ctx.getStub().getStringState(request.getLicenseId());
                if (licenseState.isEmpty()) {
                    responseObserver.onError(new RuntimeException("License not found"));
                    return;
                }
                EbookLicense license = gson.fromJson(licenseState, EbookLicense.class);
                license.setOwnerId(request.getNewOwnerId());
                ctx.getStub().putStringState(request.getLicenseId(), gson.toJson(license));

                License.TransferLicenseResponse response = License.TransferLicenseResponse.newBuilder()
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
