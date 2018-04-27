package custom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomExpectedCondition {

    //TODO
    public static ExpectedCondition<Boolean> elementHasColor(WebElement element, String color) {
        //rgb/rgba -> hex
        return webDriver -> element.getCssValue("background-color").equals(color);
    }
}
