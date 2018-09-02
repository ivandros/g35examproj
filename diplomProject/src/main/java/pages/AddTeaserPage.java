package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.Utils.waitABit;

public class AddTeaserPage extends ParentPage {
    @FindBy(id = "url")
    private WebElement inputTeaserURL;
    @FindBy(id = "title")
    private WebElement inputTeaserTitle;
    @FindBy(id = "advert_text")
    private WebElement inputTeaserText;
    @FindBy(id = "image_link")
    private WebElement inputPictureUrl;
    @FindBy(id = "price_of_click-visible")
    private WebElement inputTeaserBid;
    @FindBy(xpath = ".//a[@data-next = 'list']")
    private WebElement buttonSaveAndGoToList;

    public AddTeaserPage(WebDriver webDriver) {
        super(webDriver, "/advertisers/add-teaser-goods/campaign_id/\\d+");
    }

    ;

    public void enterTeaserLink(String teaserLink) {
        actionsWithOurElements.enterTextToElement(inputTeaserURL, teaserLink);
    }

    public void enterTeaserTitle(String teaserTitle) {
        actionsWithOurElements.enterTextToElement(inputTeaserTitle, teaserTitle);
    }

    public void enterTeaserText(String teaserText) {
        actionsWithOurElements.enterTextToElement(inputTeaserText, teaserText);
    }

    public void enterTeaserPictureLink(String pictureLink) {
        actionsWithOurElements.enterTextToElement(inputPictureUrl, pictureLink);
    }

    public void enterTeaserBid(String teaserBid) {
        actionsWithOurElements.enterTextToElement(inputTeaserBid, teaserBid);
    }

    public void clickButtonSaveAndGoToList() {
        actionsWithOurElements.clickOnElement(buttonSaveAndGoToList);
        waitABit(1);
    }
}
