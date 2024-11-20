package com.orage.clientservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "invoice_item")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    @JsonIgnore
    private Invoices invoice;

    private String itemName;
    private String description;
    private String hsnSac;
    private Integer itemQuantity;
    private Double itemPrice;
    @Column(nullable = true)
    private Double itemDiscount = 0.0;  // Default value of 0.0
    @Column(nullable = true)
    private Double itemGst = 0.0;  // Default value of 0.0

    private Double total;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invoices getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoices invoice) {
        this.invoice = invoice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getHsnSac() {
        return hsnSac;
    }

    public void setHsnSac(String hsnSac) {
        this.hsnSac = hsnSac;
    }

    public Double getItemDiscount() {
        return itemDiscount != null ? itemDiscount : 0.0;
    }

    public void setItemDiscount(Double itemDiscount) {
        this.itemDiscount = (itemDiscount != null) ? itemDiscount : 0.0;
    }

    public Double getItemGst() {
        return itemGst != null ? itemGst : 0.0;
    }

    public void setItemGst(Double itemGst) {
        this.itemGst = (itemGst != null) ? itemGst : 0.0;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}

