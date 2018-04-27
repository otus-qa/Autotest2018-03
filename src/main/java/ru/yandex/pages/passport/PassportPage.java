package ru.yandex.pages.passport;

import base.BasePage;
import ru.yandex.pages.passport.components.ContentBlock;

public class PassportPage extends BasePage {

    ContentBlock contentBlock;

    public void inputToContentBlockLogin(String login) {
        contentBlock = new ContentBlock();
        contentBlock.inputToLogin(login);
    }

    public boolean isContentBlockDisplayed() {
        contentBlock = new ContentBlock();
        return contentBlock.isContentBlockDisplayed();
    }

    public String getSignInBackgroundColor() {
        contentBlock = new ContentBlock();
        return contentBlock.getSignInButtonBackgroundColor();
    }
}
