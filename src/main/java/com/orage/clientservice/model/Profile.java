package com.orage.clientservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob // For storing the logo file
    private byte[] logo;

    @NotNull
    private String companyName;

    @NotNull
    private String currency;

    @NotNull
    private String country;

    @NotNull
    private String state;

    @NotNull
    private String city;

    @NotNull
    private String address;

    @Email
    private String email;

    private String phone;
    private String gstin;
    private String contactName;
    private String pinCode;
    private String website;
    private String taxationType;
    private String serviceTaxNo;

    private String bankName;
    private String branchName;
    private String adCode;
    private String upiId;
    private String accountNumber;
    private String ifscCode;
    private String swiftCode;
    private String accountHolderName;
    private String tinNo;
    private String lst;
    private String pan;
    private String fassaiNo;
    private String dlNo;
    private String cst;
    private String tan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceTaxNo() {
        return serviceTaxNo;
    }

    public void setServiceTaxNo(String serviceTaxNo) {
        this.serviceTaxNo = serviceTaxNo;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public @NotNull String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(@NotNull String companyName) {
        this.companyName = companyName;
    }

    public @NotNull String getCurrency() {
        return currency;
    }

    public void setCurrency(@NotNull String currency) {
        this.currency = currency;
    }

    public @NotNull String getCountry() {
        return country;
    }

    public void setCountry(@NotNull String country) {
        this.country = country;
    }

    public @NotNull String getState() {
        return state;
    }

    public void setState(@NotNull String state) {
        this.state = state;
    }

    public @NotNull String getCity() {
        return city;
    }

    public void setCity(@NotNull String city) {
        this.city = city;
    }

    public @NotNull String getAddress() {
        return address;
    }

    public void setAddress(@NotNull String address) {
        this.address = address;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTaxationType() {
        return taxationType;
    }

    public void setTaxationType(String taxationType) {
        this.taxationType = taxationType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getTinNo() {
        return tinNo;
    }

    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    public String getLst() {
        return lst;
    }

    public void setLst(String lst) {
        this.lst = lst;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getFassaiNo() {
        return fassaiNo;
    }

    public void setFassaiNo(String fassaiNo) {
        this.fassaiNo = fassaiNo;
    }

    public String getDlNo() {
        return dlNo;
    }

    public void setDlNo(String dlNo) {
        this.dlNo = dlNo;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getTan() {
        return tan;
    }

    public void setTan(String tan) {
        this.tan = tan;
    }
}

