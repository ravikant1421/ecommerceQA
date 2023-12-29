package com.ecommerceQA.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class LoginVarificatonTest extends Base{
	@Test
	public void loginVarification() {
		loginPage.loginApplication(user, paswword);
		String message=loginPage.getSucessMessage();
		assertEquals(message, "Products");
	}
	@Test
	public void checkForWrongUser() {
		loginPage.loginApplication("dfdgs", "fgsdfg");
		String message=loginPage.getErrorMessage();
		assertEquals(message, "Epic sadface: Username and password do not match any user in this service");
	}
	
	
}
