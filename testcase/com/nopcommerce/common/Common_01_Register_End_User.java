package com.nopcommerce.common;



import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_End_User extends BaseTest{

	private WebDriver driver;
	private String firstName, lastName;
	public static String emailAddress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	

	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classes Test")
	public void User_01_Register(String browserName) {
		
		driver = getBrowserDriver(browserName);	
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		password = "123456";
		
		
		log.info("Pre-condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Pre-condition - Step 02: Enter to Firstname textbox with value is'" + firstName + "'" );
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Pre-condition - Step 03: Enter to Lastname textbox with value is'" + lastName + "'" );
		registerPage.inputToLastnameTextbox(lastName);
		
		log.info("Pre-condition - Step 04: Enter to Email textbox with value is'" + emailAddress + "'" );
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre-condition - Step 05: Enter to Password textbox with value is'" + password + "'" );
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Pre-condition - Step 06: Enter to Confirm Password textbox with value is'" + password + "'" );
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Pre-condition - Step 07: Click to 'Register' button" );
		registerPage.clickToRegisterButton();
		
		log.info("Pre-condition - Step 08: Verify Register success message is displayed" );
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	
		driver.quit();
		
	}
	@AfterTest
	public void afterClass() {
	}



}
