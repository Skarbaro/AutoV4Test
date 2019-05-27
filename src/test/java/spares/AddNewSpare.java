package spares;

import org.junit.Test;
import parenTest.ParenTest;

public class AddNewSpare extends ParenTest {
    String spareName = "RomaniukSpare";

    @Test
    public void addNewSpare(){
        loginPage.validLoginInToApp();
        homePage.checkUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkUrl();
        sparePage.checkAndDeleteSpare(spareName);
    }

}