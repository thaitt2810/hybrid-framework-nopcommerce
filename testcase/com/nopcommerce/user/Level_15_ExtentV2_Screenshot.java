package com.nopcommerce.user;


import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;


public class Level_15_ExtentV2_Screenshot extends BaseTest{

	private WebDriver driver;
	 String firstName, lastName, emailAddress, validPassword;
	 UserHomePageObject homePage;
	 UserRegisterPageObject registerPage;
	 UserLoginPageObject loginPage;
	
	 UserCustomerInfoPageObject customerInfoPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		validPassword = "123456";
		

		

	}

	@Test
	public void User_01_Register(Method method) {
//		ExtentManager.startTest(method.getName(), "TC_01_Register");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to 'Register' page");
//		registerPage = homePage.clickToRegisterLink();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Firstname textbox with value is'" + firstName + "'" );
//		registerPage.inputToFirstnameTextbox(firstName);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to Lastname textbox with value is'" + lastName + "'" );
//		registerPage.inputToLastnameTextbox(lastName);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email textbox with value is'" + emailAddress + "'" );
//		registerPage.inputToEmailTextbox(emailAddress);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password textbox with value is'" + validPassword + "'" );
//		registerPage.inputToPasswordTextbox(validPassword);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Confirm Password textbox with value is'" + validPassword + "'" );
//		registerPage.inputToConfirmPasswordTextbox(validPassword);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to 'Register' button" );
//		registerPage.clickToRegisterButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify Register success message is displayed" );
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
//	
//		ExtentManager.endTest();
		

	}

	@Test
	public void User_02_Login(Method method) {
//		ExtentManager.startTest(method.getName(), "TC_01_Register");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to 'Login' page");
//		loginPage = homePage.openLoginPage();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to Email textbox with value is'" + emailAddress + "'");
//		loginPage.inputToEmailTextbox(emailAddress);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 03: Enter to Password textbox with value is'" + validPassword + "'");
//		loginPage.inputToPasswordTextbox(validPassword);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 04: Click to 'Login' button and navigate to 'Home' page");
//		homePage = loginPage.clickToLoginButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
//		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to 'CustomerInfo' page");
//		customerInfoPage = homePage.openMyAccountPage();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify 'CustomerInfo' is displayed");
//		Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
//		
//		ExtentManager.endTest();
	}
	
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}



}
