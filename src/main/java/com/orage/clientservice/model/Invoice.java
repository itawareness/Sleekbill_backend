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

}
