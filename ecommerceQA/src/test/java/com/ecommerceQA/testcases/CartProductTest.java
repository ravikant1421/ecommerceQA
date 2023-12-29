package com.ecommerceQA.testcases;

import java.util.List;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.testng.annotations.Test;

import com.ecommerceQA.pageobjects.CartPage;
import com.ecommerceQA.pageobjects.ProductsPage;

public class CartProductTest extends Base {
	@Test
	public void validProductsIncart() {
		List<String> productsToAdd = new ArrayList<>();
		productsToAdd.add("Sauce Labs Backpack");
		productsToAdd.add("Sauce Labs Bike Light");
		productsToAdd.add("Sauce Labs Fleece Jacket");
		ProductsPage productsPage = loginPage.loginApplication(user, paswword);
		for (String product : productsToAdd) {
			productsPage.addProduct(product);
		}
		CartPage cartPage = productsPage.gotocart();
		List<String> products = cartPage.getAllCartProducts();
		Collections.sort(productsToAdd);
		Collections.sort(products);
		if (products.size() != productsToAdd.size()) {
			assertEquals(products.size(), productsToAdd.size());
		} else {
			for (int i = 0; i < products.size(); i++) {
				if (products.get(i) != productsToAdd.get(i)) {
					assertEquals(products.get(i), productsToAdd.get(i));
				}
			}
		}

	}

}
