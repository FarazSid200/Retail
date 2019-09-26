package com.retail.entities;

import java.util.Calendar;

public class User {

	private String userId;
	private String userName;
	private UserType type;
	private Calendar createdAt;
	private Calendar updatedAt;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	public Calendar getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}

}
