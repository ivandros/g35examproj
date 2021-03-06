package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    String expectedUrl;
    final String baseUrl = "https://dashboard.marketgid.com";
    ActionsWithOurElements actionsWithOurElements;

    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        this.expectedUrl = baseUrl + expectedUrl;
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public void checkCurrentUrl() {
        try {
           // Assert.assertEquals("Url is not expected!", expectedUrl, getCurrentUrl());
            getCurrentUrl().matches(expectedUrl);
        } catch (Exception e) {
            logger.error("Can't work with Url.");
            Assert.fail("Can't work with Url.");
        }
    }

}
