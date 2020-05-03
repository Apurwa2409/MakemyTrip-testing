package miniProject;

import org.testng.annotations.Test;

/**
@author ${Apurwa Anand}
*
*${856829} 
*/

public class TestFlight extends basePage {
	
	LandingPage landingPage;
	FlightInfo flightInfo;
	
	
	
	@Test
	public void FlightSearch() {
		
		basePage bp=new basePage();
		bp.invokeBrowser("browserName");
		landingPage=bp.openApp("websiteURL");
		flightInfo=landingPage.travelDetails("from","to","traveldate");
		flightInfo.listOfFlights();
		
		bp.QuitBrowser();
	}
	
}
