package com.ecommerceQA.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends AbstractComponents {
	
	WebDriver driver;
	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="inventory_item")
	List<WebElement> products;
	
	private WebElement getProduct(String productName) {
		return products.stream().filter(product->product.findElement(By.cssSelector(".inventory_item_name ")).getText().equals(productName)).findFirst().orElse(null);
	}
	public void addProduct(String productName) {
		WebElement prod=getProduct(productName);
		prod.findElement(By.cssSelector("#remove-sauce-labs-backpack")).click();
	}
}
