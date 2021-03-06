package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;


//TestBase

public class TestBase {
	public static RemoteWebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException
	{

	 prop = new Properties();
				FileInputStream ip = new FileInputStream("./properties/config.properties");
				prop.load(ip);
	}
	
	
	public void initialization() throws InterruptedException{
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.equals("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\DURAI\\Desktop\\POM\\PageObjectModel\\drivers\\IEDriverServer.exe");	
			driver = new InternetExplorerDriver(); 
		}
		
		else if(browserName.equals("chrome")){
			//WebDriverManager.chromedriver().setup();
			
			System.out.println("expected method executed");
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");			
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");	
			
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\DURAI\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
			
			
			driver = new ChromeDriver(chromeOptions); 
		}
		
		
		
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
			driver = new FirefoxDriver(); 
		}
		
		
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	
	}
	

}
