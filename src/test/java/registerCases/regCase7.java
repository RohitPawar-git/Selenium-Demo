package registerCases;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class regCase7 {
	
	@Test
	public void invalidMailCrediantials() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Rohit");
		driver.findElement(By.id("LastName")).sendKeys("Pawar");
		driver.findElement(By.id("Password")).sendKeys("pass12345");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("pass12345");
		
		String emailconfirmqationString = "Wrong email";
		List<String> emails = Arrays.asList(
			    "Rohitpawar",
			    "Rohitpawar@",
			    "Rohitpawar@gmail",
			    "Rohitpawar@gmail.");
		for (String currentmail : emails) 
		{
			WebElement emailfieldElement =driver.findElement(By.id("Email"));
			emailfieldElement.clear();
			emailfieldElement.sendKeys(currentmail);
			driver.findElement(By.id("register-button")).click();
			assertEquals(driver.findElement(By.xpath("//span[@for=\"Email\"]")).getText(), emailconfirmqationString);
			Thread.sleep(1000);		
		}
		
		driver.close();
		driver.quit();
	}
}
