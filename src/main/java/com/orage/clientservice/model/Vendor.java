package com.orage.clientservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String phone;
    private String email;
    private String gstTreatment;
    private String gstin;
    private String pan;
    private String vat;
    private String website;
    private String vendorCode;
    private boolean useAsClient;
    private boolean useForDispatch;
    private String contactPerson;
    private String contactPhone;
    private String contactEmail;
    
    // Default constructor
    public Vendor() {
    }

    // All-args constructor
    public Vendor(String companyName, String phone, String email, String gstTreatment,
                  String gstin, String pan, String vat, String website, String vendorCode,
                  boolean useAsClient, boolean useForDispatch,String contactPerson,String contactPhone,String contactEmail) {
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
        this.gstTreatment = gstTreatment;
        this.gstin = gstin;
        this.pan = pan;
        this.vat = vat;
        this.website = website;
        this.vendorCode = vendorCode;
        this.useAsClient = useAsClient;
        this.useForDispatch = useForDispatch;
        this.contactPerson=contactPerson;
        this.contactPhone=contactPhone;
        this.contactEmail=contactEmail;
    }

    // Getters and Setters
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

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public boolean isUseAsClient() {
        return useAsClient;
    }

    public void setUseAsClient(boolean useAsClient) {
        this.useAsClient = useAsClient;
    }

    public boolean isUseForDispatch() {
        return useForDispatch;
    }

    public void setUseForDispatch(boolean useForDispatch) {
        this.useForDispatch = useForDispatch;
    }

     public String getContactPerson(){
        return contactPerson;
     }

    public void setContactPerson(String contactPerson){
     this.contactPerson=contactPerson;
    }
      public String getContactPhone(){
        return contactPhone;
     }

    public void setContactPhone(String contactPhone){
     this.contactPhone=contactPhone;
    }
      public String getContactEmail(){
        return contactEmail;
     }

    public void setContactEmail(String contactEmail){
     this.contactEmail=contactEmail;
    }
}
