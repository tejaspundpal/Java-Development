package seleniumLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;

    @SuppressWarnings("deprecation")
	@BeforeMethod
    public void setUp(){
        webDriver=new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test(priority = 1)
    public void testLogin1() throws InterruptedException {
        webDriver.get("https://www.linkedin.com");
        webDriver.manage().window().maximize();
        WebElement emailTextBox=webDriver.findElement(By.id("session_key"));
        emailTextBox.sendKeys("yourId");
        WebElement passwordTextBox=webDriver.findElement(By.id("session_password"));
        passwordTextBox.sendKeys("yourPassword");
        WebElement signInBtn=webDriver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/div/div/form/div[2]/button"));
        signInBtn.click();
        Thread.sleep(2000);
        String u = webDriver.getCurrentUrl();
		
		if(u.equals("https://www.linkedin.com/feed/?trk=homepage-basic_sign-in-submit")) {
			System.out.println("Test case passed");
		}
		else {
			System.out.println("Test case failed");
		}
		
    }
    
    @Test(priority = 2)
    public void testLogin2() throws InterruptedException {
        webDriver.get("https://www.linkedin.com");
        webDriver.manage().window().maximize();
        WebElement emailTextBox=webDriver.findElement(By.id("session_key"));
        emailTextBox.sendKeys("yourId");
        WebElement passwordTextBox=webDriver.findElement(By.id("session_password"));
        passwordTextBox.sendKeys("invalidPassword");
        WebElement signInBtn=webDriver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/div/div/form/div[2]/button"));
        signInBtn.click();
        Thread.sleep(2000);
        String u = webDriver.getCurrentUrl();
		
		if(u.equals("https://www.linkedin.com/feed/?trk=homepage-basic_sign-in-submit")) {
			System.out.println("Test case passed");
		}
		else {
			System.out.println("Test case failed");
		}
		
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }

}
