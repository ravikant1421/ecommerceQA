package com.ecommerceQA.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponents{
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="finish")
	WebElement finishbtn;
	
	public OrderCompletePage goforOrderCompletetion() {
		finishbtn.click();
		return new OrderCompletePage(driver);
	}

}
