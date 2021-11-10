package com.infosys.infytel.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productsorderd")
public class Productsorderd {
	@Column(name = "seller_id", nullable = false)
	private String sellerId;
	@Id
	@Column(name = "buyer_id", nullable = false)
	private String buyerId;
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	@Column(name = "prod_id", nullable = false)
	private String prodId;
	
	public Productsorderd() {
		super();
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
}
