package com.selenium.test.testng.tests;

import com.codeborne.selenide.Configuration;
import com.selenium.test.pages.AuthPage;
import com.selenium.test.pages.ReportPage;
import com.selenium.test.utils.TestConfig;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.hasText;
import static com.codeborne.selenide.Selenide.open;


/**
 * Created by Aleksandr on 11.04.2017.
 */
public class AuthTest {
    @BeforeTest
    public void setUpBrowser() {
        Configuration.browser = "chrome";
    }

    @BeforeTest
    public void testAuth() throws InterruptedException {
        AuthPage authPage = open("https://salary.privatbank.ua", AuthPage.class);
        authPage.insertLogin(new TestConfig().getLdapUser());
        authPage.insertPassword(new TestConfig().getLdapPass());
        authPage.loginButtonPress();
        authPage.exitButton.waitUntil(hasText("Выход"), 1000000);

    }

    @Test
    public void getAnnualInkasrReport() {
        ReportPage reportPage = open("http://prominreports.privatbank.ua/WebVyborkiIQ/Vyborki", ReportPage.class);
        reportPage.crateAndGetAnnualInkasrReport();
    }
}