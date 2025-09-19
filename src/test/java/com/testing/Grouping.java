package com.testing;

import org.testng.annotations.Test;

public class Grouping {

	@Test(groups = "subjects")
	private void english() {
		System.out.println("English");
	}
	
	@Test(groups = "subjects")
	private void tamil() {
		System.out.println("Tamil");
	}
	
	@Test(groups = "subjects")
	private void malayalam() {
		System.out.println("Malayalam");
	}
	
	@Test(groups = "degree")
	private void bsc() {
		System.out.println("B.Sc");
	}
	
	@Test(groups = "degree")
	private void bcom() {
		System.out.println("B.Com");
	}
	
	@Test(groups = "degree")
	private void BE() {
		System.out.println("BE");
	}
}