package com.orage.clientservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    // Sales Information
    private double salesUnitPrice;
    private String currency; // Assuming same currency field for sales and purchase
    private double salesCess; // Additional tax or fee on sales

    // Purchase Information
    private double purchaseUnitPrice;
    private double purchaseCess; // Additional tax or fee on purchase

    private int quantity;
    private String unit; // Unit of measurement (e.g., kg, liters)

    // Tax Information
    private String tax; // Tax type or rate
    private String hsn; // Harmonized System Nomenclature code

    // Additional Information
    private String sku; // Stock Keeping Unit

    // Constructors
    public Item() {}

    public Item(String name, String description, double salesUnitPrice, double purchaseUnitPrice,
                double salesCess, double purchaseCess, int quantity, String unit, String tax,
                String hsn, String sku, String currency) {
        this.name = name;
        this.description = description;
        this.salesUnitPrice = salesUnitPrice;
        this.purchaseUnitPrice = purchaseUnitPrice;
        this.salesCess = salesCess;
        this.purchaseCess = purchaseCess;
        this.quantity = quantity;
        this.unit = unit;
        this.tax = tax;
        this.hsn = hsn;
        this.sku = sku;
        this.currency = currency;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalesUnitPrice() {
        return salesUnitPrice;
    }

    public void setSalesUnitPrice(double salesUnitPrice) {
        this.salesUnitPrice = salesUnitPrice;
    }

    public double getPurchaseUnitPrice() {
        return purchaseUnitPrice;
    }

    public void setPurchaseUnitPrice(double purchaseUnitPrice) {
        this.purchaseUnitPrice = purchaseUnitPrice;
    }

    public double getSalesCess() {
        return salesCess;
    }

    public void setSalesCess(double salesCess) {
        this.salesCess = salesCess;
    }

    public double getPurchaseCess() {
        return purchaseCess;
    }

    public void setPurchaseCess(double purchaseCess) {
        this.purchaseCess = purchaseCess;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getHsn() {
        return hsn;
    }

    public void setHsn(String hsn) {
        this.hsn = hsn;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
