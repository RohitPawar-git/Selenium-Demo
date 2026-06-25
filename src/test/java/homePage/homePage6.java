package homePage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homePage6 {
	
	@Test
	public void testImage()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demowebshop.tricentis.com/");
		WebElement image = driver.findElement(By.xpath("//img[@title='Speed | Tricentis']"));

		Boolean imageLoaded = (Boolean) ((JavascriptExecutor) driver)
			        .executeScript(
			            "return arguments[0].complete && " +
			            "typeof arguments[0].naturalWidth != 'undefined' && " +
			            "arguments[0].naturalWidth > 0",
			            image);

		Assert.assertTrue(imageLoaded, "Image is broken");
		driver.close();
		driver.quit();
	}
}
