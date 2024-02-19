package com.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	 
	
	@FindBy(id = "user-name")
	public static WebElement UserName;
	
	@FindBy(id="password")
	public static WebElement Password;
	
	@FindBy(id="login-button")
	public static WebElement LoginButton;
	
	@FindBy(xpath="//h3[@data-test=\"error\"]")
	public static WebElement Errortext;
	
	
	
	public void LoginProcess(String uname,String passwd) {
		
		UserName.clear();
		UserName.sendKeys(uname);
		
		Password.clear();
		Password.sendKeys(passwd);
		
		LoginButton.click();
	}
	
	
	

}
