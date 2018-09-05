package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static libs.Utils.waitABit;

public class AddTeaserPage extends ParentPage {
    WebDriverWait webDriverWait10;
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
    @FindBy(xpath = ".//a[@class = 'button save green' and @data-next = 'list']")
    private WebElement buttonSaveAndGoToList;
    @FindBy(id = "uploadProgress")
    private WebElement uploadProgressLogo;

    public AddTeaserPage(WebDriver webDriver) {
        super(webDriver, "/advertisers/add-teaser-goods/campaign_id/\\d+");
        webDriverWait10 = new WebDriverWait(webDriver, 10);
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
        waitABit(1);
    }

    public void clickButtonSaveAndGoToList() {
        actionsWithOurElements.clickOnElement(buttonSaveAndGoToList);
//        waitABit(1);
    }
}
