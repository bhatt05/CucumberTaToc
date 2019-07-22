package TaToc.CucumberTaTOC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AdavanceTest {
	WebDriver driver;
	@Given("^user is on the Home Page of Tatoc$")
	public void user_is_on_the_Home_Page_of_Tatoc()  {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jagdishbhatt\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.0.1.86/tatoc");
		Assert.assertEquals("User is Not in Home Page", "Welcome - T.A.T.O.C", driver.getTitle());
	}

	@When("^click adavance course$")
	public void click_adavance_course() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement link=driver.findElement(By.xpath("//a[@href=\"/tatoc/advanced\"]"));
		link.click();
	}

	@Then("^User will enter to hover menu$")
	public void user_will_enter_to_hover_menu()  {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("User is Not in Hover menu", "Hover Menu - Advanced Course - T.A.T.O.C", driver.getTitle());
	}

	@And("^User Select go next from menutwo$")
	public void user_Select_go_next_from_menutwo()  {
	    // Write code here that turns the phrase above into concrete actions
		WebElement e=driver.findElement(By.xpath("//div[@class=\"menutop m2\"]"));
		Actions a=new Actions(driver);
		a.moveToElement(e).build().perform();
	}

	@And("^click proceed")
	public void click_proceed() {
		driver.findElement(By.xpath("//span[contains(text(),\"Go Next\")]")).click();
	}
	
	@And("^User will enter to error page$")
	public void user_will_enter_to_error_page()  {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("User is Not in Error Page", "Mysql::Error at /tatoc/advanced/query/gate", driver.getTitle());
		driver.close();
	}
}
