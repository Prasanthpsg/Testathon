package FirstTestng;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Screenshot extends MyTestng {
	
	public static void Takesnap(String Name) throws IOException {
		
		/*long strtime= System.currentTimeMillis();
		
		//1.take screenshot and store it as file format
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//2. copy the screenshot to desired location using File handler method
		FileHandler.copy(src, new File("./Screenshot/"+Name+"_"+strtime+".png"));*/
		
		long strtime= System.currentTimeMillis();
		
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(source, new File("./Screenshot/"+Name+"_"+strtime+".png"));
		
		
	
		
	}

}
