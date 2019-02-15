package com.amazon.qa.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.qa.Base.Base;

import com.amazon.qa.Analyzer.CustomListner;
@Listeners(CustomListner.class)

public class LoginTest extends Base {

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initilization();
	}

	@Test
	public void loginTest() {
		driver.findElement(By.name(prop.getProperty("email"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath(prop.getProperty("continueBtnSignIn"))).click();
		driver.findElement(By.id(prop.getProperty("password_Xpath"))).sendKeys(prop.getProperty("password_Login"));
		driver.findElement(By.id(prop.getProperty("signInBtn"))).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
