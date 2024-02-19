package com.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Page.LoginPage;
import com.main.Constants;
import com.main.PropertyReader;

public class LoginTest{
	SoftAssert sf=new SoftAssert();
	public WebDriver driver;
	PropertyReader propreader=new PropertyReader();
	
	
	  @BeforeSuite public void initdriver() {
	  
	  
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.manage().window().maximize();
	  driver.get(propreader.readProperty(Constants.URL));
	  
	  
	  }
	 
	
	
	@Test
	public void testlogin() {
		
		LoginPage myobj=new LoginPage(driver);
		//driver.get(propreader.readProperty(Constants.URL));
		String Username=propreader.readProperty(Constants.USERNAME);
		String Password=propreader.readProperty(Constants.PASSWORD);
		myobj.LoginProcess(Username, Password);
		
		
		}
	
	@Test
	
	public void SubmitText() {
		LoginPage myobj=new LoginPage(driver);
		
		sf.assertEquals(myobj.LoginButton.getText(), "Login");
		sf.assertAll();
		
	}
	
	@Test
	public void ErrorText() {
		LoginPage myobj=new LoginPage(driver);
		
		
		myobj.LoginProcess("om", "patel");
		
		sf.assertEquals(myobj.Errortext.getText(), "Epic sadface: Username and password do not match any user in this service");
		sf.assertAll();
		
	}
	
	
	
	
	@AfterSuite
	public void browserclose() {
		
		driver.close();
	}
	
	
	
	
	
	

}
