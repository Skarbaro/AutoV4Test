package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassWord;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;

    public HomePage homePage = new HomePage(webDriver);

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    public void openLoginPage(){
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Login page was opened");
            Assert.fail("Can not open Login Page");
        }
    }

    public void enterLogin(String login) {
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
//        try {
//            inputPassWord.clear();
//            inputPassWord.sendKeys(passWord);
//            logger.info(passWord + " was inputted into Input");
//        } catch (Exception e) {
//            logger.error("Cannot work with element.");
//            Assert.fail("Cannot work with element.");
//        }
    }

    public void enterPassWord(String passWord) {
        actionsWithOurElements.enterTextInToElement(inputPassWord, passWord);
    }

    public void clickButtonVhod() {
        actionsWithOurElements.clickOnElement(buttonVhod);
//        try {
//            buttonVhod.click();
//            logger.info("Click Button.");
//        } catch (Exception e) {
//            logger.error("Cannot work with element.");
//            Assert.fail("Cannot work with element.");
//        }
    }

    public boolean isButtonVhodDisplayed(){
        return actionsWithOurElements.isElementDisplayed(buttonVhod);
    }

    public void loginInToApp(String login, String passWord){
        openLoginPage();
        enterLogin(login);
        enterPassWord(passWord);
        clickButtonVhod();
    }

    public void validLoginInToApp(){
        loginInToApp("Student", "909090");
        homePage.isAvatarDisplayed();
    }

}
