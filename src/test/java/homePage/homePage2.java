package homePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.Driver;
import java.sql.Time;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class homePage2 {	
	@Test
	public void verifyCategories()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		
		List<WebElement> categoryList = driver.findElements(By.xpath("//div[@class='listbox']//ul[@class='list']/li/a"));
		for (WebElement  singleCategory: categoryList) 
		{
			assertTrue(singleCategory.isDisplayed());
			singleCategory.click();
			driver.navigate().back();
		}
		driver.close();
	}
}
