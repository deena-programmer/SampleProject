package com.testing;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base_Class;

public class Parameterizationclass extends Base_Class{

	@Test @Parameters({"username","password"})
	private void testMethod(String username, String password) {
		launchingURL("chorme");
		implicitlyWait("seconds", 5);
		getURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
	}
}
