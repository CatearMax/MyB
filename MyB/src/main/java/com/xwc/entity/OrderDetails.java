package com.xwc.entity;

import java.io.Serializable;
import java.util.List;

public class OrderDetails implements Serializable {
	
	private int odId;
	private int proId;
	private int orderId;
	private int odNum;
	
	private Orders orders;
	private List<Product> products;

	public OrderDetails() {
	}

	public int getOdId() {
		return odId;
	}

	public void setOdId(int odId) {
		this.odId = odId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOdNum() {
		return odNum;
	}

	public void setOdNum(int odNum) {
		this.odNum = odNum;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrderDetails [odId=" + odId + ", odNum=" + odNum + "]";
	}

}
