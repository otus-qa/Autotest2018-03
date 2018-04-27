package uk.tests.org.jquery;

import org.jquery.pages.TooltipPage;
import org.testng.annotations.Test;
import uk.BaseTest;

import static org.testng.Assert.assertEquals;

public class TooltipTest extends BaseTest {

    @Test
    public void test() {
        TooltipPage tooltipPage = new TooltipPage();
        tooltipPage.switchToIframe();
        tooltipPage.hoverYourAgeInput();
        tooltipPage.waitTooltipIsDisplayed();
        String text = tooltipPage.getTooltipText();
        assertEquals(text, "We ask for your age only for statistical purposes.");
    }
}
