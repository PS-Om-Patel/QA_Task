package com.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	
	  public HomePage(WebDriver driver) { 
		  PageFactory.initElements(driver, this);
	  
	  }
	 
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	public static WebElement ShoppingCartButton;
	
	@FindBy(xpath="(//div[@class='inventory_item_name '])[1]")
	public static WebElement FirstItem;
	
	@FindBy(id="react-burger-menu-btn")
	public static WebElement BurgerMenuButton;
	
	@FindBy(className = "social_facebook")
	public static WebElement FaceBookHandle;
	
	@FindBy(className = "social_twitter")
	public static WebElement TwitterHandle;
	
	@FindBy(className = "social_linkedin")
	public static WebElement LinkedinHandle;
	
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-backpack']")
	public static WebElement AddToCartButton;
	
	@FindBy(id="remove-sauce-labs-backpack")
	public static WebElement RemoveButton;
	
	
	public void cart() {
		ShoppingCartButton.click();
		
	}
	
	public void firstitem() {
		FirstItem.click();
	}
	
	public void gotofacebook() {
		FaceBookHandle.click();
		
	}
	
	public void gototwitter() {
		TwitterHandle.click();
	}
	
	public void gotolinkedin() {
		LinkedinHandle.click();
	}
	
	public void addtocart() {
		AddToCartButton.click();
	}
	
	public void removeitem() {
		RemoveButton.click();
	}

	public void sidemenu() {
		BurgerMenuButton.click();
	}
}
