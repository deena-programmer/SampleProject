package com.base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public abstract class Base_Class {

	public static WebDriver driver;
	
	public static ExtentReports extentReports;
	
	public static File file;

	//Launch browser
	protected  static void browserLaunch(String browserName) { 
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();		
			}else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING THE VALUE PASSING");
		}
	}
	//Get Title
	protected static void getTitles() {
		try {
			String title = driver.getTitle();
			System.out.println("" + title);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING GETTING TITLE");
		}
	}
	protected static void getURL(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING LAUNCHING THE URL");
		}
	}
	protected static void printCurrentURL() {
		try {
			String printCurrentURL = driver.getCurrentUrl();
			System.out.println(""+ printCurrentURL);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING LAUNCHING THE CURRENT URL");
		}
	}
	protected static void implicitlyWait(String type, int duration) {
		if (type.equalsIgnoreCase("seconds")) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
		} else if(type.equalsIgnoreCase("minutes")) {
			driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(duration));
		}
	}
	protected static void inputPassing(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING THE VALUE PASSING");
		}
	}
	protected static void elementclick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING THE CLICKING THE ELEMENT");
		}
	}
	protected static void launchingURL(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING LAUNCHING THE URL");
		}
	}
	protected static void navigateMethods(String type) {
		if (type.equalsIgnoreCase("back")) {
			driver.navigate().back();
		} else if (type.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		} else if (type.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		}	
	}
	protected static void navigateToURL(String navigateURL) {
		driver.navigate().to(navigateURL);
	}
	protected static void staticWait(int milisec) {
		try {
			Thread.sleep(milisec);
		} catch (InterruptedException e) {
			
		}
	}
	protected static void selectDropDown(WebElement element, String type, String value) {
		Select select = new Select(element);
		
		try {
			if (type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("text")) {
				select.selectByValue(value);
			} else if (type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			}
			
		} catch (NumberFormatException e) {

		}
	}
	protected static void elementIsEnable(WebElement element) {
		boolean enable = element.isEnabled();
		System.out.println("The Element is Enabled :" + enable);
	}
	
	protected static void alert(String options) {
		try {
			Alert a = driver.switchTo().alert();
			if (options.equalsIgnoreCase("accept")) {
				a.accept();
			} else if (options.equalsIgnoreCase("dismiss")){
				a.dismiss();
			}
		} catch (Exception e) {

		}
	}
	protected static void scrollToElement(WebElement element, String type) {
		try {
			if (type.equalsIgnoreCase("viewelement")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", element);
			} else if (type.equalsIgnoreCase("click")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", element);
			}
		} catch (Exception e) {

		}
	}
	protected static void sessionTerminate(String options) {
		try {
			if (options.equalsIgnoreCase("close")) {
				driver.close();
			} else if(options.equalsIgnoreCase("quit")){
				driver.quit();
			}
		} catch (Exception e) {

		}
	}
	public static void extentReportstart(String location) {
		extentReports = new ExtentReports();
		file = new File(location);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}
	public static void extentReportTearDown(String location) throws IOException {
		extentReports.flush();
		file = new File(location);
		Desktop.getDesktop().browse((file).toURI());
	}
	public String takeScreenshot() throws IOException{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("C:\\Users\\ELCOT\\eclipse-workspace\\NaukriProject\\Screenshot" + timeStamp + ".png");
		FileHandler.copy(scrfile, destfile);
		return destfile.getAbsolutePath();		
	}
}