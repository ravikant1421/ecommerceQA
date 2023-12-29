package com.ecommerceQA.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="user-name")
	WebElement userName;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="login-button")
	WebElement loginBtn;
	@FindBy(css="div[class*='error-message']")
	WebElement errorText;
	@FindBy(css="span[class='title']")
	WebElement titleText;
	
	public ProductsPage loginApplication(String user,String psw) {
		System.out.print(user);
		userName.sendKeys(user);
		password.sendKeys(psw);
		loginBtn.click();
		return new ProductsPage(driver);
	}
	public String getErrorMessage() {
		return errorText.getText();
	}
	public String getSucessMessage() {
		return titleText.getText();
	}
	
	
}
