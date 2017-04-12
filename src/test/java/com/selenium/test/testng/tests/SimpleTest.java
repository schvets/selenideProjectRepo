package com.selenium.test.testng.tests;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Sidelnikov Mikhail on 30.07.15.
 * Uses TestNG test framework
 * Test demonstrates simple Selenide functions : how to start browser, open url, insert some text and check that this text was inserted
 * For more information about Selenide visit <a href="http://selenide.org">Selenide</a>
 */
public class SimpleTest {

    @Test
    public void testFillGoogleForm() {
        String toSearch = "Selenium";
        open("http://www.youtube.com");
        SelenideElement searchString = $("#masthead-search-term");
        searchString.sendKeys(toSearch);
        $("#masthead-search-term").shouldHave(value(toSearch));
    }
}
