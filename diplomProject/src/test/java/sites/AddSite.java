package sites;

import org.junit.Test;
import parentTest.ParentTest;

import static libs.Utils.getDateAndTimeFormated;

public class AddSite extends ParentTest {
    String currentTime = getDateAndTimeFormated();
    String siteDomain = String.format("test_site_%s.com", currentTime);

    @Test
    public void addNewSite() {
        signinPage.userSignIn("equimosis@bigmir.net", "QalightG35");
        advertisersPage.clickOnSitesButton();
        publisherPage.clickOnAddSiteButton();
        addSitePage.enterSiteDomain(siteDomain);
        addSitePage.selectSiteCategory("Авто-вело-мото");
        addSitePage.selectStatisticsService("liveinternet");
        addSitePage.enterStatisticsUrl("http://li.ru");
        addSitePage.clickButtonSave();
        publisherPage.isPopUpDisplayed();
        publisherPage.closePopUp();

        checkAcceptanceCriteria("Site wasn't added.",
                publisherPage.isNewSiteAdded(siteDomain),
                true);

    }
}
