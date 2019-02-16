package TestCase;



import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestBase.TestBase;
import TestPages.LoginPage;
import TestUtil.TestUtil;
import junit.framework.Assert;

public class LoginPage_TestCase extends TestBase {
	
	LoginPage loginpage;
	TestUtil util;
	
	public LoginPage_TestCase() throws IOException {
		super();
		
	}
	
	@BeforeTest
	public void setup() throws IOException, InterruptedException
	{   
		new LoginPage_TestCase();
		loginpage = new LoginPage(); 
		initialization();		
		util= new TestUtil();
		 
		 
		  
		
	}
	
	@DataProvider
	public Object[][] getlogindata() throws IOException{
		Object data[][] = util.read_excel();
		return data;
	}

	@Test(dataProvider="getlogindata")
	public void validatelogin(String Username, String Password){
		
		loginpage.login(Username, Password);
		Assert.assertEquals("Leaftaps - TestLeaf Automation Platform", driver.getTitle());
		

	}
	
	



}
