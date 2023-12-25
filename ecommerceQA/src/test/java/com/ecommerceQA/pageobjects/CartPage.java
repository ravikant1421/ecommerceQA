package com.ecommerceQA.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponents {
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="checkout")
	WebElement continueBtn;
	
	public UserDetailPage gotoCheckoutforUserDetail() {
		return new UserDetailPage(driver);
	}

}
