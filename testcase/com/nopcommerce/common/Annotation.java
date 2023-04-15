package com.nopcommerce.common;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Annotation {
	
	@Test
	public void TC_01() {
		System.out.println("Run Testcase");
	}

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Run Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Run After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Run Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Run After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Run Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Run After Suite");
  }

}
