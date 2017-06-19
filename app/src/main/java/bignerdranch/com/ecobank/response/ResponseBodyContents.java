package bignerdranch.com.ecobank.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dataintegrated on 6/19/2017.
 */

public class ResponseBodyContents {

    @SerializedName("account_no")
    @Expose
    private String accountNo;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

}
