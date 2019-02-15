package com.amazon.qa.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.amazon.qa.Base.Base;

public class TestUtil extends Base {

	static Workbook book;
	static Sheet sheet;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\HP\\workspace\\AmazonFrontEndAutomation\\src\\main\\java\\com\\amazon\\qa\\testdata\\AmazonTestData.xlsx";

	// get data from excel:
	public static Object[][] getDataFromSheet(String sheetName) {

		// To read data
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// created XL workbook
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// need to get sheet name
		sheet = book.getSheet(sheetName);
		// this method return object[][] array
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + "--------" + sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {// rows
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {// columns
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}

	

}
