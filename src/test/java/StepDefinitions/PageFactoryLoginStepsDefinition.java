package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.homePageFactory;
import pageFactory.loginPageFactory;

public class PageFactoryLoginStepsDefinition {

	static WebDriver driver;
	loginPageFactory login;
	homePageFactory home;
	ChromeOptions options;

	@Given("User is on login page")
	public void user_is_on_login_page() {
	

	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/v1/");
	}

	@When("User enters valid {string} and {string}")
	public void user_enters_valid_and(String username, String password) throws InterruptedException {
		login = new loginPageFactory(driver);
		login.enterUsername(username);
		login.enterPassword(password);

	}

	@And("Clicks on Login Button")
	public void clicks_on_login_button() {
		login.clickOnLoginButton();
	}

	@Then("User is navigated to Home Page")
	public void user_is_navigated_to_home_page() {
		
		home = new homePageFactory(driver);
		home.isCartDisplayed();
		
		//Assert.assertTrue(driver.findElements(By.xpath("//div[@class='app_logo']")).size() > 0,
			//	"User is navigated to Home Page");
	}

	@And("Close the browser")
	public void close_the_browser() {
		
		//driver.close();
		driver.quit();
	}

}
