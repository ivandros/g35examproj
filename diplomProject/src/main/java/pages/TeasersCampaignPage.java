package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeasersCampaignPage extends ParentPage {
    @FindBy(className = "popup")
    WebElement popUp;

    //    @FindBy(xpath = ".//a[@class = 'button grey save']")
    @FindBy(id = "confirm-cancel")
    WebElement buttonLater;



    public TeasersCampaignPage(WebDriver webDriver) {
        super(webDriver, "/advertisers/teasers-goods/campaign_id/\\d+");
    }

    public boolean isNewTeaserAdded(String teaserTitle) {
        return actionsWithOurElements.isOneElementInList(String.format(".//div[@class = 'tit' and text() = '%s']", teaserTitle));
    }

    public boolean isPopupPresent() {
        return actionsWithOurElements.isElementDisplay(popUp);
    }

    public void clickButtonLater() {
        actionsWithOurElements.clickOnElement(buttonLater);
    }
}
