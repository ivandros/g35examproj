package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublisherPage extends ParentPage {
    @FindBy (xpath = ".//a[@class = 'big_button green add-site']")
    private WebElement addSiteButton;
    @FindBy(className = "popup")
    private WebElement popUp;
    @FindBy (className = "popup_close")
    private WebElement closePopUpButton;

    public PublisherPage(WebDriver webDriver) {
        super(webDriver, "/publisher");
    }


    public void clickOnAddSiteButton() {
        actionsWithOurElements.clickOnElement(addSiteButton);
    }

    public boolean isPopUpDisplayed(){
        return actionsWithOurElements.isElementDisplay(popUp);
    }

    public void closePopUp() {
        actionsWithOurElements.clickOnElement(closePopUpButton);
    }

    public boolean isNewSiteAdded(String siteName){
        return actionsWithOurElements.isOneElementInList(String.format(".//td[contains(text(), '%s')]", siteName));
    }
}
