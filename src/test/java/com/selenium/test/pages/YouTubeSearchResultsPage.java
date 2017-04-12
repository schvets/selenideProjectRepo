package com.selenium.test.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindBy;

/**
 * This page is a page object example.
 */
public class YouTubeSearchResultsPage {

    @FindBy(css = "div[class*='yt-lockup-tile yt-lockup-video']")
    private ElementsCollection videoElements;

    public boolean hasResults() {
        return !videoElements.isEmpty();
    }

}
