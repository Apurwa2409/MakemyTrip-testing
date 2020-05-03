package miniProject;

import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Screenshot.makeMyTrip_ss;

/**
@author ${Apurwa Anand}
*
*${856829} 
*/

public class LandingPage extends basePage {
	public WebDriver driver;
	public Properties prop;
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	@FindBy(xpath ="//*[@id='root']/div/div[2]/div/div/div[1]/ul/li[1]")
	public WebElement OneWay;
	
	@FindBy(id="fromCity")
	public WebElement From;
	
	
	
	@FindBy(xpath="//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")
	public WebElement fromcity;
	
	@FindBy(id="react-autowhatever-1-section-0-item-0")
	public WebElement autoSuggestion1;
	
	@FindBy(id="toCity")
	public WebElement To;
	
	
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	public WebElement toc;
	
	@FindBy(xpath="//*[@id='react-autowhatever-1-section-0-item-0']")
	public WebElement autoSuggestion2;
	
	@FindBy(xpath="//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[3]/label")
	public WebElement departureDate;
	
	//selectDateIncalendar("date of next friday");
	//@FindBy(xpath="//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]")
	//public WebElement Arrow;
	
	//@FindBy(xpath="//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[6]/div")
	//public WebElement date;
	
	@FindBy(xpath="//*[@id='root']/div/div[2]/div/div/div[2]/p/a")
	public WebElement Search;
	
	public FlightInfo travelDetails(String from , String to,String traveldate) {
		
		try
		{
			prop= new Properties();
			FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\src\\config.properties");
			prop.load(file);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		OneWay.click();
		
		From.click();
		fromcity.sendKeys(prop.getProperty(from));
		
		  try { 
			  Thread.sleep(3000); 
		  }
		  catch (InterruptedException e) { 
			  // TODO Auto-generated catch block 
		  e.printStackTrace(); }
		 
		autoSuggestion1.click();
		 makeMyTrip_ss.Capture_Screenshot(driver, "Putting_Source");
		
		//To.click();
		
		toc.sendKeys(prop.getProperty(to));
		
		  try { 
			  Thread.sleep(3000); 
			  } catch (InterruptedException e) {
				  // TODO Auto-generated 
		        e.printStackTrace();
		  }
		 makeMyTrip_ss.Capture_Screenshot(driver, "Putting_Destination");
		autoSuggestion2.click();
		
		selectDateInCalendar(prop.getProperty(traveldate));
		
		Search.click();
		 
		 
		return PageFactory.initElements(driver, FlightInfo.class);
	}
	private void selectDateInCalendar(String date) {
		 Date currentDate = new Date();
		 
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
		 try {
			Date expectedDate = dateFormat.parse(date);

			String day = new SimpleDateFormat("dd").format(expectedDate);
			String month = new SimpleDateFormat("MMMM").format(expectedDate);
			String year = new SimpleDateFormat("yyyy").format(expectedDate);

			String expectedMonthYear = month + " " + year;
			//String journeyDay=year+month+day;

			while (true) {
				String displayDate = driver.findElement(By.className("DayPicker-Caption")).getText();

				if (expectedMonthYear.equals(displayDate))
				{
					driver.findElement(By.xpath("//p[contains(text(),"+day+")]")).click();
					break;
				} 
				else if (expectedDate.compareTo(currentDate) > 0) {
					driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				} else {
					driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--prev']")).click();
				}

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	
}

