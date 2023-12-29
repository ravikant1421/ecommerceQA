package com.ecommerceQA.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.ecommerceQA.pageobjects.LoginPage;

public class Base {
	WebDriver driver;
	String user="standard_user";
	String paswword="secret_sauce";
	String url ="https://www.saucedemo.com/";
	public LoginPage loginPage;
	
	
	@BeforeTest
	public LoginPage launchApplication() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return loginPage=new LoginPage(driver);
	}
	
	@AfterTest
	public void terminate() {
		driver.close();
	}
	
	
}
