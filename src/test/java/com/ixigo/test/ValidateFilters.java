package com.ixigo.test;

import java.util.Set;

import com.ixigo.Browser;
import com.ixigo.SUT;
import com.ixigo.pages.Flights;
import com.ixigo.pages.SearchResults;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateFilters {

	private String fromCity = "Pune";
	private String toCity = "Hyderabad";

	@Test
	public void testAirlineDetails() {
		SUT sut = new SUT();
		Browser browser = sut.getBrowser();
		Flights flightPage = browser.open();
		Assert.assertTrue(flightPage.verifyElement(By.linkText("flights")));
		flightPage.enterFrom(fromCity);
		flightPage.enterTo(toCity);
		flightPage.chooseDeparture("17");
		flightPage.chooseReturn("24");
		flightPage.chooseTravellers(2);
		SearchResults searchResults = flightPage.clickSearch();
		Assert.assertTrue(searchResults.verifyElement(By
				.xpath("//span[contains(text(), '" + fromCity + "')]")));
		Assert.assertTrue(searchResults.verifyElement(By
				.xpath("//span[contains(text(), '" + toCity + "')]")));
		searchResults.checkNonStop();
		Set<String> airlineNum = searchResults.getAirlineNum();
		System.out.println("Airline numbers are: " + airlineNum);
		Set<String> depatureTimes = searchResults.getDepatureTimes();
		System.out.println("Depature times are: " + depatureTimes);
	}
}
