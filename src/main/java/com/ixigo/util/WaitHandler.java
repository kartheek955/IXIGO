package com.ixigo.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.ixigo.SUT;

public class WaitHandler {
	
	private WebDriver driver;
	
	public WaitHandler(SUT testEnv) {
		this.driver = testEnv.getDriver();
	}

	private int GLOBAL_TIME_OUT = 600;

	public void waitForElementPresence(By by) {
		Wait<WebDriver> wait = new WebDriverWait(driver, GLOBAL_TIME_OUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void waitForElementPresence(WebElement elmt) {
		Wait<WebDriver> wait = new WebDriverWait(driver, GLOBAL_TIME_OUT);
		wait.until(ExpectedConditions.visibilityOf(elmt));
	}

	public void waitForElementVisibility(By by) {
		Wait<WebDriver> wait = new WebDriverWait(driver, GLOBAL_TIME_OUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForElementClickable(By by) {
		Wait<WebDriver> wait = new WebDriverWait(driver, GLOBAL_TIME_OUT);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public void waitForPageLoaded() {
		Wait<WebDriver> wait = new WebDriverWait(driver, GLOBAL_TIME_OUT);
		wait.until(checkPageLoadStatus());
	}
	
	public void waitForElementNotVisible(By locator) {
		Wait<WebDriver> wait = new WebDriverWait(driver, GLOBAL_TIME_OUT);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void waitTillTitleContains(String text) {
		Wait<WebDriver> wait = new WebDriverWait(driver, GLOBAL_TIME_OUT);
		wait.until(ExpectedConditions.titleContains(text));
	}
	
	public void sleep(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			//Ignore the exception
		}
	}
	
	private Function<WebDriver, Boolean> checkPageLoadStatus() {
		return new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
	}
}
