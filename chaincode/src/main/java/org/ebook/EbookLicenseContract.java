package org.ebook;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.shim.ChaincodeException;
import org.hyperledger.fabric.shim.ChaincodeStub;
import com.google.gson.Gson;

@Contract(name = "EbookLicenseContract")
@Default
public final class EbookLicenseContract implements ContractInterface {
    private final Gson gson = new Gson();

    @Transaction
    public EbookLicense createLicense(final Context ctx, final String licenseId, final String bookId,
            final String ownerId, final String issueDate) {
        if (licenseId == null || licenseId.trim().isEmpty())
            throw new ChaincodeException("licenseId cannot be empty");
        if (bookId == null || bookId.trim().isEmpty())
            throw new ChaincodeException("bookId cannot be empty");
        if (ownerId == null || ownerId.trim().isEmpty())
            throw new ChaincodeException("ownerId cannot be empty");
        if (issueDate == null || issueDate.trim().isEmpty())
            throw new ChaincodeException("issueDate cannot be empty");

        ChaincodeStub stub = ctx.getStub();
        String licenseState = stub.getStringState(licenseId);
        if (!licenseState.isEmpty()) {
            String errorMessage = String.format("License %s already exists", licenseId);
            throw new ChaincodeException(errorMessage);
        }
        EbookLicense license = new EbookLicense(licenseId, bookId, ownerId, issueDate, "ACTIVE");
        licenseState = gson.toJson(license);
        stub.putStringState(licenseId, licenseState);
        return license;
    }

    @Transaction
    public EbookLicense readLicense(final Context ctx, final String licenseId) {
        ChaincodeStub stub = ctx.getStub();
        String licenseState = stub.getStringState(licenseId);
        if (licenseState.isEmpty()) {
            String errorMessage = String.format("License %s does not exist", licenseId);
            throw new ChaincodeException(errorMessage);
        }
        return gson.fromJson(licenseState, EbookLicense.class);
    }

    @Transaction
    public EbookLicense transferLicense(final Context ctx, final String licenseId, final String newOwnerId) {
        ChaincodeStub stub = ctx.getStub();
        String licenseState = stub.getStringState(licenseId);
        if (licenseState.isEmpty()) {
            String errorMessage = String.format("License %s does not exist", licenseId);
            throw new ChaincodeException(errorMessage);
        }
        EbookLicense license = gson.fromJson(licenseState, EbookLicense.class);
        license.setOwnerId(newOwnerId);
        licenseState = gson.toJson(license);
        stub.putStringState(licenseId, licenseState);
        return license;
    }
}