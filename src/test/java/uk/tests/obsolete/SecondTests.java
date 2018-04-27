package uk.tests.obsolete;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import uk.BaseTest;

import static utils.WebDriverManager.getDriver;


public class SecondTests extends BaseTest {

    @FindBy(xpath = "")
    WebElement element;

    @org.testng.annotations.Test
    public void test1() {
        driver.get("http://book.theautomatedtester.co.uk/chapter1");

        WebElement radioButton = driver.findElement(By.id("radiobutton"));

        radioButton.findElement(By.xpath("./a"));
        radioButton.click();

    }

    public void test2() {
        driver.get("http://book.theautomatedtester.co.uk/chapter1");

        WebElement homePageLink = driver.findElement(By.linkText("Home Page"));
        homePageLink.click();

        WebElement chapterLink = driver.findElement(By.linkText("Chapter 1"));
        String chapterLinkText = chapterLink.getText();

//        assertEquals("Error message", chapterLinkText, "Chapter 1");
    }

    @org.testng.annotations.Test
    public void test3() {
        WebElement selectElement = getDriver().findElement(By.id("selecttype"));

        Select select = new Select(selectElement);
        select.selectByValue("Selenium Grid");

        String expectedText = "The following text has been loaded from another page on this site. " +
                "It has been loaded in an asynchronous fashion so that we can work through the AJAX section " +
                "of this chapter";

        WebElement linkAjax = driver.findElement(By.id("loadajax"));
        linkAjax.click();

        WebElement textAreaAjax = driver.findElement(By.id("ajaxdiv"));

//        assertEquals(textAreaAjax.getText(), expectedText);
//        assertTrue(textAreaAjax.isDisplayed());

        WebElement homePage = driver.findElement(By.partialLinkText("Home Page"));
        homePage.click();

        WebElement chapter2 = driver.findElement(By.partialLinkText("Chapter2"));
        chapter2.click();

        WebElement sublingButton = driver.findElement(By.xpath("//*[@id='but1']/following-sibling::input"));
        sublingButton.click();

//        assertTrue(sublingButton.isDisplayed());
    }

}
