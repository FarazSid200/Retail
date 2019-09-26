package com.retail.billing;

import static com.retail.utilities.Constant.PRODUCT_TYPE_GROCERIES;
import static com.retail.utilities.Constant.PRODUCT_TYPE_OTHER;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.retail.entities.Product;
import com.retail.entities.User;
import com.retail.entities.UserType;

public class BillingImpl implements IBilling {

	@Override
	public Double generateBill(List<Product> products, User user) {
		if (null != products && !products.isEmpty()) {
			Map<String, Double> billProdType = getBillProdType(products);
			Double bill = generateBillBasedOnCustomer(
					billProdType.get(PRODUCT_TYPE_OTHER), user);
			bill = bill + billProdType.get(PRODUCT_TYPE_GROCERIES);
			return bill;
		}
		return null;
	}

	private Map<String, Double> getBillProdType(List<Product> products) {
		final Map<String, Double> billProdType = new HashMap<>();
		for (Product product : products) {
			if (PRODUCT_TYPE_GROCERIES.equals(product.getType().toString()))
					 {
				if (billProdType.containsKey(PRODUCT_TYPE_GROCERIES)) {
					Double bill = billProdType.get(PRODUCT_TYPE_GROCERIES);
					billProdType.put(PRODUCT_TYPE_GROCERIES,
							bill + product.getPrice());
				} else {
					billProdType
							.put(PRODUCT_TYPE_GROCERIES, product.getPrice());
				}

			} else {
				if (billProdType.containsKey(PRODUCT_TYPE_OTHER)) {
					Double bill = billProdType.get(PRODUCT_TYPE_OTHER);
					billProdType.put(PRODUCT_TYPE_OTHER,
							bill + product.getPrice());
				} else {
					billProdType.put(PRODUCT_TYPE_OTHER, product.getPrice());
				}
			}
		}
		return billProdType;

	}

	private Double generateBillBasedOnCustomer(Double bill, User user) {
		Enum userType = user.getType();

		if (UserType.EMP == userType) {
			bill = bill - bill * 30 / 100;
		} else if (UserType.AFFILIATE == userType) {
			bill = bill - bill * 10 / 100;
		} else if (UserType.NORMAL == userType) {
			if (isCustomerOver2Years(user)) {
				bill = bill - bill * 5 / 100;
			} else {
				bill = bill - get100Count(bill);
			}
		}
		return bill;
	}

	private boolean isCustomerOver2Years(User user) {
		Long totalYear = ChronoUnit.YEARS.between(user.getCreatedAt()
				.toInstant(), Calendar.getInstance().toInstant());

		return totalYear >= 2;
	}

	private int get100Count(Double bill) {
		int digit = (int) Math.log10(bill);
		int count = bill.intValue() / (int) Math.pow(10, digit);
		return 5 * count;
	}
}
