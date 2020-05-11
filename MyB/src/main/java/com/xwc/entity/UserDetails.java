package com.xwc.entity;

public class UserDetails {
	
	private int udId ;
	private String userAddr;
	private String userPhone;
	private int userId;
	
	
	public UserDetails() {
	}

	public int getUdId() {
		return udId;
	}

	public void setUdId(int udId) {
		this.udId = udId;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserDetails [udId=" + udId + ", userAddr=" + userAddr + ", userPhone=" + userPhone + ", userId="
				+ userId + "]";
	}

}
