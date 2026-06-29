package loginLogout;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login10 {

    @Test
    public void checkPersistentLogin() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com/");

        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("xyz0999@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("N4Jdb7BdrR!YGz");
        driver.findElement(By.id("RememberMe")).click();
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        assertEquals(driver.findElement(By.className("account")).getText(),
                "xyz0999@gmail.com");
        driver.close();
        driver.quit();

        // Reopen browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com/");

        assertEquals(driver.findElement(By.className("account")).getText(),"xyz0999@gmail.com");

        driver.close(); 
        driver.quit();
    }
}