package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aspiration.pages.HomePage;
import com.aspiration.pages.SpendAndSavePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Aspiration_UI_StepDef  {
	
	WebDriver driver ;
	HomePage hPage;
	SpendAndSavePage sasPage;
	
	@Given("I launch the Aspiration application using URL {string}")
	public void i_launch_the_aspiration_application_using_url(String url) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kak7291\\Documents\\Sruthi\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get(url);
		System.out.println("Opened the Chrome Browser and Launched the Aspiration App");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
		
		hPage = new HomePage(driver);
		sasPage = new SpendAndSavePage(driver);
		hPage.verifyUserIsOnHomePage();
	   
	}
	@When("I  Click on Spend And Save Button on Home page")
	public void i_click_on_Spend_And_Save_Button_on_home_page() {
		hPage = new HomePage(driver);
		sasPage = new SpendAndSavePage(driver);
		hPage.clickOnSpendAndSaveButton();
	}
	@Then("Verify I am on Spend And Save Page")
	public void verify_i_am_on_products_page() {
		hPage = new HomePage(driver);
		sasPage = new SpendAndSavePage(driver);
		sasPage.verifyUserisOnSpendAndSavePage();
	}
	@Then("verify I see product {string} on Product Page")
	public void verify_i_see_product_on_product_page(String productName) {
		sasPage = new SpendAndSavePage(driver);
		sasPage.verifyProductName(productName);
	}
	
	@When("I  Click on Get Started Button on Home page")
	public void i_click_on_Get_Started_Button_on_home_page() {
		hPage = new HomePage(driver);
		hPage.clickOnGetStartedButton();
	}
	
	@Then("Verify I see Email address textbox on popup modal")
	public void verify_i_see_Email_address_textbox_on_popup_modal() {
		hPage = new HomePage(driver);
		hPage.verifyEmailTextbox();
	}
	
	@Then("I close the application")
	public void i_close_the_applicaiton() {
		driver.quit();
	}



	

}
