
package TaToc.CucumberTaTOC;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
 
public class AppTest {
static WebDriver driver;
	WebElement link;
	static WebElement box;
	static WebElement box1;
	static WebElement box2;
	String main;
	String token;
	String value;
	
	 @Given("^User is on Browser$")
	    public void user_is_on_browser() {
		 	System.setProperty("webdriver.chrome.driver","C:\\Users\\jagdishbhatt\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
	      //  throw new PendingException();
	    }

	 @When("^User navigate to tatoc link$")
	 public void user_navigate_to_tatoc_link()  {
	    	driver.get("http://10.0.1.86/tatoc");
	       // throw new PendingException();
	    }
	 
	 @Then("^User is on Home Page$")
	    public void user_is_on_Home_page()  {
			System.out.println(driver.getTitle());
	    	Assert.assertEquals("User is Not in Home Page", "Welcome - T.A.T.O.C", driver.getTitle());
	       // throw new PendingException();
	    }
	 
//	    @Given("^User on Home Page$")
//	    public void user_on_home_page()  {
//	    	System.out.println(driver.getTitle());
//	    	Assert.assertEquals("User is Not in Home Page", "Welcome - T.A.T.O.C", driver.getTitle());
//	      //  throw new PendingException();
//	    }
	    
	    @When("^User is able to see Basic course Link$")
	    public void user_is_able_to_see_basic_course_link() {
	    	link=driver.findElement(By.xpath("//a[@href=\"/tatoc/basic\"]"));
	    	if(link.isDisplayed()) {
	    		Assert.assertTrue(true);
	    	}
	    	else {
	    		Assert.assertTrue(false);
	    	}
	        
	    }

	    @And("^User Click on Basic Course Link$")
	    public void user_click_on_basic_course_link() {
			link.click();
	        //throw new PendingException();
	    }
	    
	    @Then("^User is on Grid Gate Page$")
	    public void user_is_on_grid_gate_page() {
	    	Assert.assertEquals("User is Not in Grid Gate", "Grid Gate - Basic Course - T.A.T.O.C", driver.getTitle());
	     
	    }
	    
	    @Given("^user on Grid Gate Page$")
	    public void user_on_grid_gate_page() throws Throwable {
	    	Assert.assertEquals("User is Not in Home Page", "Grid Gate - Basic Course - T.A.T.O.C", driver.getTitle());
	     //   throw new PendingException();
	    }
	    
	    @When("^User navigate to the Green Box$")
	    public void user_navigate_to_the_green_box(){
	    	box=driver.findElement(By.cssSelector("div[class=\"greenbox\"]"));
	      //  throw new PendingException();
	    }
	    
	    @And("^Click on Green Box$")
	    public void click_on_green_box() {
	    	box.click();
	       // throw new PendingException();
	    }
	    
	    @Then("^user will enter to Frame Dungeon page$")
	    public void user_will_enter_to_frame_dungeon_page() {
	    	Assert.assertEquals("User is Not in Frame Dungeon", "Frame Dungeon - Basic Course - T.A.T.O.C", driver.getTitle());
	        
	    }

	    @Given("^User on Frame Dungeon page$")
	    public void User_on_Frame_Dungeon_page()  {
	    	Assert.assertEquals("User is Not in Frame Dungeon", "Frame Dungeon - Basic Course - T.A.T.O.C", driver.getTitle());
	    	
	    }

	    @When("^user can See two colored Boxes$")
	    public void user_can_See_two_colored_Boxes() {
	    	driver.switchTo().frame("main");
	    	box1=driver.findElement(By.xpath("//div[@id=\"answer\"]"));
	    	driver.switchTo().frame("child");
			box2=driver.findElement(By.xpath("//div[@id=\"answer\"]"));
			driver.switchTo().parentFrame();
	    	if(box1.isDisplayed()) {
	    		Assert.assertTrue(true);
	    	}
	    	else {
	    		Assert.assertTrue(false);
	    	}
	    }

	    @And("^if Color of Both not Equal click Repaint-Box2$")
	    public void if_color_of_both_not_equal_click_repaintbox2()  {

	    	//box1=driver.findElement(By.xpath("//div[@id=\"answer\"]"));
			String color=box1.getAttribute("class");
			String color1;
			while(true)
			{
				driver.switchTo().frame("child");
				box2=driver.findElement(By.xpath("//div[@id=\"answer\"]"));
				color1=box2.getAttribute("class");
				if(color.equals(color1)) {
					break;
				}
				else {
					driver.switchTo().parentFrame();
					driver.findElement(By.xpath("//a[contains(text(),\"Repaint\")]")).click();
				}
			}
			driver.switchTo().parentFrame();
	    	
	    }

	    @And("^If color equal click proceed$")
	    public void if_color_equal_click_proceed() {
	    	driver.findElement(By.xpath("//a[contains(text(),\"Proceed\")]")).click();
	      
	    }
	    
	    @Then("^User enter onDrag Arround Page$")
	    public void user_enter_ondrag_arround_page()  {
	    	Assert.assertEquals("User is Not in Drag", "Drag - Basic Course - T.A.T.O.C", driver.getTitle());
	      
	    }
	    
	    @Given("^User on Drag Arround Page$")
	    public void user_on_drag_arround_page() {
	    	Assert.assertEquals("User is Not in Drag", "Drag - Basic Course - T.A.T.O.C", driver.getTitle());
	    
	    }

	    @When("^User Drag Drag me to Drop Box$")
	    public void user_drag_drag_me_to_drop_box()  {
	    	WebElement dest=driver.findElement(By.xpath("//div[@id=\"dropbox\"]"));
			WebElement source=driver.findElement(By.xpath("//div[@id=\"dragbox\"]"));
			Actions act=new Actions(driver);
			act.dragAndDrop(source, dest).build().perform();
	  
	    }

	    @And("^Click on Proceed$")
	    public void click_on_proceed()  {
	    	driver.findElement(By.xpath("//a[contains(text(),\"Proceed\")]")).click();
	      
	    }
	    
	    @Then("^User will enter to pop up Window Page$")
	    public void user_will_enter_to_pop_up_window_page() {
	    	Assert.assertEquals("User is Not in Windows", "Windows - Basic Course - T.A.T.O.C", driver.getTitle());
	    
	    }
	    
	    @Given("^User on pop up Window Page$")
	    public void user_on_pop_up_window_page() {
	    	Assert.assertEquals("User is Not in Windows", "Windows - Basic Course - T.A.T.O.C", driver.getTitle());
	       
	    }
	    
	    @When("^User click on Launch popup window$")
	    public void user_click_on_launch_popup_window() {
	    	driver.findElement(By.xpath("//a[contains(text(),\"Launch\")]")).click();
	     
	    }

	    @And("^Enter its name on text box$")
	    public void enter_its_name_on_text_box() {
	    	main=driver.getWindowHandle();
			Set <String>child=driver.getWindowHandles();
			Iterator<String> i=child.iterator();
			while(i.hasNext()) {
				String child1=i.next();
				if(!main.equalsIgnoreCase(child1)) {
					driver.switchTo().window(child1);
					driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("Jagdish");
					//driver.findElement(By.xpath("//input[@id=\"submit\"]")).click();
				}
			}
			
	       
	    }

	    @And("^Click submit$")
	    public void click_submit()  {
	    	//Thread.sleep(2000);
	    	WebElement submit=driver.findElement(By.xpath("//input[@id=\"submit\"]"));
	    	submit.click();
	    	driver.switchTo().window(main);
	       
	    }

	    @And("^on parent window click proceed$")
	    public void on_parent_window_click_proceed()  {
	    	driver.findElement(By.xpath("//a[contains(text(),\"Proceed\")]")).click();
	      
	    }
	    
	    @Then("^User will enter on CookieHandling Page$")
	    public void user_will_enter_on_cookiehandling_page() {
	    	Assert.assertEquals("User is Not in Windows", "Cookie Handling - Basic Course - T.A.T.O.C", driver.getTitle());
	        //throw new PendingException();
	    }
	    
	    @Given("^user on CookieHandling Page$")
	    public void user_on_cookiehandling_page() throws Throwable {
	    	Assert.assertEquals("User is Not in Windows", "Cookie Handling - Basic Course - T.A.T.O.C", driver.getTitle());
	        //throw new PendingException();
	    }
	    
	    @When("^User Click on Genrate cookie$")
	    public void user_click_on_genrate_cookie()  {
	    	driver.findElement(By.xpath("//a[contains(text(),\"Generate\")]")).click();
	        
	    }

	    @And("^User can See Token value$")
	    public void user_can_see_token_value() {
	    	token=driver.findElement(By.xpath("//span[@id=\"token\"]")).getText();
			if(token.isEmpty()) {
	    		Assert.assertTrue(false);
	    	}
	    	else {
	    		Assert.assertTrue(true);
	    	}
	       // throw new PendingException();
	    }

	    @And("^Copy value of cookie$")
	    public void copy_value_of_cookie() throws Throwable {
	    	String str[]=token.split(" ");
			value=str[1];
	       // throw new PendingException();
	    }

	    @And("^Create cookie on this page$")
	    public void create_cookie_on_this_page() throws Throwable {
	    	Cookie c=new Cookie("Token",value);
	    	driver.manage().addCookie(c);
	      //  throw new PendingException();
	    }

	    @And("^Click Proceed$")
	    public void Click_Proceed() throws Throwable {
	    	driver.findElement(By.xpath("//a[contains(text(),\"Proceed\")]")).click();
	       // throw new PendingException();
	    }

	    @Then("^User will enter to Home Page$")
	    public void user_will_enter_to_home_page() throws Throwable {
	    	Assert.assertEquals("User is Not in Home Page", "End - T.A.T.O.C", driver.getTitle());
	      //  throw new PendingException();
	    }

	    @And("^See Sucessfull message$")
	    public void see_sucessfull_message() throws Throwable {
	    	Assert.assertEquals("User is Not in Home Page", "End", driver.findElement(By.xpath("//h1[@class=\"finish\"]")).getText());
	       // throw new PendingException();
	    	driver.close();
	    }
	
}
