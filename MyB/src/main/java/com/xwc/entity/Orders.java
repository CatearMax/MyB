package com.xwc.entity;

import java.util.List;

public class Orders {
	
	private int orderId;
	private String orderTime;
	private int orderState;
	private int userId;
	
	private List<User> user;
	
	public Orders() {
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderTime=" + orderTime + ", orderState=" + orderState + ", userId="
				+ userId + ", user=" + user + "]";
	}
	
	
	
	
}
