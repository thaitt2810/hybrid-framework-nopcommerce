package javaBasic;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(commons.MethodListener.class)
public class Topic_17_Assert extends BaseTest{

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://vi-vn.facebook.com/");
		
	}
	
	
	@Test
	public void TC_01() {
		System.out.println("Assert 01");
		String loginPageUrl = driver.getCurrentUrl();
		verifyEquals(loginPageUrl, "https://vi-vn.facebook.com/");
		
		System.out.println("Assert 02 - Failed");
		String loginPageTitle = driver.getTitle();
		verifyEquals(loginPageTitle, "adgfdavdfabad");
		
		System.out.println("Assert 03 - Passed");
		verifyTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
		
		System.out.println("Assert 04 - Failed");
		verifyTrue(driver.findElement(By.xpath("//input[@name='login_source']")).isDisplayed());
		
		
		driver.quit();
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

}

































