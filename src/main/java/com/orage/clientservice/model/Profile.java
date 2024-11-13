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

}

