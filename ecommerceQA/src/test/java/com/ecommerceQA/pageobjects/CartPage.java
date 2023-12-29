package com.ecommerceQA.pageobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
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
	
	@FindBy(className="cart_item")
	List<WebElement> cartProducts;
	
	public UserDetailPage gotoCheckoutforUserDetail() {
		continueBtn.click();
		return new UserDetailPage(driver);
	}
	public List<String> getAllCartProducts() {
		List<String> arl=new ArrayList<>();
		arl=cartProducts.stream().map(product -> product.findElement(By.cssSelector(".inventory_item_name "))
				.getText()).collect(Collectors.toList());
		return arl;
	}

}
