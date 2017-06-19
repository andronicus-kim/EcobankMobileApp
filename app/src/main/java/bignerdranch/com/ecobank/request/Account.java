package bignerdranch.com.ecobank.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dataintegrated on 6/19/2017.
 */

public class Account {

        @SerializedName("holding")
        @Expose
        private String holding;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("holders")
        @Expose
        private List<Holder> holders = null;

        public String getHolding() {
            return holding;
        }

        public void setHolding(String holding) {
            this.holding = holding;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Holder> getHolders() {
            return holders;
        }

        public void setHolders(List<Holder> holders) {
            this.holders = holders;
        }

}
