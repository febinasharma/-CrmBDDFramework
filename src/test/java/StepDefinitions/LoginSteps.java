package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
	WebDriver driver;
	
@Given("User is already on Login Page")
public void user_is_already_on_login_page() {
	String projectPath=System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver",projectPath+"\\src\\test\\resource\\Driver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://classic.crmpro.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    System.out.println("User is on Login Page");
}

@When("user enters username and password")
public void user_enters_username_and_password() {
	System.out.println("User enters username and password");
	driver.findElement(By.name("username")).sendKeys("groupautomation");
	driver.findElement(By.name("password")).sendKeys("Test@12345");
}

@And("user clicks on login button")
public void user_clicks_on_login_button() {
	System.out.println("User clicks on login button");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
}

@Then("user is navigated to Home Page")
public void user_is_navigated_to_home_page() {
	System.out.println("User is on home page");
	driver.switchTo().frame("mainpanel");
	WebElement homePageTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
	System.out.println(homePageTitle.getText());
	Assert.assertTrue(homePageTitle.isDisplayed());
}


}
