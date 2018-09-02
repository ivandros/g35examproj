package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddSitePage extends ParentPage {

    @FindBy (name = "url")
    private  WebElement siteDomainInput;
    @FindBy (id = "category_select_selector-button")
    private WebElement siteCategorySelect;
    @FindBy (className = "cuselText")
    private WebElement statisticsSelect;
    @FindBy (id =  "statLink")
    private WebElement statisticsUrlInput;
    @FindBy (xpath = ".//a[@class = 'button green save']")
    private WebElement buttonSave;

    public AddSitePage(WebDriver webDriver) {
        super(webDriver, "/publisher/add-site");
    }

    public void enterSiteDomain(String siteDomain) {
        actionsWithOurElements.enterTextToElement(siteDomainInput, siteDomain);
    }

    public void selectSiteCategory(String value) {
        actionsWithOurElements.clickOnElement(siteCategorySelect);
        actionsWithOurElements.clickOnElement(String.format(".//p[text() = '%s']", value));
    }

    public void selectStatisticsService(String value) {
        actionsWithOurElements.clickOnElement(statisticsSelect);
        actionsWithOurElements.clickOnElement(String.format(".//span[@val = '%s']", value));
    }

    public void clickButtonSave() {
        actionsWithOurElements.clickOnElement(buttonSave);
    }

    public void enterStatisticsUrl(String statisticsUrl) {
        actionsWithOurElements.enterTextToElement(statisticsUrlInput, statisticsUrl);
    }
}
