package uk.tests.obsolete;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import uk.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DragAndDropTest extends BaseTest {

    @Test
    public void test() {
        WebElement bankBlock = driver.findElement(By.cssSelector("#credit2 a"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(bankBlock));

        WebElement accountDebitSideBlock = driver.findElement(By.cssSelector("#bank li"));

        Actions actions = new Actions(driver);

        Action action = actions
                .dragAndDrop(bankBlock, accountDebitSideBlock)
                .build();

        action.perform();

        driver.get("https://yahoo.com");

        WebElement firstItemTrendingNowBlock = driver.findElement(By.cssSelector(".trending-list a[data-rapid_p='1']"));

        actions.keyDown(Keys.LEFT_SHIFT)
                .clickAndHold(firstItemTrendingNowBlock)
                .release()
                .contextClick()
                .keyUp(Keys.LEFT_SHIFT).build().perform();

        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.BUTTON1_DOWN_MASK);
            robot.keyRelease(KeyEvent.BUTTON1_DOWN_MASK);

        } catch (AWTException e) {
            e.printStackTrace();
        }

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        WebElement buttonMail = (WebElement) javascriptExecutor.executeAsyncScript("document.getElementById(\"mega-bottombar-mail\")");
    }
}
