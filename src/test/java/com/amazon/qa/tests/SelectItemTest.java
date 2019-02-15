package com.amazon.qa.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.Base.Base;
import com.amazon.qa.Util.UtilityMethods;

public class SelectItemTest extends Base {

	LoginTest loginTest = new LoginTest();
	ItemSearchTest itemSearchTest=new ItemSearchTest();

	public SelectItemTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		loginTest.loginTest();
	}

	@Test
	public void SelectItemShopTest() {
		itemSearchTest.searchItem("Heels");
		List<WebElement> list=driver.findElements(By.xpath("//ul[@role='radiogroup']//li"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}