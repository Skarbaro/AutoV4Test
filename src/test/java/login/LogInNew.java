package login;

import org.junit.Assert;
import org.junit.Test;
import parenTest.ParenTest;

public class LogInNew extends ParenTest {
    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassWord("909090");
        loginPage.clickButtonVhod();

        Assert.assertTrue("Avatar is not present", homePage.isAvatarDisplayed());  // valid
    }

    @Test
    public void noValidLogin(){
        loginPage.openLoginPage();
        loginPage.enterLogin("Students");
        loginPage.enterPassWord("9090090");
        loginPage.clickButtonVhod();

        Assert.assertTrue("Button is not present", loginPage.isButtonVhodDisplayed());
//        Assert.assertFalse("Avatar is not present", homePage.isAvatarDisplayed()); // not valid
    }

    @Test
    public void validLogin2(){
        loginPage.validLoginInToApp();
        Assert.assertTrue("Avatar is not present", homePage.isAvatarDisplayed());  // valid
    }

}
