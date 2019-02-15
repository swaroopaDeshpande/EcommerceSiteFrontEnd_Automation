package com.amazon.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.qa.Analyzer.CustomListner;
import com.amazon.qa.Base.Base;
import com.amazon.qa.Util.Constants;
import com.amazon.qa.Util.TestUtil;
import com.amazon.qa.Util.UtilityMethods;

@Listeners(CustomListner.class)

public class ItemSearchTest extends Base {

	LoginTest loginTest = new LoginTest();

	public ItemSearchTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initilization();
		loginTest.loginTest();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = TestUtil.getDataFromSheet("SearchItems");
		return data;
	}

	@Test(dataProvider = "getData")
	public void searchItem(String item) {
		Assert.assertEquals(driver.getTitle(), Constants.homepage_title);
		WebElement SearchBox = driver.findElement(By.id(prop.getProperty("Searchbox_Xpath")));
		SearchBox.sendKeys(item);
		SearchBox.sendKeys(Keys.ENTER);
		WebElement sort = driver.findElement(By.id("sort"));
		UtilityMethods.selectValuefromDropDown(sort, "Price: High to Low");
		// WebElement SortBySize = driver.findElement(By.xpath(
		// "//ul[@class='a-unordered-list a-nostyle a-button-list a-declarative
		// a-button-toggle-group a-horizontal s-ref-indent-none' and
		// @role='radiogroup']//li//span//div//span[text()='6']"));
		// SortBySize.click();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
