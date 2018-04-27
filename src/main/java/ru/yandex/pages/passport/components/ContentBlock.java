package ru.yandex.pages.passport.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.components.IComponent;

import static utils.WebDriverManager.getDriver;

public class ContentBlock implements IComponent {

    private final static By CONTENT_BLOCK = By.xpath("//div[contains(@class,'passport-Page-Content')]");

    private final static By LOGIN_INPUT = By.name("login");

    private final static By SIGN_IN_BUTTON = By.id("");

    public void inputToLogin(String loginName) {
        WebElement inputLogin = getRootElement().findElement(LOGIN_INPUT);
        inputLogin.sendKeys(loginName);
    }

    public boolean isContentBlockDisplayed() {
        return getRootElement().isDisplayed();
    }

    public String getSignInButtonBackgroundColor() {
        WebElement signButton = getRootElement().findElement(SIGN_IN_BUTTON);
        return signButton.getCssValue("background-color");
    }

    public WebElement getRootElement() {
        return getDriver().findElement(CONTENT_BLOCK);
    }


}
