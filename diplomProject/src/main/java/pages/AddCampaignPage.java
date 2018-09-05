package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static libs.Utils.waitABit;

public class AddCampaignPage extends ParentPage {
    WebDriverWait webDriverWait10;
    @FindBy(id = "name")
    private WebElement campaignNameInput;
    @FindBy(id = "cuselFrame-campaignTypes")
    private WebElement campaignTypeDD;
    @FindBy(id = "category_sel_select")
    private WebElement campaignCategoryDD;
    @FindBy(id = "targeting_switch")
    private WebElement targetingSwitch;
    @FindBy(id = "tracking_switch")
    private WebElement trackingSwitch;
    @FindBy(id = "conversion_switch")
    private WebElement conversionSwitch;
    @FindBy(id = "valueUrl-buy")
    private WebElement conditionTypeInput;
    @FindBy(xpath = ".//a[@class = 'button confirm green']")
    private WebElement buttonApply;
    @FindBy(xpath = ".//a[@class = 'button save green']")
    private WebElement buttonSave;
    @FindBy(id = "confirm-ok")
    private WebElement buttonSaveAndContinue;
    @FindBy(id = "confirm-cancel")
    private WebElement buttonCancel;
    @FindBy(xpath = ".//a[@class = 'button green save']")
    private WebElement buttonGoOver;

    public AddCampaignPage(WebDriver webDriver) {
        super(webDriver, "/advertisers/add");
        webDriverWait10 = new WebDriverWait(webDriver, 10);
    }

    public void enterCampaignName(String campaignName) {
        actionsWithOurElements.enterTextToElement(campaignNameInput, campaignName);
    }

    public void selectCampaignType(String value) {
        actionsWithOurElements.clickOnElement(campaignTypeDD);
        actionsWithOurElements.clickOnElement(String.format(".//span[@val = '%s']", value));
    }

    public void selectCampaignCategory(String value) {
        actionsWithOurElements.clickOnElement(campaignCategoryDD);
        actionsWithOurElements.clickOnElement(String.format(".//div[@id = 'category_sel_dropdown']//p[text() = '%s']", value));
    }

    public void clickTargetingSwitch() {
        actionsWithOurElements.clickOnElement(targetingSwitch);
//        waitABit(1);
    }

    public void clickTrackingSwitch() {
        actionsWithOurElements.clickOnElement(trackingSwitch);
//        webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='tracking_switch']/div[@class = 'off']")));

//        waitABit(1);
    }

    public void clickConversionSwitch() {
//        waitABit(1);
//        webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='tracking_switch']/div[@class = 'off']")));
        actionsWithOurElements.clickOnElement((conversionSwitch));
    }

    public void clickButtonApply() {

        actionsWithOurElements.clickOnElement(buttonApply);
//        waitABit(1);
    }

    public void clickButtonSaveAndContinue() {
        actionsWithOurElements.clickOnElement(buttonSaveAndContinue);
//        waitABit(1);
    }

    public void clickButtonCancel() {
        actionsWithOurElements.clickOnElement(buttonCancel);
//        waitABit(1);
    }

    public void clickButtonSave() {
        webDriverWait10.until(ExpectedConditions.invisibilityOf(conditionTypeInput));
        actionsWithOurElements.clickOnElement(buttonSave);
//        waitABit(1);
    }

    public void clickButtonAddTeaser() {
        actionsWithOurElements.clickOnElement(buttonGoOver);
//        waitABit(1);
    }
}
