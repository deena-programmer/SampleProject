package com.testing;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.base.Base_Class;

public class CrossBrowser extends Base_Class{
	
	@Test(enabled = false)
	private void firefox() {
		browserLaunch("firefox");
		launchingURL("https://www.google.com/");
		System.out.println("BROWSER ID : " + Thread.currentThread().getId());
	}
	
	@Test	
	private void edge() {
		browserLaunch("edge");
		launchingURL("https://www.google.com/");
		System.out.println("BROWSER ID : " + Thread.currentThread().getId());
	}
	
	@Ignore()
	@Test
	private void chrome() {
		browserLaunch("chrome");
		launchingURL("https://www.google.com/");
		System.out.println("BROWSER ID : " + Thread.currentThread().getId());
	}
}
