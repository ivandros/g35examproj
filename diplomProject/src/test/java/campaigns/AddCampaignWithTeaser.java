package campaigns;

import org.junit.Test;
import parentTest.ParentTest;

import static libs.Utils.getDateAndTimeFormated;
import static libs.Utils.waitABit;

public class AddCampaignWithTeaser extends ParentTest {
    String currentDate = getDateAndTimeFormated();
    String campaignName = "Auto added campaign " + currentDate;
    String teaserLink = "google.com";
    String teaserTitle = "Заголовок тизера";
    String teaserText = "Текст тизера";
    String pictureLink = "http://carakoom.com/data/blogs/787/17402/image/1.jpg";
    String teaserBid = "3";

    @Test
    public void addNewCampaignWithTeaser() throws InterruptedException {
        signinPage.userSignIn("test_sok_2018_09_05@mailinator.com", "12345678");
        advertisersPage.clickOnAddCampaignButton();
        addCampaignPage.checkCurrentUrl();
        addCampaignPage.enterCampaignName(campaignName);
        addCampaignPage.selectCampaignType("product");
        addCampaignPage.selectCampaignCategory("Авто");
        addCampaignPage.clickTargetingSwitch();
        addCampaignPage.clickButtonApply();
        addCampaignPage.clickConversionSwitch();
        addCampaignPage.clickTrackingSwitch();
        addCampaignPage.clickButtonSave();
        addCampaignPage.clickButtonSaveAndContinue();
        addCampaignPage.clickButtonAddTeaser();
        addTeaserPage.checkCurrentUrl();
        addTeaserPage.enterTeaserLink(teaserLink);
        addTeaserPage.enterTeaserTitle(teaserTitle);
        addTeaserPage.enterTeaserText(teaserText);
        addTeaserPage.enterTeaserPictureLink(pictureLink);
        addTeaserPage.enterTeaserBid(teaserBid);
        addTeaserPage.clickButtonSaveAndGoToList();
        teasersCampaignPage.checkCurrentUrl();
        teasersCampaignPage.isPopupPresent();
        teasersCampaignPage.clickButtonLater();

        checkAcceptanceCriteria("Teaser wasn't added",
                teasersCampaignPage.isNewTeaserAdded(teaserTitle),
                true);
    }
}
