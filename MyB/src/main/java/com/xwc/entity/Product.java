package com.xwc.entity;

import java.util.List;

public class Product {
	
	private int proId;
	private String proName;
	private String proDesc;
	
	private List<OrderDetails> orderDetails;
	
	public Product() {
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProDesc() {
		return proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}

	@Override
	public String toString() {
		return "Product [proId=" + proId + ", proName=" + proName + ", proDesc=" + proDesc + ", orderDetails="
				+ orderDetails + "]";
	}
	
	
}
