package com.ixigo;

import org.openqa.selenium.WebDriver;

import com.ixigo.pages.Flights;

public class Browser{
	
	private SUT testEnv = null;
	private WebDriver driver = null;
	private Configuration config = null;
	private Flights homePage = null;
	
	public Browser(SUT testEnv) {
		this.testEnv = testEnv;
		this.driver = testEnv.getDriver();
		this.config = testEnv.getConfiguration();
	}

	public Flights open() {
		return open(config.getInstanceURL());
	}

	public void close() {
		driver.close();
	}

	public Flights open(String url) {
		driver.get(url);
		if(homePage==null){
			homePage = new Flights(testEnv);
		}
		return homePage;
	}

}
