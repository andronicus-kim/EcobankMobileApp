package bignerdranch.com.ecobank.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by james on 4/12/2017.
 */

public class Data {
    @SerializedName("7")
    @Expose
    private Long transmissionDateAndTime;

    @SerializedName("11")
    @Expose
    private Long systemsTraceNumber;

    @SerializedName("12")
    @Expose
    private Long timeLocalTransaction;

    @SerializedName("13")
    @Expose
    private Long dateLocalTransaction;

    @SerializedName("37")
    @Expose
    private String retrievalReferenceNumber;

    @SerializedName("123")
    @Expose
//    private String accountCreationData;
    private AccountData accountCreationData;

    public Data() {
    }

    public Data(Long transmissionDateAndTime, Long systemsTraceNumber, Long timeLocalTransaction, Long dateLocalTransaction, String retrievalReferenceNumber, AccountData accountCreationData) {
        this.transmissionDateAndTime = transmissionDateAndTime;
        this.systemsTraceNumber = systemsTraceNumber;
        this.timeLocalTransaction = timeLocalTransaction;
        this.dateLocalTransaction = dateLocalTransaction;
        this.retrievalReferenceNumber = retrievalReferenceNumber;
        this.accountCreationData = accountCreationData;
    }

    public Long getTransmissionDateAndTime() {
        return transmissionDateAndTime;
    }

    public void setTransmissionDateAndTime(Long transmissionDateAndTime) {
        this.transmissionDateAndTime = transmissionDateAndTime;
    }

    public Long getSystemsTraceNumber() {
        return systemsTraceNumber;
    }

    public void setSystemsTraceNumber(Long systemsTraceNumber) {
        this.systemsTraceNumber = systemsTraceNumber;
    }

    public Long getTimeLocalTransaction() {
        return timeLocalTransaction;
    }

    public void setTimeLocalTransaction(Long timeLocalTransaction) {
        this.timeLocalTransaction = timeLocalTransaction;
    }

    public Long getDateLocalTransaction() {
        return dateLocalTransaction;
    }

    public void setDateLocalTransaction(Long dateLocalTransaction) {
        this.dateLocalTransaction = dateLocalTransaction;
    }

    public String getRetrievalReferenceNumber() {
        return retrievalReferenceNumber;
    }

    public void setRetrievalReferenceNumber(String retrievalReferenceNumber) {
        this.retrievalReferenceNumber = retrievalReferenceNumber;
    }

    public AccountData getAccountCreationData() {
        return accountCreationData;
    }

    public void setAccountCreationData(AccountData accountCreationData) {
        this.accountCreationData = accountCreationData;
    }
}
