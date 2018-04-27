package custom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomExpectedCondition {

    //TODO Implement a Color class which should have methods to convert rgb/rgba to hex.
    // 1. Add the class to the method as an argument.
    // 2. The converting method should run automatically depend on WebDriver instance.
    public static ExpectedCondition<Boolean> elementHasColor(WebElement element, String color) {
        //rgb/rgba -> hex
        return webDriver -> element.getCssValue("background-color").equals(color);
    }
}
