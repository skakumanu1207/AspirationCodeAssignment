package com.aspiration.hooks;

import java.util.concurrent.TimeUnit;

import cucumber.api.java.After; 
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aspiration.base.BaseClass;


public class Hooks extends BaseClass {
	
	
	@Before
	public void initialApp()
	{
		System.out.println("In the Initial Step");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kak7291\\Documents\\Sruthi\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get(baseUrl);
		System.out.println("Opened the Chrome Browser and Launched the Aspiration App");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@After
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("Closed the Browser");
	}

}
