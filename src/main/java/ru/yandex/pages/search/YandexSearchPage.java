package ru.yandex.pages.search;

import base.BasePage;
import ru.yandex.pages.passport.PassportPage;
import ru.yandex.pages.search.components.EmailBlock;

public class YandexSearchPage extends BasePage {

    EmailBlock emailBlock;

    public PassportPage clickOnEmailBlockEmailButton() {
        emailBlock = new EmailBlock();
        emailBlock.clickOnEnterToEmailButton();

        return new PassportPage();
    }
}
