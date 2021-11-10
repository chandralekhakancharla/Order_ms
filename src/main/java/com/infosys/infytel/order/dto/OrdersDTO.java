package com.infosys.infytel.order.dto;

import java.time.LocalDate;

import com.infosys.infytel.order.entity.Orders;

public class OrdersDTO {

	private Integer orderId;
	private String buyerId;
	private Float amount;
	private LocalDate date;
	private String address;
	private String status;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public OrdersDTO() {
		super();
	}

	// Converts Entity into DTO
	public static OrdersDTO valueOf(Orders plan) {
		OrdersDTO orderDTO= new OrdersDTO();
		orderDTO.setBuyerId(plan.getBuyerId());
		orderDTO.setAmount(plan.getAmount());
		orderDTO.setDate(java.time.LocalDate.now());
		orderDTO.setAddress(plan.getAddress());
		orderDTO.setStatus(plan.getStatus());
		return orderDTO;
	}
	
//	Converts DTO into Entity
	public Orders createEntity() {
		Orders Orders = new Orders();
		Orders.setOrderId(this.getOrderId());
		Orders.setBuyerId(this.getBuyerId());
		Orders.setAddress(this.getAddress());
		Orders.setAmount(this.getAmount());
		Orders.setDate(this.getDate());
		Orders.setStatus(this.getStatus());	
		return Orders;
	}
	
	@Override
	public String toString() {
		return "OrderDTO [buyerId=" + buyerId + ", amount=" + amount + ", date=" + date
				+ ", address=" + address + ", status=" + status + "]";
	}

		

		


}
