package bignerdranch.com.ecobank.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dataintegrated on 6/19/2017.
 */

public class Merchant {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("password")
        @Expose
        private String password;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
}
