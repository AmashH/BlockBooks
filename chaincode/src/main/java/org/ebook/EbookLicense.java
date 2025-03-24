package org.ebook;

import org.hyperledger.fabric.contract.annotation.DataType; //add datatype to ensure custom return types generate metadata for serialization
import org.hyperledger.fabric.contract.annotation.Property;
import com.google.gson.annotations.SerializedName; // Replace Genson import

@DataType()
public class EbookLicense {

    @Property()
    @SerializedName("licenseId") // Use Gson’s annotation
    private String licenseId;

    @Property()
    @SerializedName("bookId")
    private String bookId;

    @Property()
    @SerializedName("ownerId")
    private String ownerId;

    @Property()
    @SerializedName("issueDate")
    private String issueDate;

    @Property()
    @SerializedName("status")
    private String status;

    // Constructor
    public EbookLicense(String licenseId, String bookId, String ownerId, String issueDate, String status) {
        this.licenseId = licenseId;
        this.bookId = bookId;
        this.ownerId = ownerId;
        this.issueDate = issueDate;
        this.status = status;
    }

    // Getters and setters
    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}