package com.selenium.test.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Aleksandr on 11.04.2017.
 */
public class AuthPage {
    @FindBy(css = "li.logout > a")
    public SelenideElement exitButton;
    @FindBy(css = "body > div.workspace > div:nth-child(3) > div > div:nth-child(1) > input")
    private SelenideElement loginLabel;
    @FindBy(css = "#input-password")
    private SelenideElement passwordLabel;
    @FindBy(css = "#firstAuth")
    private SelenideElement loginButton;

    /**
     * inserts search text in search string
     *
     * @param text text for input
     */
    public void insertLogin(String text) {
        loginLabel.clear();
        loginLabel.sendKeys(text);
    }

    public void insertPassword(String text) {
        passwordLabel.clear();
        passwordLabel.sendKeys(text);
    }

    public void loginButtonPress() {
        loginButton.click();
    }

}
