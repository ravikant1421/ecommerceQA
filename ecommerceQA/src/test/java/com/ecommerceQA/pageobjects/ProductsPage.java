package com.ecommerceQA.pageobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends AbstractComponents {

	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "inventory_item")
	List<WebElement> products;

	@FindBy(className = "product_sort_container")
	WebElement filterSelectBar;

	public void selectIntoSelectBar(String option) {
		Select dropDown = new Select(filterSelectBar);
		dropDown.selectByVisibleText(option);

	}

	public WebElement getProduct(String productName) {
		
		return products.stream().filter(
				product -> product.findElement(By.cssSelector(".inventory_item_name ")).getText().equals(productName))
				.findFirst().orElse(null);
	}

	public List<String> getAllProducts() {
		List<String> arl = new ArrayList<>();
		arl = products.stream().map(product -> product.findElement(By.cssSelector(".inventory_item_name ")).getText())
				.collect(Collectors.toList());
		return arl;
	}

	public void addProduct(String productName) {
		WebElement prod = getProduct(productName);
		prod.findElement(By.xpath(".//button[text()='Add to cart']")).click();
	}
}
