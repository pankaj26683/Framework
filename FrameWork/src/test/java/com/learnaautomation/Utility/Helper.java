package com.learnaautomation.Utility;





import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper 

{

	
	public static String screenshot(WebDriver driver)
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotPath= System.getProperty("user.dir")+ "/Screenshots/ScreenShot_" + getCurrentTime() +".png";
		
		try {
			FileUtils.copyFile(src, new File(screenShotPath));
		} catch (Exception e) {
			
			System.out.println("Unable to capture screenshot "+e.getMessage());
			
		}
		
		return screenShotPath;
		
		
	}
	
	
	
	public static String getCurrentTime()
	{
		DateFormat customDate=new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
		Date currentDate=new Date();
		return customDate.format(currentDate);
	}
}
