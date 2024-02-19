package com.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Page.HomePage;
import com.Page.LoginPage;
import com.main.Constants;
import com.main.PropertyReader;

public class HomePageTest {
	
	SoftAssert sf=new SoftAssert();
	public WebDriver driver;
	PropertyReader propreader=new PropertyReader();
	
	
	
	
	  @BeforeTest 
	  public void initdriver() {
	  
	  
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.manage().window().maximize();
	  driver.get(propreader.readProperty(Constants.URL)); }
	 
	  @BeforeMethod
	  public void testlogin() {
			
			LoginPage myobj=new LoginPage(driver);
			driver.get(propreader.readProperty(Constants.URL));
			String Username=propreader.readProperty(Constants.USERNAME);
			String Password=propreader.readProperty(Constants.PASSWORD);
			myobj.LoginProcess(Username, Password);
			
			}
	  
	  @Test
	  public void carttest() {
		  HomePage obj2=new HomePage(driver);
		  obj2.cart();
		  
		  //driver.navigate().back();
		  
		  
	  }
	  
	  @Test
	  public void facebooktest() {
		  
		  HomePage obj2=new HomePage(driver);
		  obj2.gotofacebook();
		  List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		  driver.switchTo().window(windowHandles.get(1));
		  String currenturl=driver.getCurrentUrl();
		  sf.assertEquals(currenturl,"https://www.facebook.com/saucelabs");
		  sf.assertAll();
		  
	  }
	  
	  @Test
	  
	  public void twittertest() {
		  
		  HomePage obj2=new HomePage(driver);
		  obj2.gototwitter();
		  List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		  driver.switchTo().window(windowHandles.get(1));
		  String currenturl=driver.getCurrentUrl();
		  sf.assertEquals(currenturl,"https://twitter.com/saucelabs");
		  sf.assertAll();
		  
	  }
	  
	  @Test
	  public void linkedintest() {
		  
		  HomePage obj2=new HomePage(driver);
		  obj2.gotolinkedin();
		  List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		  driver.switchTo().window(windowHandles.get(1));
		  String currenturl=driver.getCurrentUrl();
		  sf.assertEquals(currenturl,"https://www.linkedin.com/company/sauce-labs/");
		  sf.assertAll();
		  
	  }
	  
	  @Test
	  public void AddItemtest() {
		  
		  HomePage obj2=new HomePage(driver);
		  obj2.addtocart();
		  
	  }
	  
	  @Test(dependsOnMethods = "AddItemtest")
	  public void RemoveTest() {
		  
		  HomePage obj2=new HomePage(driver);
		  obj2.removeitem();
		  
	  }
	  
	  @Test
	  public void SideMenuTest() {
		  
		  HomePage obj2=new HomePage(driver);
		  obj2.sidemenu();
		  
	  }
	
	


}
