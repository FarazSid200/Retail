package com.retail.application;

import com.retail.billing.BillingImpl;
import com.retail.billing.IBilling;
import com.retail.entities.Order;
import com.retail.entities.UserType;
import com.retail.utilities.Populate;

public class Application {
	
	
	
	
	public static void main(String[] args) {
		Order order = Populate.getOrder("Faraz", UserType.EMP);
		IBilling billing = new BillingImpl();
		System.out.println(billing.generateBill(order.getProduct(), order.getUser()));
	}

}
