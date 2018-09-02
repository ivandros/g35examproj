package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdvertisersPage extends ParentPage {
    @FindBy(xpath = ".//a[@class='logo']")
    private WebElement logo;
    @FindBy(xpath = ".//a[@class='out']")
//    @FindBy(linkText = "Выход")
    private WebElement exit;
//    @FindBy(xpath = ".//a[@href = '/advertisers']")
    @FindBy(linkText = "Рекламодателям")
    private WebElement advertisers;

    @FindBy(xpath = ".//a[@href = '/advertisers/add']")
    private WebElement addCampaignButton;
    @FindBy(xpath = ".//a[@href = '/publisher']")
    private WebElement sitesButton;

    public AdvertisersPage(WebDriver webDriver) {
        super(webDriver, "/advertisers");
    }

    public boolean isLogoPresent() {
        return actionsWithOurElements.isElementDisplay(logo);
    }

    public boolean isExitPresent() {
        try {
            return exit.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAdvertisersPresent() {
        try {
            return advertisers.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnAddCampaignButton() {
        actionsWithOurElements.clickOnElement(addCampaignButton);
    }

    public boolean isNewCampaignAdded(String campaignName) {
        return actionsWithOurElements.isOneElementInList(String.format(".//span[@title='%s']", campaignName));
    }

    public void clickOnSitesButton() {
        actionsWithOurElements.clickOnElement(sitesButton);
    }
}