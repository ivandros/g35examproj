package loginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class UnValidLogin extends ParentTest {
    @Test
    public void unValidLogin(){
        signinPage.openPage();
        signinPage.enterEmail("");
        signinPage.enterPassword("");
        signinPage.clickOnSubmitButton();

        checkAcceptanceCriteria("Exit is present.", advertisersPage.isExitPresent(), false);
        checkAcceptanceCriteria("Validation message isn't present.", signinPage.isValidationPresent(), true);
    }
}
