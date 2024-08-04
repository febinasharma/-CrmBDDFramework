package StepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;

public class LoginParameterisedSteps {
	public WebDriver driver;

	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
	    String projectPath=System.getProperty("user.dir");
	    System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\test\\resource\\Driver\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("https://classic.crmpro.com");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@When("^User enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username,String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	    
	}
	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	@Then("User is navigated to Home page")
	public void user_is_navigated_to_home_page() {
		driver.switchTo().frame("mainpanel");
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Home')]")).isDisplayed());
	   // driver.quit();
	}
	
	@Then("User clicks on New Contacts menu option under Contacts Menu")
	public void user_clicks_on_new_contacts_menu_option_under_contacts_menu() throws InterruptedException {
		//driver.switchTo().frame("mainpanel");
	    Actions action=new Actions(driver);
	    action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
	    
	}
	
	@And ("^User input new contacts details (.*) and (.*) and (.*)$")
	public void user_enters_new_contact_details(String firstname, String lastname, String comp_position) {
		driver.findElement(By.name("first_name")).sendKeys(firstname);
		driver.findElement(By.name("surname")).sendKeys(lastname);
		driver.findElement(By.name("company_position")).sendKeys(comp_position);
		
	}
	@Then("User saves new contact details")
	public void user_saves_new_contact_details() {
	   driver.findElement(By.xpath("//td[@colspan='2']/input[@type='submit' and @value='Save']")).click();
	}
}
