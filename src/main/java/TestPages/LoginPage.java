package TestPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;



public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	
	
	//Initializing the Page Objects:
	public LoginPage()throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public void login(String user, String pass){
		
		System.out.println("username ="+user+"password="+pass);
		//driver.findElementById("username").sendKeys(user);
		username.sendKeys(user);
		
		password.sendKeys(pass);
		loginBtn.click();
	}
	
	
	
	
	
}
