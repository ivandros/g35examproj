package loginTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTestWithOutPageObject {

    WebDriver webDriver;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
    }


    public void validLogin() {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get("https://dashboard.marketgid.com/user/signin");

        webDriver.findElement(By.id("login")).clear();
        webDriver.findElement(By.id("login")).sendKeys("test_sok_2018_09_05@mailinator.com");

        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("12345678");

        webDriver.findElement(By.id("signin")).click();

        Assert.assertTrue("Logo is not present", isLogoPresent());
        Assert.assertTrue("Exit is not present", isExitPresent());


    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    private boolean isLogoPresent() {
        try {
            return webDriver.findElement(By.xpath(".//a[@class='logo']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    private boolean isExitPresent() {
        try {
            return webDriver.findElement(By.xpath(".//a[@class='out']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
