package com.ecommerceQA.pageobjects;

import org.openqa.selenium.WebDriver;

public class AbstractComponents {
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
	}
	
	public CartPage gotocart(){
		return new CartPage(driver);
	}
}
