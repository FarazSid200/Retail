package com.retail.utilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.retail.entities.Order;
import com.retail.entities.Product;
import com.retail.entities.ProductCategory;
import com.retail.entities.User;
import com.retail.entities.UserType;

public class Populate {
   
	public static Order getOrder(String userName, UserType type) {
		Order order = new Order();
		order.setOrderId(getRandomGUID());
		order.setProduct(getProducts());
		order.setUser(getUser(userName, type));
		return order;
	}

	public static List<Product> getProducts() {
		Product groceriesProd = getProduct(ProductCategory.GROCERIES, "Cups");
		Product foodProd = getProduct(ProductCategory.FOOD, "WHEAT");
		Product cosmeticsProd = getProduct(ProductCategory.COSMETICS, "CREAM");
		List<Product> products = new ArrayList<>();
		products.add(groceriesProd);
		products.add(foodProd);
		products.add(cosmeticsProd);
		return products;

	}

	public static Product getProduct(ProductCategory type, String name) {
		Product product = new Product();
		product.setName(name);
		product.setProductId(getRandomGUID());
		product.setPrice(new Double(150));
		product.setType(type);
		product.setCreatedAt(Calendar.getInstance());
		product.setUpdatedAt(Calendar.getInstance());
		return product;
	}

	public static User getUser(String name, UserType type) {
		User user = new User();
		user.setUserId(getRandomGUID());
		user.setUserName(name);
		user.setCreatedAt(Calendar.getInstance());
		user.setUpdatedAt(Calendar.getInstance());
		user.setType(type);
		return user;

	}

	private static String getRandomGUID() {
		return java.util.UUID.randomUUID().toString();
	}
}
