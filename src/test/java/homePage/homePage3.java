package homePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sun.source.tree.AssertTree;

public class homePage3 {
	
	@Test
	public void searchTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		
		WebElement searchButton = driver.findElement(By.id("small-searchterms"));
		searchButton.sendKeys("book");
		searchButton.click();
		driver.findElement(By.xpath("//input[@value=\"Search\"]")).click();
		
		assertTrue(driver.findElement(By.xpath("//img[@alt=\"Picture of Health Book\"]")).isDisplayed());	
		assertTrue(driver.findElement(By.className("actual-price")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//h2[@class=\"product-title\"]")).isDisplayed());
		
		driver.close();
		driver.quit();
	}

}
