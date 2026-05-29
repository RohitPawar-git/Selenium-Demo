package registerCases;

import java.sql.DriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class regCase4 {
	@Test
	void testCase4()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[@href=\"/register\"]")).click();
		driver.findElement(By.id("register-button")).click();
		
		String firstnamewarningString= "First name is required.";
		String LastnamewarningString= "Last name is required.";
		String EmailwarningString= "Email is required.";
		String PasswordwarningString= "Password is required.";
		String ConfirmPasswordwarningString= "Password is required.";
		
		Assert.assertEquals(driver.findElement(By.xpath("//span[@for='FirstName']")).getText(),firstnamewarningString);
		Assert.assertEquals(driver.findElement(By.xpath("//span[@data-valmsg-for=\"LastName\"]")).getText(),LastnamewarningString);
		Assert.assertEquals(driver.findElement(By.xpath("//span[@for=\"Email\"]")).getText(), EmailwarningString);
		Assert.assertEquals(driver.findElement(By.xpath("//span[@data-valmsg-for=\"Password\"]")).getText(), PasswordwarningString);
		Assert.assertEquals(driver.findElement(By.xpath("//span[@data-valmsg-for=\"ConfirmPassword\"]")).getText(), ConfirmPasswordwarningString);
		
		driver.close();
	}

}
