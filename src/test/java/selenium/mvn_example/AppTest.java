package selenium.mvn_example;

import static org.junit.Assert.assertTrue;

//import org.junit.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ultils.TakeScreenshot;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private String getSiteName;
	private String pathWithFileNameSP;
	private String pathWithFileNameRP;
	private Boolean flag;

	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	@Test
	public void gSearch() throws InterruptedException {
		pathWithFileNameSP = "searchPage.png";
		pathWithFileNameRP = "searchResPage.png";
		getSiteName = "fresco.me";

		System.setProperty("webdriver.chrome.driver",
				"chromedriver_linux64/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");

		// We are getting the page title and printing it in a console to verify
		// that we are in the right page.

		System.out.println("Page Title : " + driver.getTitle());

		// Searching for "Fresco Play" in Google search

		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Fresco Play");

		TakeScreenshot scrshot = new TakeScreenshot();
		scrshot.takeSnapShot(driver, pathWithFileNameSP);

		driver.findElement(By.xpath("//*[@type='submit']"))
				.sendKeys(Keys.ENTER);

		scrshot.takeSnapShot(driver, pathWithFileNameRP);

		/*
		 * Thread.sleep(5000); System.out.println("Page Title : " +
		 * driver.getTitle());
		 * 
		 * // Click "Fresco Apps" link from the search list
		 * 
		 * //
		 * driver.findElement(By.xpath("//*[@id='rso']/div/div/div[2]/div/div/h3/a"
		 * )).click();
		 * driver.findElement(By.xpath("//*[@id='rso']/div/div/div/link"
		 * )).click();
		 * 
		 * Thread.sleep(5000); System.out.println("Page Title : " +
		 * driver.getTitle());
		 */
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// get all the search results
		List<WebElement> linkElements = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
						.xpath("//div[@class='r']/a")));
		// .xpath("//*[@id='rso']/div/div/div/link")));

		for (WebElement eachResult : linkElements) {
			if (eachResult.getAttribute("href").contains(getSiteName)) {
				eachResult.click();
				System.out.println("Page Title : " + driver.getTitle());
				flag = true;
				break;
			}
		}

		if (!flag) {
			System.out.println("Did not find the search result............");
		}

		 driver.quit();
	}

}
