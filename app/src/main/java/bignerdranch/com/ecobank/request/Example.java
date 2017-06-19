package bignerdranch.com.ecobank.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dataintegrated on 6/19/2017.
 */

public class Example {

        @SerializedName("merchant")
        @Expose
        private Merchant merchant;
        @SerializedName("account")
        @Expose
        private Account account;

        public Merchant getMerchant() {
            return merchant;
        }

        public void setMerchant(Merchant merchant) {
            this.merchant = merchant;
        }

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }
}
