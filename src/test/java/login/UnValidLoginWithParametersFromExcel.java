package login;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parenTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UnValidLoginWithParametersFromExcel extends ParentTest {
    String login;
    String pass;

    public UnValidLoginWithParametersFromExcel(String login, String pass) {   // Constructed
        this.login = login;
        this.pass = pass;
    }

//    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
//    public static Collection testData(){
//        return Arrays.asList(new Object[][]{
//                {"Student", "909090"},
//                {"Student", "906090"},
//                {"Login", "909090"}
//        });
//    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(configProperties.DATA_FILE_PATH() + "testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "invalidLogOn").getData();
    }

    @Test
    public void unValidLoginWithParametersFromExcel() {
        loginPage.loginInToApp(login, pass);
        checkExpectedResult("Avatar should not be present", homePage.isAvatarDisplayed(), false);
    }
}
