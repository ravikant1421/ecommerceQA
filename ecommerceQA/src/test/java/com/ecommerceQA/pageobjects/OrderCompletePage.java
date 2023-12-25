package com.ecommerceQA.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderCompletePage extends AbstractComponents {
	
	WebDriver driver;
	public OrderCompletePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="complete-header")
	WebElement textMessage;
	
	public String getOrderSuccesMessage() {
		return textMessage.getText();
	}
}
