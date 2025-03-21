
package org.ebook;

import com.owlike.genson.annotation.JsonProperty;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType()
public final class EbookLicense {
    @Property()
    private final String licenseId;

    @Property()
    private final String bookId;

    @Property()
    private String ownerId;

    @Property()
    private final String issueDate;

    @Property()
    private String status;

    public EbookLicense(@JsonProperty("licenseId") final String licenseId,
            @JsonProperty("bookId") final String bookId,
            @JsonProperty("ownerId") final String ownerId,
            @JsonProperty("issueDate") final String issueDate,
            @JsonProperty("status") final String status) {
        this.licenseId = licenseId;
        this.bookId = bookId;
        this.ownerId = ownerId;
        this.issueDate = issueDate;
        this.status = status;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public String getBookId() {
        return bookId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}