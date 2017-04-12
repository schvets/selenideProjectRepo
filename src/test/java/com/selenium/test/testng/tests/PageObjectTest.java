package com.selenium.test.testng.tests;

import com.selenium.test.pages.YouTubePage;
import com.selenium.test.pages.YouTubeSearchResultsPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Sidelnikov Mikhail on 30.07.15.
 * Uses TestNG test framework
 * Test demonstrates work with Selenide and Page Object Pattern(https://code.google.com/p/selenium/wiki/PageObjects)
 * For more information about Selenide visit <a href="http://selenide.org">Selenide</a>
 */
public class PageObjectTest {

    @Test
    public void testSearch() {
        YouTubePage youTubePage = open("http://youtube.com", YouTubePage.class);
        youTubePage.insertSearchString("Selenium");
        YouTubeSearchResultsPage resultsPage = youTubePage.doSearch();
        assertTrue("No results were found on results page", resultsPage.hasResults());
    }
}
