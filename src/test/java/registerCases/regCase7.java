package registerCases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class regCase7 {
	
	@Test
	public void passwordValidation() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Rohit");	
		driver.findElement(By.id("LastName")).sendKeys("Pawar");
		driver.findElement(By.id("Email")).sendKeys("testmail123@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123");
		String validaionString ="The password should have at least 6 characters.";
		Assert.assertEquals(driver.findElement(By.xpath("//span[@for=\"Password\"]")).getText(),validaionString);
		
		driver.close();
		driver.quit();
	}
}
