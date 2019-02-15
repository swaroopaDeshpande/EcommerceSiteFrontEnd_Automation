package com.amazon.qa.Util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.Base.Base;

public class UtilityMethods extends Base {

	public static void selectValuefromDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		// Files.createFile("currentDir + "/screenshots/" +
		// System.currentTimeMillis() + ".png")));"
	}

	public static void ExpliciteTimeout(WebElement element, int Time) {
		WebDriverWait wait = new WebDriverWait(driver, Time);
		wait.until(ExpectedConditions.titleContains(Constants.homepage_title));
	}

	public static void failedTcScreenshots(String testMethodName) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,
					new File("C:\\Users\\HP\\workspace\\TestNGPracto\\src\\main\\java\\Screenshots\\" + testMethodName
							+ "_" + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
