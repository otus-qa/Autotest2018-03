package uk.tests.ru.yandex;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.pages.passport.PassportPage;
import ru.yandex.pages.search.YandexSearchPage;
import uk.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class YandexTest extends BaseTest {

    @Test
    public void test() {
        YandexSearchPage searchPage = new YandexSearchPage();

        PassportPage passportPage = searchPage.clickOnEmailBlockEmailButton();
        passportPage.inputToContentBlockLogin("email@email.com");
        String signInBackgroundColor = passportPage.getSignInBackgroundColor();

        assertEquals(signInBackgroundColor, "rgba(0,0,0,1)");

        assertTrue(passportPage.isContentBlockDisplayed());
    }
}
