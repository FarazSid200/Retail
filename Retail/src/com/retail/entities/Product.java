package com.retail.entities;

import java.util.Calendar;

public class Product {
	private String productId;
	private String name;
	private ProductCategory type;
	private Double price;
	private Calendar createdAt;
	private Calendar updatedAt;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public ProductCategory getType() {
		return type;
	}
	public void setType(ProductCategory type) {
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
