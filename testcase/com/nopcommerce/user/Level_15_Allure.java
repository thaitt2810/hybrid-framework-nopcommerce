package com.nopcommerce.user;


import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_15_Allure extends BaseTest{

	private WebDriver driver;
	private String firstName, lastName, emailAddress, validPassword;
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
		

		

	}
	@Description("Registert to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register(Method method) {
	registerPage = homePage.clickToRegisterLink();

	registerPage.inputToFirstnameTextbox(firstName);

	registerPage.inputToLastnameTextbox(lastName);

	registerPage.inputToEmailTextbox(emailAddress);

	registerPage.inputToPasswordTextbox(validPassword);

	registerPage.inputToConfirmPasswordTextbox(validPassword);

	registerPage.clickToRegisterButton();

	Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Description("Login to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_02_Login(Method method) {
	loginPage = homePage.openLoginPage();
	loginPage.inputToEmailTextbox(emailAddress);

	loginPage.inputToPasswordTextbox(validPassword);

	homePage = loginPage.clickToLoginButton();

	Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

	customerInfoPage = homePage.openMyAccountPage();

	Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
	}

	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}



}
