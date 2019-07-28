package ultils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {

	public void takeSnapShot(WebDriver driver, String targetPath) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			// Now we are copying the screenshot to the desired location using
			// "copyFile" //method

			FileUtils.copyFile(src, new File(targetPath));
		}

		catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

}
