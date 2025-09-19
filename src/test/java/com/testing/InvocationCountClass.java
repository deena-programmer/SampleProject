package com.testing;

import org.testng.annotations.Test;

import com.base.Base_Class;

public class InvocationCountClass extends Base_Class{

	@Test(invocationCount = 2)
	private void demo() {
		
		browserLaunch("Chrome");
		launchingURL("https://www.facebook.com/");
		sessionTerminate("close");
	}
}
