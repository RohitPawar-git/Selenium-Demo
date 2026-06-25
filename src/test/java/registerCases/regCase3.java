package registerCases;

import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class regCase3 {

	@Test
	public void LastNameValidation()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demowebshop.tricentis.com/");
		//Form submission
		driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("User");
		driver.findElement(By.id("Email")).sendKeys(generateMail());
		driver.findElement(By.id("Password")).sendKeys("Test@1234");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Test@1234");
		driver.findElement(By.id("register-button")).click();
		//Verification
		String actualresultString ="Last name is required.";
		Assert.assertEquals(driver.findElement(By.xpath("//span[@for=\"LastName\"]")).getText(),actualresultString);

		driver.close();
		driver.quit();
	}
		// Every Time new mail will be get generated.
	   static String generateMail()
	{
		Date date=new Date();
		String s = date.toString();
		s=s.replaceAll(":","");
		s=s.replaceAll(" ","");
		return "blank_fn"+ s + "@demo.com";
	}
		
}
