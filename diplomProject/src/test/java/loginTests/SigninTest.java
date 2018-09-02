package loginTests;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class SigninTest extends ParentTest {

    @Test
    public void validLogin(){
        signinPage.openPage();
        signinPage.enterEmail("equimosis@bigmir.net");
        signinPage.enterPassword("QalightG35");
        signinPage.clickOnSubmitButton();

        checkAcceptanceCriteria("Logo isn't present.", advertisersPage.isLogoPresent(), true);
        checkAcceptanceCriteria("Exit isn't present.", advertisersPage.isExitPresent(), true);
        checkAcceptanceCriteria("Validation message is present.", signinPage.isValidationPresent(), true);
    }
}
