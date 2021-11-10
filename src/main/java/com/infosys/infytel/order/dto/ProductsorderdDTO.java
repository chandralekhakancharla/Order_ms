package com.infosys.infytel.order.dto;

import com.infosys.infytel.order.entity.Productsorderd;

public class ProductsorderdDTO {
	
	private String sellerId;
	private String buyerId;
	private Integer quantity;
	private String prodId;

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
	
	public ProductsorderdDTO() {
		super();
	}

	// Converts Entity into DTO
	public static ProductsorderdDTO valueOf(Productsorderd plan) {
		ProductsorderdDTO orderDTO= new ProductsorderdDTO();
		orderDTO.setBuyerId(plan.getBuyerId());
		orderDTO.setSellerId(plan.getSellerId());
		orderDTO.setProdId(plan.getProdId());
		orderDTO.setQuantity(plan.getQuantity());
		return orderDTO;
	}
	@Override
	public String toString() {
		return "OrderDTO [sellerId=" + sellerId + ", buyerId=" + buyerId
				+ ", quantity=" + quantity + ", prodId=" + prodId + "]";
	}
}
