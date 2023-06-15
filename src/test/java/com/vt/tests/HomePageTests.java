package com.vt.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.vt.driver.DriverManager;

public class HomePageTests extends BaseTest {
	
	@Test
	public void test2() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("vaishakh", Keys.ENTER);
	}
	
	@Test
	public void test3() {
		
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3));
		WebElement searchElemet = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		/*
		 *  Another way doing it using FP 
		 *  wait.until(d -> d.findElement(By.name("q")).isEnabled());
		 */
		searchElemet.sendKeys("Vaishkah", Keys.ENTER);
	}

}
