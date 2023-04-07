package pageObjects.jQuery.uploadFile;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManeger {

	public static HomePageObject getHomePage (WebDriver driver) {
		return new HomePageObject(driver);
	}

}
