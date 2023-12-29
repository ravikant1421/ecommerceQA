package com.ecommerceQA.testcases;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.ecommerceQA.pageobjects.ProductsPage;

import dev.failsafe.internal.util.Assert;

public class FilterResultTest extends Base {

	@Test
	public void filterTestByName() {
		String option = "Name (Z to A)";
		ProductsPage productsPage = loginPage.loginApplication(user, paswword);
		productsPage.selectIntoSelectBar(option);
		List<String> products = productsPage.getAllProducts();
		List<String> productsSroted = productsPage.getAllProducts();
		if (option == "Name (A to Z)") {
			Collections.sort(productsSroted);
			for (int i = 0; i < products.size(); i++) {
				if(products.get(i)!= productsSroted.get(i)) {
					assertEquals(products.get(i),productsSroted.get(i));
				}
			}
		}else if (option == "Name (Z to A)") {
			Collections.sort(productsSroted,Collections.reverseOrder());
			for (int i = 0; i < products.size(); i++) {
				if(products.get(i)!= productsSroted.get(i)) {
					assertEquals(products.get(i),productsSroted.get(i));
				}
			}
		}

	}
}
