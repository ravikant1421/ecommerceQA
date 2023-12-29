package com.ecommerceQA.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(className = "shopping_cart_link")
	WebElement cart;
	
	public CartPage gotocart(){
		cart.click();
		return new CartPage(driver);
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait= new WebDriverWait (driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf (findBy));	
	}
}
