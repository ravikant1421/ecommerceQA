package com.ecommerceQA.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

	        // Wait for the form to be present
	        WebElement formElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("form")));
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		postalCode.sendKeys(pstlcode);
	}
	public CheckoutPage checkout() {
		continuebtn.click();
		return new CheckoutPage(driver);
	}
	

}
