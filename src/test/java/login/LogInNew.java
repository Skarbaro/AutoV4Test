package login;

import org.junit.Assert;
import org.junit.Test;
import parenTest.ParenTest;

public class LogInNew extends ParenTest {
    @Test
    public void validLogin(){
        loginPage.OpenLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassWord("909090");
        loginPage.clickButtonVhod();

        Assert.assertTrue("Avatar is not present", homePage.isAvatarPresent());
    }
}
