package registerCases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class regCase9 {

	public void genderRadio() {	
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
		WebElement genderMaleElement =	driver.findElement(By.id("gender-male"));
		WebElement genderFemalElement =driver.findElement(By.id("gender-female"));
		
		genderMaleElement.click();
		assertTrue(genderMaleElement.isSelected());
		assertFalse(genderFemalElement.isSelected());
			
		genderFemalElement.click();
		assertTrue(genderFemalElement.isSelected());
		assertFalse(genderMaleElement.isSelected());
		
		driver.close();
		driver.quit();
		}
}
