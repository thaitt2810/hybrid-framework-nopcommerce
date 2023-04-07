package com.jquery;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManeger;


public class Level_10_DataTable_DataGrid extends BaseTest{

	private WebDriver driver;
	HomePageObject homePage;
	

	@Parameters({"browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);	
		homePage = PageGeneratorManeger.getHomePage(driver);
		
	}

	
	public void Table_01() {
		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("7"));
		
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		
		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("20"));
		
		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("18"));


	}

	
	public void Table_02() {
		homePage.refreshCurrentPage(driver);
		
		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Males", "349238");
		homePage.enterToHeaderTextboxByLabel("Total", "687522");
	}
	

	public void Table_03() {
		homePage.getValueAllRowAtEachPage();
	}
	
	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.clickToLoadDataButton();
		homePage.sleepInSecond(3);
		
		homePage.enterToTextboxByColumnNameAtRowNumber("Company", "1", "AutomationFC");
		homePage.sleepInSecond(1);
		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "4", "Michael Jackson");
		homePage.sleepInSecond(1);
		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "2", "97");
		homePage.sleepInSecond(1);
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "5", "United Kingdom");
		homePage.sleepInSecond(1);
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "2");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "3");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "6");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "7");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "8");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "1");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "4");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "5");
		
		homePage.clickToIconNameByRowNumber("1", "Insert Row Above");
		homePage.sleepInSecond(1);
		homePage.clickToIconNameByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconNameByRowNumber("3", "Move Up");
		homePage.sleepInSecond(1);
		homePage.clickToIconNameByRowNumber("4", "Move Down");
		homePage.sleepInSecond(1);

	}
	
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}



}
