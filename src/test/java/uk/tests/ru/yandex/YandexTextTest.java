package uk.tests.ru.yandex;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import uk.BaseTest;

public class YandexTextTest extends BaseTest {

    @Test
    public void test() {
        String text = driver.findElement(By.tagName("html")).getText();

        System.out.println(text);
    }
}
