package bignerdranch.com.ecobank.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dataintegrated on 6/19/2017.
 */

public class Holder {

        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("middle_name")
        @Expose
        private String middleName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("employment")
        @Expose
        private String employment;
        @SerializedName("next_of_kin")
        @Expose
        private String nextOfKin;
        @SerializedName("next_of_kin_phone")
        @Expose
        private String nextOfKinPhone;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("photo")
        @Expose
        private String photo;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmployment() {
            return employment;
        }

        public void setEmployment(String employment) {
            this.employment = employment;
        }

        public String getNextOfKin() {
            return nextOfKin;
        }

        public void setNextOfKin(String nextOfKin) {
            this.nextOfKin = nextOfKin;
        }

        public String getNextOfKinPhone() {
            return nextOfKinPhone;
        }

        public void setNextOfKinPhone(String nextOfKinPhone) {
            this.nextOfKinPhone = nextOfKinPhone;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }
}
