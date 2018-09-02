package parentTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected SigninPage signinPage;
    protected AdvertisersPage advertisersPage;
    protected AddCampaignPage addCampaignPage;
    protected AddTeaserPage addTeaserPage;
    protected TeasersCampaignPage teasersCampaignPage;
    protected PublisherPage publisherPage;
    protected AddSitePage addSitePage;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        signinPage = new SigninPage(webDriver);
        advertisersPage = new AdvertisersPage(webDriver);
        addCampaignPage = new AddCampaignPage(webDriver);
        addTeaserPage = new AddTeaserPage(webDriver);
        teasersCampaignPage = new TeasersCampaignPage(webDriver);
        publisherPage = new PublisherPage(webDriver);
        addSitePage = new AddSitePage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    protected void checkAcceptanceCriteria(String message, boolean actual, boolean expected) {
        if(actual != expected){
            logger.error("Acceptance Criteria failed: " + message);
        }
        Assert.assertEquals(message, expected, actual);
    }
}
