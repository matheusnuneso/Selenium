package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver browser;

    public  LoginPage(WebDriver browser){
        this.browser = browser;
    }

    public ProductPage makeLogin(String email, String password){

        browser.findElement(By.className("login")).click();
        browser.findElement(By.id("email")).sendKeys(email);
        browser.findElement(By.id("passwd")).sendKeys(password);
        browser.findElement(By.id("SubmitLogin")).click();

        return new ProductPage(browser);
    }
}
