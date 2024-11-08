package com.orage.clientservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//TEst comment

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String phone;
    private String email;
    private String gstTreatment;
    private String gstin;
    private String pan;
    private String tin;
    private String vat;
    private String website;
    private boolean useAsVendor;

    // Constructors
    public Client() {}

    public Client(String companyName, String phone, String email, String gstTreatment, String gstin, String pan, String tin, String vat, String website, boolean useAsVendor) {
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
        this.gstTreatment = gstTreatment;
        this.gstin = gstin;
        this.pan = pan;
        this.tin = tin;
        this.vat = vat;
        this.website = website;
        this.useAsVendor = useAsVendor;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGstTreatment() {
        return gstTreatment;
    }

    public void setGstTreatment(String gstTreatment) {
        this.gstTreatment = gstTreatment;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isUseAsVendor() {
        return useAsVendor;
    }

    public void setUseAsVendor(boolean useAsVendor) {
        this.useAsVendor = useAsVendor;
    }
}
