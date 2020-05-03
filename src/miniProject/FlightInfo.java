package miniProject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Screenshot.makeMyTrip_ss;

/**
@author ${Apurwa Anand}
*
*${856829} 
*/

public class FlightInfo extends basePage {
		public WebDriver driver;
		public FlightInfo(WebDriver driver) {
			
			this.driver=driver;
			
		}
		
	
	
	public void listOfFlights() {
		WebElement sort=driver.findElement(By.xpath("//*[@id='sorting-togglers']/div[5]/span"));
	    sort.click();
	    makeMyTrip_ss.Capture_Screenshot(driver, "Search_Results");

	List<WebElement> flights=driver.findElements(By.xpath("//div[@class='fli-intl-lhs pull-left']/div[3]/div/div[position()<=5]"));  
	for(WebElement flight : flights) {
		String Flightdetails=flight.getText();
		if(!Flightdetails.isEmpty()) {
			System.out.println(Flightdetails);
			}
		
		}	
	}
	

}

