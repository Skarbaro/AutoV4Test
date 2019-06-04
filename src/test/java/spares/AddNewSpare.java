package spares;

import org.junit.After;
import org.junit.Assert;
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
//        sparePage.checkAndDeleteSpare(spareName);
        sparePage.deletingSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика");
        editSparePage.clickButtonCreate();

        checkExpectedResult("Spare was not added", sparePage.isSpareInList(spareName));
    }

    @After
    public void spareDeleting(){
        sparePage.deletingSpareUntilPresent(spareName);
    }

}