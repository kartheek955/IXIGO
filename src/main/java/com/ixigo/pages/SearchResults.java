package com.ixigo.pages;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ixigo.SUT;

public class SearchResults extends BasePage {

	public SearchResults(SUT testEnv) {
		super(testEnv);
	}

	public void checkNonStop() {
		findElement(
				By.xpath("//div[contains(@class, 'checkbox-list-item')]"
						+ "[.//div[contains(text(), 'Non stop')]]//span[contains(@class, 'check-icon')]"))
				.click();
	}
	
	public Set<String> getAirlineNum() {
		Set<String> airlineNums = new LinkedHashSet<String>();
		List<WebElement> airlineElmts = driver.findElements(By.xpath("//div[@class='airline-text']"));
		Iterator<WebElement> airlineElmtsI = airlineElmts.iterator();
		while(airlineElmtsI.hasNext()) {
			String airlineNum = airlineElmtsI.next().getText();
			airlineNum = airlineNum.split(" ")[1];
			airlineNums.add(airlineNum);
		}
		return airlineNums;
	}
	
	public Set<String> getDepatureTimes() {
		Set<String> depatureTimes = new LinkedHashSet<String>();
		List<WebElement> depatureElmts = driver.findElements(By.xpath("//div[@class='divider']//following-sibling::div[@class='time']"));
		Iterator<WebElement> depatureElmtsI = depatureElmts.iterator();
		while(depatureElmtsI.hasNext()) {
			String time = depatureElmtsI.next().getText();
			time = time.split(" ")[1];
			depatureTimes.add(time);
		}
		return depatureTimes;
	}
}
