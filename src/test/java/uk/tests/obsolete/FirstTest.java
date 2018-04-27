package uk.tests.obsolete;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTest {

//    @Test
    public void test() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://yandex.ru");

        WebElement enterToEmail = driver.findElement(By.cssSelector("div[role='form'] > a.button"));

        enterToEmail.click();

        WebElement inputLogin = driver.findElement(By.name("login"));

        inputLogin.sendKeys("invalid@email.com");

        WebElement inputPassword = driver.findElement(By.name("passwd"));

        inputPassword.sendKeys("secretpassword");

        WebElement buttonSubmit = driver.findElement(By.cssSelector("button[type='submit']"));

        buttonSubmit.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("div.passport-Domik-Form-Error"));

//        assertTrue(errorMessage.isDisplayed());

        driver.quit();
    }

}
