package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminDashBoardPageUI;

public class AdminDashboardPageObject extends BasePage{

	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isHeaderDashBoardDisplayed() {
		waitForElementVisible(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
	}
}
