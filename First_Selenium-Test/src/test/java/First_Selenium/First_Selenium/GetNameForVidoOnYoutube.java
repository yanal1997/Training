package First_Selenium.First_Selenium;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class GetNameForVidoOnYoutube {////
	@Test
	public void openWebDriver() throws InterruptedException {
		System.setProperty("webdriver.firefox.driver", "C://Program Files//Mozilla Firefox//firefox.exe");

		WebDriver webDriver = new FirefoxDriver();
		webDriver.get("http://www.google.com");
		WebElement googleSearchBar = webDriver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
		googleSearchBar.sendKeys("youtube");
		googleSearchBar.submit();
		// wait till search finishes
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, 30);
		webDriverWait.until(ExpectedConditions.titleContains("youtube"));
		List<WebElement> youTubeUrlElements=webDriver.findElements(By.className("iUh30"));
		Assert.assertTrue(youTubeUrlElements.get(0).getText().contains("www.youtube.com"),"erroyoutube not Found ");//
		List<WebElement> youtubeElement = webDriver.findElements(By.xpath("//*[@id='rso']//h3/a")); // youtubeElement
																									// we
																									// find
																									// after
																									// the
																									// search
																									// in
																									// google
		youtubeElement.get(0).click();
		webDriverWait.until(ExpectedConditions.textToBe(By.id("title"), "Trending"));// wait
																						// until
																						// the
																						// page
																						// load
		WebElement youtubeSearchBar = webDriver.findElement(By.name("search_query"));
		youtubeSearchBar.sendKeys("havana");
		youtubeSearchBar.submit();
		Thread.sleep(2000);// time wait for page load
		List<WebElement> resultFromYoutubeSearch = webDriver.findElements(By.xpath("//*[@id=\"video-title\"]"));
		resultFromYoutubeSearch.get(0).click();
		Thread.sleep(1000);
		List<WebElement> youtubeSongName = webDriver.findElements(By.xpath("//*[@id=\"info-contents\"]"));
		Assert.assertTrue(youtubeSongName.get(0).getText().contains("Camila Cabello - Havana (Audio) ft. Young Thug"),
				"erro in vido not the same name");
		 Thread.sleep(1000);
		webDriver.close();

	}

}
