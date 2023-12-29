package com.ecommerceQA.testcases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.ecommerceQA.pageobjects.CartPage;
import com.ecommerceQA.pageobjects.CheckoutPage;
import com.ecommerceQA.pageobjects.OrderCompletePage;
import com.ecommerceQA.pageobjects.ProductsPage;
import com.ecommerceQA.pageobjects.UserDetailPage;

public class SubmitOrderTest extends Base {
	@Test
	public void submitProduct() {
		String userName="Ravikant";
		String lastName="Verma";
		String postalCode="333333";
		List<String> productsToAdd = new ArrayList<>();
		productsToAdd.add("Sauce Labs Backpack");
		productsToAdd.add("Sauce Labs Bike Light");
		productsToAdd.add("Sauce Labs Fleece Jacket");
		ProductsPage productsPage = loginPage.loginApplication(user, paswword);
		for (String product : productsToAdd) {
			productsPage.addProduct(product);
		}
		CartPage cartPage = productsPage.gotocart();
		UserDetailPage userDetailPage = cartPage.gotoCheckoutforUserDetail();
		userDetailPage.addUserDetail(userName, lastName, postalCode);
		CheckoutPage checkoutPage = userDetailPage.checkout();
		OrderCompletePage orderComplection = checkoutPage.goforOrderCompletetion();
		String message = orderComplection.getOrderSuccesMessage();
		assertEquals(message, "Thank you for your order!");
	}

}
