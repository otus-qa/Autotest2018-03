package uk.tests.com.guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import uk.BaseTest;

import java.util.Set;

import static org.testng.Assert.assertFalse;
import static utils.WebDriverManager.getDriver;

public class LoginTest extends BaseTest {

    private Set<Cookie> cookies;

    @Test
    public void test() throws InterruptedException {
        getDriver().manage().deleteAllCookies();
        authorizeMe("email@email.com", "super_password");
        getDriver().manage().deleteAllCookies();
        authorizeMe("email@email.com", "super_password");
        getDriver().navigate().refresh();
        Thread.sleep(20000);
        System.out.println();
    }

    @Test
    public void test2() throws InterruptedException {
        getDriver().manage().deleteAllCookies();
        authorizeMe("email@email.com", "super_password");
        getDriver().manage().deleteAllCookies();
        authorizeMe("email@email.com", "super_password");
        getDriver().navigate().refresh();
        Thread.sleep(20000);
        System.out.println();
    }
}
