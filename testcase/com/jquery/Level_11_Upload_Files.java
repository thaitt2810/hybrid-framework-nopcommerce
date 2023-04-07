package com.jquery;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManeger;


public class Level_11_Upload_Files extends BaseTest{

	private WebDriver driver;
	HomePageObject homePage;
	String beachFileName = "beach.jpg";
	String rainFileName = "rain.jpg";
	String skyFileName = "sky.jpg";
	String mountainFileName = "mountain.jpg";
	String [] multipleFileNames = {mountainFileName, rainFileName, skyFileName, beachFileName};

	@Parameters({"browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);	
		homePage = PageGeneratorManeger.getHomePage(driver);
		
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, beachFileName);
		Assert.assertTrue(homePage.isFileLoadedByName(beachFileName));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUploadedByName(beachFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(beachFileName));

	}

	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);
		
		homePage.uploadMultipleFiles(driver, multipleFileNames);
		Assert.assertTrue(homePage.isFileLoadedByName(mountainFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(rainFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(skyFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(beachFileName));
		
		homePage.clickToStartButton();
		
		Assert.assertTrue(homePage.isFileLinkUploadedByName(mountainFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(rainFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(skyFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(beachFileName));
		
		Assert.assertTrue(homePage.isFileImageUploadedByName(mountainFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(rainFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(skyFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(beachFileName));
	}
	

	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}



}
