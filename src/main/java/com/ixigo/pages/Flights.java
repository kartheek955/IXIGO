package com.ixigo.pages;

import org.openqa.selenium.By;

import com.ixigo.SUT;

public class Flights extends BasePage{

	public Flights(SUT testEnv) {
		super(testEnv);
	}

	public void enterFrom(String from) {
		findElement(By.xpath("(//input[@placeholder='Enter city or airport'])[1]")).sendKeys(from);
		findElement(By.xpath("//div[contains(text(), '" + from + "')]")).click();
	}
	
	public void enterTo(String to) {
		findElement(By.className("(//input[@placeholder='Enter city or airport'])[2]")).sendKeys(to);
		findElement(By.xpath("//div[contains(text(), '" + to + "')]")).click();
	}
	
	public void chooseDeparture(String date) {
		findElement(By.xpath("//div[contains(@class, 'flight-dep-cal')]//div[text()='"+date+"']")).click();
	}
	
	public void chooseReturn(String date) {
		findElement(By.xpath("//div[contains(@class, 'flight-ret-cal')]//div[text()='"+date+"']")).click();
	}
	
	public void chooseTravellers(int num) {
		findElement(By.xpath("//div[text()='Travellers | Class']//following-sibling::input")).click();
		findElement(By.cssSelector("span[data-val='"+String.valueOf(num)+"']")).click();
	}
	
	public SearchResults clickSearch() {
		findElement(By.xpath("//button[text()='Search']")).click();
		return new SearchResults(testEnv);
	}
}
