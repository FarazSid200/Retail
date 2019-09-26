package com.retail.billing;

import java.util.List;

import com.retail.entities.Product;
import com.retail.entities.User;

public interface IBilling {
	Double generateBill(List<Product>  prodRate, User user);

}
