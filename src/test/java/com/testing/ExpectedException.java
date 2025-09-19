package com.testing;

import org.testng.annotations.Test;

public class ExpectedException {

	@Test(expectedExceptions = ArithmeticException.class)
	
	private void method1() {
	System.out.println("Method 1");	
	}
	
	@Test
	private void method2() {
		System.out.println("Method 2");	
	}
	
	@Test
	private void method3() {
		System.out.println("Method 3");	
	}
}
