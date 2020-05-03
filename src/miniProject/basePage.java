package miniProject;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;

/**
 @author ${Apurwa Anand}
 *
 *${856829} 
 */

public class basePage {
	public WebDriver driver;
	public Properties prop;
	
	public void invokeBrowser(String browserName) {
		
		try
		{
			prop= new Properties();
			FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\src\\config.properties");
			prop.load(file);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		if(prop.getProperty(browserName).equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(prop.getProperty(browserName).equalsIgnoreCase("Mozilla"))
		
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
			driver= new FirefoxDriver();
			
		}
		else if(prop.getProperty(browserName).equalsIgnoreCase("Opera"))
		{
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir")+"\\drivers\\operadriver.exe");
			driver= new OperaDriver();
		}
		else if(prop.getProperty(browserName).equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
			driver= new OperaDriver();
		}
		
		  else if(prop.getProperty(browserName).equalsIgnoreCase("edge")) {
		  System.setProperty("webdriver.edge.driver",
		  System.getProperty("user.dir")+"\\drivers\\msedgedriver.exe"); driver= new
		  EdgeDriver(); }
		 
		else {
			System.out.println("Browser not correct");
		}
		//putting implicit wait and maximizing the browser window
		
		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(250, TimeUnit.SECONDS);
			
	}
	
	public LandingPage openApp(String websiteURL) {
		
		driver.get(prop.getProperty(websiteURL));
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
	//quit the browser
	public void QuitBrowser()
	{
		driver.quit();
	}
	
	

}
