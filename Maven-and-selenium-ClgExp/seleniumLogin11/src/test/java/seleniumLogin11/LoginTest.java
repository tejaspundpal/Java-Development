package seleniumLogin11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tejas Pundpal\\Downloads\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.linkedin.com");

        WebElement usernameField = driver.findElement(By.id("session_key"));
        WebElement passwordField = driver.findElement(By.id("session_password"));

        usernameField.sendKeys("yourId");
        passwordField.sendKeys("yourPassword");

        WebElement loginButton=driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/div/div/form/div[2]/button"));
        loginButton.click();

//        Thread.sleep(5000);
        String u = driver.getCurrentUrl();
		
		if(u.equals("https://www.linkedin.com/feed/?trk=homepage-basic_sign-in-submit")) {
			System.out.println("Test case passed");
		}
		else {
			System.out.println("Test case failed");
		}

        driver.quit();
    }
}

