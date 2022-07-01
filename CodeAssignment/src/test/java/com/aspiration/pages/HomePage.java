package com.aspiration.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void verifyUserIsOnHomePage()
	{
		Assert.assertTrue("User is not on Home Page", driver.getCurrentUrl().equals("https://www.aspiration.com/"));
		System.out.println("URL is showing correct");
		Assert.assertTrue("Climate Change Text is not displayed on Home Page",driver.findElement(By.xpath("//h1[@data-testid='hero-title']")).isDisplayed());
		System.out.println("Climate Change Text is displayed on Home Page");
		System.out.println("User is on Home Page");
	}

	public void clickOnSpendAndSaveButton()
	{
		WebElement spendAndSaveButton = driver.findElement(By.xpath("//ul[contains(@display,'inline-flex')]//a[text()='Spend & Save']"));
		spendAndSaveButton.click();
		System.out.println("Clicked on Spend And Save Button on Home Page");
		Assert.assertTrue("User is not on Spend And Save Page", driver.getCurrentUrl().equals("https://www.aspiration.com/spendandsave"));
		System.out.println("User is on Spend And Save Page as expected");
	}
	
	public void clickOnGetStartedButton()
	{
		WebElement getStartedButton = driver.findElement(By.xpath("//button[@data-id='open-account-button' and text()='Get Started']"));
		getStartedButton.click();
		System.out.println("Clicked on Get Started Button on Home Page");
		Assert.assertTrue("Get Started Popup is not displayed", driver.findElement(By.xpath("//h5[text()='Enter your email to get started']")).isDisplayed());
		System.out.println("Get Started Popup is displayed as expected");
	}
	
	public void verifyEmailTextbox()
	{
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@data-testid='signup-input-cta-modal']"));
		Assert.assertTrue("Email Textbox is not displayed", emailTextbox.isDisplayed());
		System.out.println("Email Textbox is displayed as expected");
	}
}
