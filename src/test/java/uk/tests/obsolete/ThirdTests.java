package uk.tests.obsolete;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(TestListener.class)
public class ThirdTests {

    WebDriver chromeDriver;

    @BeforeClass
    public void beforeClass() {
//         driver = new ChromeDriver();
    }


    @Test(groups = {"regression"}, dependsOnMethods = {"test2"})
    public void test1() {
        chromeDriver.get("http://book.theautomatedtester.co.uk/chapter1");

        WebElement radioButton = chromeDriver.findElement(By.id("radiobutton"));
        radioButton.click();

        assertTrue(radioButton.isDisplayed());
    }

    @Test(groups = {"sanity", "regression"})
    public void test2() {
//        driver.get("http://book.theautomatedtester.co.uk/chapter1");
//
//        WebElement homePageLink = driver.findElement(By.linkText("Home Page"));
//        homePageLink.click();
//
//        WebElement chapterLink = driver.findElement(By.linkText("Chapter 1"));
//        String chapterLinkText = chapterLink.getText();
//
//        assertEquals("Chapter 1", chapterLinkText, "Error message");

//        assertEquals((Integer) (Integer.valueOf(parameterOne) + 1), Integer.valueOf(parameterTwo));

        System.out.println("Inside the test");
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

    @DataProvider(name = "data_provider")
    public Object[][] dataProvider() {
        return new Object[][] {{"1","2"}, {"2", "3"}};
    }
}
