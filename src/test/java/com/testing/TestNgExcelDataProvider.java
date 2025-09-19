package com.testing;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.base.Base_Class;

public class TestNgExcelDataProvider extends Base_Class {
	
	@DataProvider(name = "excelDataProvider")
	public Object[][] dataProviderMethod() {
		String filepath = System.getProperty("user.dir") + "\\Excel\\TestData.xlsx";
		String sheetName = "data";
		return ExcelReader.getExcelData(filepath, sheetName);
	}
	
	@Test(dataProvider = "excelDataProvider")
	private void testsMethod(String username, String password) {
		launchingURL("chrome");
		implicitlyWait("seconds", 4);
		getURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		System.out.println("Username :" + username + "| Password : " + password);
	}
}