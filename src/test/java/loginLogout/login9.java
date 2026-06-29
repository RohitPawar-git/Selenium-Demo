package loginLogout;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class login9 {

	@Test
	public void logout() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys("xyz0999@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("N4Jdb7BdrR!YGz");
		driver.findElement(By.xpath("//input[@type=\"submit\" and @value=\"Log in\"]")).click();

		assertEquals(driver.findElement(By.className("account")).getText(),"xyz0999@gmail.com");
		
		driver.findElement(By.className("ico-logout")).click();
		assertTrue(driver.findElement(By.className("ico-register")).isDisplayed());
		assertTrue(driver.findElement(By.className("ico-login")).isDisplayed());
		
		driver.close();
		driver.quit();
	}
}
