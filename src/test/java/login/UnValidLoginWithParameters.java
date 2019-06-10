package login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parenTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UnValidLoginWithParameters extends ParentTest {
    String login;
    String pass;

    public UnValidLoginWithParameters(String login, String pass) {   // Constructed
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student", "906090"},
                {"Login", "909090"},
                {"Login", "pass"},
                {"Student ","909090"},
                {"Student","90 9090"},
                {" ","909090"}
        });
    }

    @Test
    public void unValidLoginWithParameters() {
        loginPage.loginInToApp(login,pass);
        checkExpectedResult("Avatar should not be present", homePage.isAvatarDisplayed(), false);
    }
}
