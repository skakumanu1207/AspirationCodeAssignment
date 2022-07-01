package com.aspiration.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpendAndSavePage {

WebDriver driver;
	
	public SpendAndSavePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void verifyUserisOnSpendAndSavePage()
	{
		Assert.assertTrue("User is not on Spend And Save Page", driver.getCurrentUrl().equals("https://www.aspiration.com/spendandsave"));
		System.out.println("User is on Spend And Save Page as expected");
	}
	
	public void verifyProductName(String productName)
	{
		Assert.assertTrue(productName+" is not Displayed on Spend And Save Page", driver.findElement(By.xpath("//div[@display='none,flex']//span[text()='"+productName+"']")).isDisplayed());
		System.out.println(productName+" is Displayed on Spend And Save Page");
	}
}
