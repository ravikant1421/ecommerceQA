package com.ecommerceQA.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDetailPage extends AbstractComponents{
	
	WebDriver driver;
	public UserDetailPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="first-name")
	WebElement firstName;
	@FindBy(id="last-name")
	WebElement lastName;
	@FindBy(id="postal-code")
	WebElement postalCode;
	@FindBy(id="continue")
	WebElement continuebtn;
	
	public void addUserDetail(String fname, String lname, String pstlcode ) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		postalCode.sendKeys(pstlcode);
	}
	public CheckoutPage checkout() {
		continuebtn.click();
		return new CheckoutPage(driver);
	}
	

}
