package com.nopcommerce.user;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class Level_08_Switch_Role extends BaseTest{

	private WebDriver driver;
	private String userEmailAddress, userPassword, adminEmailAddress, adminPassword;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashBoardPage;


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);	
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userEmailAddress = "fc123@gmail.com";
		userPassword = "123123";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
		

		

	}

	@Test
	public void Role_01_User() {
		userLoginPage = userHomePage.openLoginPage();
		
	//Login as User Role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		
		userCustomerInfoPage = userHomePage.openMyAccountPage();
		
		userHomePage = userCustomerInfoPage.clickToLogoutLinkAtUserPage(driver);
		
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		adminDashBoardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashBoardPage.isHeaderDashBoardDisplayed());
		
		adminLoginPage = adminDashBoardPage.clickToLogoutLinkAtAdminPage(driver);
		}
	
	@Test
	public void Role_02_Admin() {
		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		userLoginPage = userHomePage.openLoginPage();
		
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}
	
	
	


	@AfterClass
	public void afterClass() {
		driver.quit();
	}



}
