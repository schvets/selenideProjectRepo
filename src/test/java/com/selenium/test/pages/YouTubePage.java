package com.selenium.test.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

/**
 * This page is a page object example.
 */
public class YouTubePage {

    @FindBy(css = "#masthead-search button")
    private SelenideElement searchButtonElement;

    @FindBy(css = "#masthead-search-term")
    private SelenideElement searchStringElement;

    /**
     * inserts search text in search string
     *
     * @param text text for input
     */
    public void insertSearchString(String text) {
        searchStringElement.sendKeys(text);
    }

    /**
     * perform search
     *
     * @return results page instance
     */
    public YouTubeSearchResultsPage doSearch() {
        searchButtonElement.click();
        return page(YouTubeSearchResultsPage.class);
    }

    /**
     * clears search string
     */
    private void clearSearchString() {
        searchStringElement.clear();
    }

    /**
     * getting search string text
     *
     * @return text from search string
     */
    public String getSearchStringText() {
        return searchStringElement.val();
    }

}
