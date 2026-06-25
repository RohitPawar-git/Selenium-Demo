package homePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class homePage1
{
	@Test
	public void homeVerify()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		
		String urlString = driver.getCurrentUrl();
		assertEquals(driver.getCurrentUrl(), urlString);
		String titeString = driver.getTitle();
		assertEquals(driver.getTitle(), titeString);
		String registervalString=	driver.findElement(By.className("ico-register")).getText();
		assertEquals(driver.findElement(By.className("ico-register")).getText(), registervalString);
		String loginvalString = driver.findElement(By.className("ico-login")).getText();
		assertEquals(driver.findElement(By.className("ico-login")).getText(), loginvalString);
		String shopCartString = driver.findElement(By.className("cart-label")).getText();
		assertEquals(driver.findElement(By.className("cart-label")).getText(), shopCartString);
		
		WebElement logoElement = driver.findElement(By.xpath("//img[@alt=\"Tricentis Demo Web Shop\"]"));
		assertTrue(logoElement.isDisplayed(), "Logo Displayed");
		
		driver.close();
		driver.quit();
	}
}
