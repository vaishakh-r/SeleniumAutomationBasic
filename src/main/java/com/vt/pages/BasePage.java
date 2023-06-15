package com.vt.pages;

import java.time.Duration;

import com.vt.enums.ServerityTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vt.constants.Constants;
import com.vt.driver.DriverManager;

public class BasePage {
	
	private BasePage() {}
	

	protected void explicitlyWaitForElementToBeClickable(By by) {
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.getExplicitwait()))
		.until(ExpectedConditions.elementToBeClickable(by));
		
		
	}
	
	protected void explicitlyWaitForElementToBePresent(By by) {
		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
		.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	protected void click(By by) {
		explicitlyWaitForElementToBeClickable(by);
		DriverManager.getDriver().findElement(by).click();
	}
	
}
