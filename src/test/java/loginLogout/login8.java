package loginLogout;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class login8 {

	@Test
	public void passRecoveryWrongMail() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.xpath("//a[text()='Forgot password?']")).click();
		driver.findElement(By.id("Email")).sendKeys("notexist_xyz@demo.com");
		driver.findElement(By.xpath("//input[@type=\"submit\" and  @value=\"Recover\"]")).click();
		assertEquals(driver.findElement(By.className("result")).getText(),"Email not found.");
		driver.close();
		driver.quit();	
	}
}
