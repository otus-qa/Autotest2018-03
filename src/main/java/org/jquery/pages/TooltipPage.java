package org.jquery.pages;

import base.BasePage;
import custom.CustomExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.WebDriverManager.getDriver;

public class TooltipPage extends BasePage {

    private static final By IFRAME = By.cssSelector("#content > iframe");

    private static final By AGE_INPUT = By.cssSelector("#age");

    private static final By TOOLTIP = By.xpath("//div[@role='tooltip']");

    public void switchToIframe() {
        WebElement iframe = getDriver().findElement(IFRAME);
//        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IFRAME));
//        getDriver().switchTo().frame(getDriver().findElement(IFRAME));
        getDriver().switchTo().frame(getDriver().findElement(IFRAME));
    }

    public void hoverYourAgeInput() {
        WebElement ageInput = getDriver().findElement(AGE_INPUT);
        Actions actions = new Actions(getDriver());

        actions.moveToElement(ageInput).build().perform();
    }

    public void waitTooltipIsDisplayed() {
        WebElement tooltip = getDriver().findElement(TOOLTIP);
        new WebDriverWait(getDriver(), getTimeout()).until(
                ExpectedConditions.visibilityOf(tooltip)
        );
    }

    public String getTooltipText() {
        WebElement tooltip = getDriver().findElement(TOOLTIP);
        return tooltip.getText();
    }

    public boolean tooltipHasColor(String color) {
        WebElement tooltip = getDriver().findElement(TOOLTIP);
        return new WebDriverWait(getDriver(), getTimeout(), 100).until(
                CustomExpectedCondition.elementHasColor(tooltip, color));
    }

}
