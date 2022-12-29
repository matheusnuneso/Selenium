package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver browser;

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public ListProductsPage submitLoginSuccess(String userName, String password){
        insertUserName(userName);
        insertPassword(password);
        clickOnLoginButton();

        return new ListProductsPage(browser);
    }

    public LoginPage submitLoginFailure(String userName, String password){
        insertUserName(userName);
        insertPassword(password);
        clickOnLoginButton();

        return this;
    }

    public void insertUserName(String userName){
        browser.findElement(By.id("user-name")).sendKeys(userName);
    }

    public void insertPassword(String password){
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public void clickOnLoginButton(){
        browser.findElement(By.id("login-button")).click();
    }
}
