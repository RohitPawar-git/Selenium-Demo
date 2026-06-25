package registerCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class regCase8 {

	@Test
	public void allBlankFields() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
		driver.findElement(By.id("register-button")).click();
		assertTrue(driver.findElement(By.xpath("//span[@for=\"FirstName\"]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//span[@for=\"LastName\"]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//span[@for=\"Email\"]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//span[@for=\"Password\"]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//span[@for=\"ConfirmPassword\"]")).isDisplayed());
		
		driver.close();
		driver.quit();
	}
}
