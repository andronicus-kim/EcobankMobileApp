package bignerdranch.com.ecobank.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by james on 4/12/2017.
 */

public class AccountData {

    @SerializedName("1")
    @Expose
    private Long id;

    @SerializedName("2")
    @Expose
    private String firstName;

    @SerializedName("3")
    @Expose
    private String middleName;

    @SerializedName("4")
    @Expose
    private String surname;

    @SerializedName("5")
    @Expose
    private Long phoneNumber;

    @SerializedName("6")
    @Expose
    private boolean employed;

    @SerializedName("7")
    @Expose
    private boolean married;

    @SerializedName("8")
    @Expose
    private String accountType;

    @SerializedName("9")
    @Expose
    private String nextOfKinFirstName;

    @SerializedName("10")
    @Expose
    private String nextOfKinLastName;

    @SerializedName("11")
    @Expose
    private String nextOfKinPhoneNumber;

    @SerializedName("12")
    @Expose
    private boolean joint;

    @SerializedName("13")
    @Expose
    private String jointFirstName;

    @SerializedName("14")
    @Expose
    private String jointLastName;

    @SerializedName("15")
    @Expose
    private Long jointPhoneNumber;

    @SerializedName("16")
    @Expose
    private Long jointIdNumber;

    @SerializedName("17")
    @Expose
    private boolean debit;

    @SerializedName("18")
    @Expose
    private boolean credit;

    @SerializedName("19")
    @Expose
    private String image;

    @SerializedName("20")
    @Expose
    private Long date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEmployed() {
        return employed;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getNextOfKinFirstName() {
        return nextOfKinFirstName;
    }

    public void setNextOfKinFirstName(String nextOfKinFirstName) {
        this.nextOfKinFirstName = nextOfKinFirstName;
    }

    public String getNextOfKinLastName() {
        return nextOfKinLastName;
    }

    public void setNextOfKinLastName(String nextOfKinLastName) {
        this.nextOfKinLastName = nextOfKinLastName;
    }

    public String getNextOfKinPhoneNumber() {
        return nextOfKinPhoneNumber;
    }

    public void setNextOfKinPhoneNumber(String nextOfKinPhoneNumber) {
        this.nextOfKinPhoneNumber = nextOfKinPhoneNumber;
    }

    public boolean isJoint() {
        return joint;
    }

    public void setJoint(boolean joint) {
        this.joint = joint;
    }

    public String getJointFirstName() {
        return jointFirstName;
    }

    public void setJointFirstName(String jointFirstName) {
        this.jointFirstName = jointFirstName;
    }

    public String getJointLastName() {
        return jointLastName;
    }

    public void setJointLastName(String jointLastName) {
        this.jointLastName = jointLastName;
    }

    public Long getJointPhoneNumber() {
        return jointPhoneNumber;
    }

    public void setJointPhoneNumber(Long jointPhoneNumber) {
        this.jointPhoneNumber = jointPhoneNumber;
    }

    public Long getJointIdNumber() {
        return jointIdNumber;
    }

    public void setJointIdNumber(Long jointIdNumber) {
        this.jointIdNumber = jointIdNumber;
    }

    public boolean isDebit() {
        return debit;
    }

    public void setDebit(boolean debit) {
        this.debit = debit;
    }

    public boolean isCredit() {
        return credit;
    }

    public void setCredit(boolean credit) {
        this.credit = credit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
