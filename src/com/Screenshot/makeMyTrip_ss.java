package com.Screenshot;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

/**
@author ${Apurwa Anand}
*
*${856829} 
*/ 

public class makeMyTrip_ss {
	
	public static void Capture_Screenshot(WebDriver driver ,String snapshot_name) {
		try
		{ TakesScreenshot ts = (TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		
		
		FileHandler.copy(source, new File("./Screenshots/"+snapshot_name+".png"));
		
		System.out.println("Screenshot taken");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured while taking screenshot "+e.getMessage());
		}
	}

}
