package com.nopcommerce.user;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_17_Custom_Close_Driver extends BaseTest{

	private WebDriver driver;
	private String firstName, lastName, emailAddress, validPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);	
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		validPassword = "123456";
		

		log.info("Pre-condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Pre-condition - Step 02: Enter to Firstname textbox with value is'" + firstName + "'" );
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Pre-condition - Step 03: Enter to Lastname textbox with value is'" + lastName + "'" );
		registerPage.inputToLastnameTextbox(lastName);
		
		log.info("Pre-condition - Step 04: Enter to Email textbox with value is'" + emailAddress + "'" );
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre-condition - Step 05: Enter to Password textbox with value is'" + validPassword + "'" );
		registerPage.inputToPasswordTextbox(validPassword);
		
		log.info("Pre-condition - Step 06: Enter to Confirm Password textbox with value is'" + validPassword + "'" );
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		log.info("Pre-condition - Step 07: Click to 'Register' button" );
		registerPage.clickToRegisterButton();
		
		driver = null;
		
		log.info("Pre-condition - Step 08: Verify Register success message is displayed" );
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");
		
		log.info("Pre-condition - Step 09: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-condition - Step 10: Enter to Email textbox with value is'" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre-condition - Step 11: Enter to Password textbox with value is'" + validPassword + "'");
		loginPage.inputToPasswordTextbox(validPassword);

		log.info("Pre-condition - Step 12: Click to 'Login' button and navigate to 'Home' page");
		homePage = loginPage.clickToLoginButton();
		

	}

	@Test
	public void User_01_Register() {
		

	}

	@Test
	public void User_02_Login() {
	}
	
	

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver(); 
	}



}
