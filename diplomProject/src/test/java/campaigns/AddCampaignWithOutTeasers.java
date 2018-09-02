package campaigns;

import org.junit.Test;
import pages.SigninPage;
import parentTest.ParentTest;

import static libs.Utils.getDateAndTimeFormated;

public class AddCampaignWithOutTeasers extends ParentTest {
    String currentDate = getDateAndTimeFormated();
    String campaignName = "Auto added campaign " + currentDate;

    @Test
    public void addNewCampaignWithOutTeasers() throws InterruptedException {
        signinPage.userSignIn("equimosis@bigmir.net", "QalightG35");
        advertisersPage.clickOnAddCampaignButton();
        addCampaignPage.checkCurrentUrl();
        addCampaignPage.enterCampaignName(campaignName);
        addCampaignPage.selectCampaignType("product");
        addCampaignPage.selectCampaignCategory("Авто");
        addCampaignPage.clickTargetingSwitch();
        addCampaignPage.clickButtonApply();
        addCampaignPage.clickTrackingSwitch();
        addCampaignPage.clickConversionSwitch();
        addCampaignPage.clickButtonSave();
        addCampaignPage.clickButtonSaveAndContinue();
        addCampaignPage.clickButtonCancel();

        checkAcceptanceCriteria("New campaign wasn't added",
                advertisersPage.isNewCampaignAdded(campaignName),
                true);
    }
}
