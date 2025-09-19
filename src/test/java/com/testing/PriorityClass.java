package com.testing;

import org.testng.annotations.Test;

public class PriorityClass {

	@Test 
	private void login() {
		System.out.println("LOGIN");
	}
	@Test (dependsOnMethods = {"login"})
	private void search() {
		System.out.println(10/0);
		System.out.println("SEARCH");
	}
	@Test (dependsOnMethods = {"login","search"})
	private void addToCart() {
		System.out.println("ADD TO CART");
	}
}
