package loginLogout;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class login7 {
	@Test
	public void passwordRecovery()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.xpath("//a[text()='Forgot password?']")).click();
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		driver.findElement(By.xpath("//input[@type=\"submit\" and  @value=\"Recover\"]")).click();
		String actualString ="Email with instructions has been sent to you.";
		assertEquals(driver.findElement(By.className("result")).getText(),actualString);
		driver.close();
		driver.quit();
	}

}
