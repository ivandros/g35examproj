package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPage extends ParentPage {

    AdvertisersPage advertisersPage;

    @FindBy(id = "login")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "signin")
    private WebElement submitButton;
    @FindBy(xpath = ".//div[contains(text(), 'Обязательное поле не должно быть пустым')]")
    private WebElement validationMessage;

    public SigninPage(WebDriver webDriver) {
        super(webDriver, "/user/signin");
        advertisersPage = new AdvertisersPage(webDriver);
    }


    public void openPage() {
        try {
            webDriver.get(baseUrl);
            checkCurrentUrl();
            logger.info("Signin page was opened.");
        } catch (Exception e) {
            logger.error("Can't open signinPage.");
            Assert.fail("Can't open signinPage.");
        }
    }

    public void enterEmail(String email) {
        actionsWithOurElements.enterTextToElement(emailInput, email);
    }

    public void enterPassword(String password) {
        actionsWithOurElements.enterTextToElement(passwordInput, password);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    /**
     * Method valid login
     * @param email (Only valid e-mail)
     * @param password (Only valid password)
     */
    public void userSignIn(String email, String password) {
        openPage();
        enterEmail(email);
        enterPassword(password);
        clickOnSubmitButton();
        advertisersPage.checkCurrentUrl();
//        advertisersPage.isExitPresent();
//        advertisersPage.isAdvertisersPresent();

    }

    public boolean isValidationPresent() {
        return actionsWithOurElements.isElementDisplay(validationMessage);
    }
}
