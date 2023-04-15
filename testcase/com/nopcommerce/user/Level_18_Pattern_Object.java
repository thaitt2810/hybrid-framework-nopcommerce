package com.nopcommerce.user;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class Level_18_Pattern_Object extends BaseTest{

	private WebDriver driver;
	private String firstName, lastName, emailAddress, validPassword;
	private String date, month, year;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	
	private UserCustomerInfoPageObject customerInfoPage;

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
		date = "10";
		month = "August";
		year = "1998";
		

		

	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRadioButtonByLabel(driver, "Female");
		
		log.info("Register - Step 02: Enter to Firstname textbox with value is'" + firstName + "'" );
		//registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);
		
		log.info("Register - Step 03: Enter to Lastname textbox with value is'" + lastName + "'" );
		//registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToTextboxByID(driver, "LastName", lastName);
		
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", date);
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);
		
		log.info("Register - Step 04: Enter to Email textbox with value is'" + emailAddress + "'" );
		//registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		registerPage.clickToCheckboxByLabel(driver, "Newsletter");
		
		log.info("Register - Step 05: Enter to Password textbox with value is'" + validPassword + "'" );
		//registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToTextboxByID(driver, "Password", validPassword);
		
		log.info("Register - Step 06: Enter to Confirm Password textbox with value is'" + validPassword + "'" );
		//registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", validPassword);

		registerPage.sleepInSecond(5);
		
		log.info("Register - Step 07: Click to 'Register' button" );
		//registerPage.clickToRegisterButton();
		registerPage.clickToButtonByText(driver, "Register");
		
		log.info("Register - Step 08: Verify Register success message is displayed" );
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	
		

	}

	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to Email textbox with value is'" + emailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Login - Step 03: Enter to Password textbox with value is'" + validPassword + "'");
		loginPage.inputToTextboxByID(driver, "Password", validPassword);

		log.info("Login - Step 04: Click to 'Login' button and navigate to 'Home' page");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - Step 05: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
	}
	
	@Test
	public void User_03_My_Account() {
		
		log.info("My Account - Step 01: Navigate to 'CustomerInfo' page");
		customerInfoPage = homePage.openMyAccountPage();
		
		log.info("My Account - Step 02: Verify 'CustomerInfo' is displayed");
		verifyTrue(customerInfoPage.isCustomerInfoPageDisplayed());
		
		log.info("My Account - Step 03: Verify 'Firstname' valueis correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), firstName);
		
		log.info("My Account - Step 04: Verify 'Lastname' valueis correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), lastName);
		
		log.info("My Account - Step 05: Verify 'Email' valueis correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);
		
	}
	
	

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver(); 
	}


}
