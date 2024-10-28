package com.orage.clientservice.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vendorName;
    private String orderNumber;
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Temporal(TemporalType.DATE)
    private Date validUntil;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_order_id")
    private List<PurchaseOrderItem> items;

    
    // Constructors, Getters, and Setters
    public PurchaseOrder() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

//    public Date getOrderDate() {
//        return orderDate;
//        Date;
//    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public List<PurchaseOrderItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseOrderItem> items) {
        this.items = items;
    }
}
