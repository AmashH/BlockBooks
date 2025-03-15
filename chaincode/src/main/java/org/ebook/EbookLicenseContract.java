package org.ebook;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.shim.ChaincodeException;
import org.hyperledger.fabric.shim.ChaincodeStub;
import com.owlike.genson.Genson;

@Contract(name = "EbookLicenseContract")
@Default
public final class EbookLicenseContract implements ContractInterface {

    private final Genson genson = new Genson();

    @Transaction
    public EbookLicense createLicense(final Context ctx, final String licenseId, final String bookId,
            final String ownerId, final String issueDate) {
        ChaincodeStub stub = ctx.getStub();

        // Check if license already exists
        String licenseState = stub.getStringState(licenseId);
        if (!licenseState.isEmpty()) {
            String errorMessage = String.format("License %s already exists", licenseId);
            throw new ChaincodeException(errorMessage);
        }

        // Create license
        EbookLicense license = new EbookLicense(licenseId, bookId, ownerId, issueDate, "ACTIVE");
        licenseState = genson.serialize(license);
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

        return genson.deserialize(licenseState, EbookLicense.class);
    }

    @Transaction
    public EbookLicense transferLicense(final Context ctx, final String licenseId, final String newOwnerId) {
        ChaincodeStub stub = ctx.getStub();
        String licenseState = stub.getStringState(licenseId);

        if (licenseState.isEmpty()) {
            String errorMessage = String.format("License %s does not exist", licenseId);
            throw new ChaincodeException(errorMessage);
        }

        EbookLicense license = genson.deserialize(licenseState, EbookLicense.class);
        license.setOwnerId(newOwnerId);
        licenseState = genson.serialize(license);
        stub.putStringState(licenseId, licenseState);

        return license;
    }
}