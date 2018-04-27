package uk;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static utils.WebDriverManager.getDriver;

public class BaseTest {

    Map<String, Set<Cookie>> usersCookies = new HashMap<>();

    protected WebDriver driver;

    int timeout = 10;

    String url = "http://demo.guru99.com/test/cookie/selenium_aut.php";

    @BeforeClass
    public void beforeClass() {
        //before class
//        WebDriverManager.firefoxdriver().setup();
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    protected void authorizeMe(String username, String password) {
        Set<Cookie> userCookies = usersCookies.get(username);
        if (userCookies == null) {
            getDriver().findElement(By.name("username")).sendKeys(username);
            getDriver().findElement(By.name("password")).sendKeys(password);
            getDriver().findElement(By.name("submit")).click();
            Set<Cookie> cookies = getDriver().manage().getCookies();
            usersCookies.put(username, cookies);
        } else {
            userCookies.forEach(cookie -> getDriver().manage().addCookie(cookie));
        }
    }
}
