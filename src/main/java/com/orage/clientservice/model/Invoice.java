package com.orage.clientservice.model;


import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "invoices")
public class Invoice {

	@Id
	@Column(name = "invoice_Id", updatable = false, nullable = false)
	private String invoice_Id = UUID.randomUUID().toString().replace("-", "");

	@NotEmpty(message = "Client name cannot be empty")
	@Column(name = "client_name") // Foreign key reference from client table
	private String client_name;

	@Column(name = "invoice_No")
	private Integer invoice_No;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "invoice_date")
	private Date invoice_date;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "invoice_due_date")
	private Date invoice_due_date;

	@Column(name = "purchase_No")
	private Integer purchase_No;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "purchase_date")
	private Date purchase_date;

	@Column(name = "payment_terms") // Dropdown list like as NET5 NET10
	private String payment_terms;

	@Column(name = "tax_selection_on")
	private String tax_selection_on;

	@Column(name = "export_type")
	private String export_type;

	@Column(name = "export_currency")
	private String export_currency;

	@Column(name = "country_supply")
	private String country_supply;

	@Column(name = "place_supply")
	private String place_supply;

	@Column(name = "excise_duty")
	private double excise_duty;

	@Column(name = "advance_payment") // Foreign key reference for payment
	private String advance_payment;

	@Column(name = "invoice_type") // Foreign key reference from invoice type table
	private String invoice_type;

	@NotEmpty(message = "Item name cannot be empty")
	@Column(name = "item_name") // Foreign key reference from item table
	private String item_name;

	@Column(name = "item_description")
	private String item_description;

	@Column(name = "hsn_sac")
	private String hsn_sac;

	@Column(name = "item_unit")
	private String item_unit;

	@Min(value = 1, message = "Item quantity must be greater than zero")
	@Column(name = "item_quantity")
	private double item_quantity;

	@Min(value = 1, message = "Item price must be greater than zero")
	@NotNull(message = "Item price cannot be null")
	@Column(name = "item_price")
	private Double item_price;

	@Min(value = 1, message = "Item discount must be greater than zero")
	@Column(name = "item_discount")
	private double item_discount;

	@Column(name = "tax_cgst_sgst_igst")
	private String tax_cgst_sgst_igst; // foreign key reference from tax table

	//@Min(value = 0, message = "shipping_charges must be greater than zero")
	@Column(name = "shipping_charges")
	private double shipping_charges;


	@Column(name = "total")
	private Double total;


    public String getInvoice_Id() {
        return invoice_Id;
    }

    public void setInvoice_Id(String invoice_Id) {
        this.invoice_Id = invoice_Id;
    }

    public @NotEmpty(message = "Client name cannot be empty") String getClient_name() {
        return client_name;
    }

    public void setClient_name(@NotEmpty(message = "Client name cannot be empty") String client_name) {
        this.client_name = client_name;
    }

    public Integer getInvoice_No() {
        return invoice_No;
    }

    public void setInvoice_No(Integer invoice_No) {
        this.invoice_No = invoice_No;
    }

    public Date getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(Date invoice_date) {
        this.invoice_date = invoice_date;
    }

    public Date getInvoice_due_date() {
        return invoice_due_date;
    }

    public void setInvoice_due_date(Date invoice_due_date) {
        this.invoice_due_date = invoice_due_date;
    }

    public Integer getPurchase_No() {
        return purchase_No;
    }

    public void setPurchase_No(Integer purchase_No) {
        this.purchase_No = purchase_No;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getPayment_terms() {
        return payment_terms;
    }

    public void setPayment_terms(String payment_terms) {
        this.payment_terms = payment_terms;
    }

    public String getTax_selection_on() {
        return tax_selection_on;
    }

    public void setTax_selection_on(String tax_selection_on) {
        this.tax_selection_on = tax_selection_on;
    }

    public String getExport_type() {
        return export_type;
    }

    public void setExport_type(String export_type) {
        this.export_type = export_type;
    }

    public String getExport_currency() {
        return export_currency;
    }

    public void setExport_currency(String export_currency) {
        this.export_currency = export_currency;
    }

    public String getCountry_supply() {
        return country_supply;
    }

    public void setCountry_supply(String country_supply) {
        this.country_supply = country_supply;
    }

    public String getPlace_supply() {
        return place_supply;
    }

    public void setPlace_supply(String place_supply) {
        this.place_supply = place_supply;
    }

    public double getExcise_duty() {
        return excise_duty;
    }

    public void setExcise_duty(double excise_duty) {
        this.excise_duty = excise_duty;
    }

    public String getAdvance_payment() {
        return advance_payment;
    }

    public void setAdvance_payment(String advance_payment) {
        this.advance_payment = advance_payment;
    }

    public String getInvoice_type() {
        return invoice_type;
    }

    public void setInvoice_type(String invoice_type) {
        this.invoice_type = invoice_type;
    }

    public @NotEmpty(message = "Item name cannot be empty") String getItem_name() {
        return item_name;
    }

    public void setItem_name(@NotEmpty(message = "Item name cannot be empty") String item_name) {
        this.item_name = item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getHsn_sac() {
        return hsn_sac;
    }

    public void setHsn_sac(String hsn_sac) {
        this.hsn_sac = hsn_sac;
    }

    public String getItem_unit() {
        return item_unit;
    }

    public void setItem_unit(String item_unit) {
        this.item_unit = item_unit;
    }

    @Min(value = 1, message = "Item quantity must be greater than zero")
    public double getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(@Min(value = 1, message = "Item quantity must be greater than zero") double item_quantity) {
        this.item_quantity = item_quantity;
    }

    public @Min(value = 1, message = "Item price must be greater than zero") @NotNull(message = "Item price cannot be null") Double getItem_price() {
        return item_price;
    }

    public void setItem_price(@Min(value = 1, message = "Item price must be greater than zero") @NotNull(message = "Item price cannot be null") Double item_price) {
        this.item_price = item_price;
    }

    @Min(value = 1, message = "Item discount must be greater than zero")
    public double getItem_discount() {
        return item_discount;
    }

    public void setItem_discount(@Min(value = 1, message = "Item discount must be greater than zero") double item_discount) {
        this.item_discount = item_discount;
    }

    public String getTax_cgst_sgst_igst() {
        return tax_cgst_sgst_igst;
    }

    public void setTax_cgst_sgst_igst(String tax_cgst_sgst_igst) {
        this.tax_cgst_sgst_igst = tax_cgst_sgst_igst;
    }

    public double getShipping_charges() {
        return shipping_charges;
    }

    public void setShipping_charges(double shipping_charges) {
        this.shipping_charges = shipping_charges;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
