package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private final WebDriver browser;

    public CheckoutPage(WebDriver browser) {
        this.browser = browser;
    }

    public CheckoutPage insertFirstName(String firstName){
        browser.findElement(By.id("first-name")).sendKeys(firstName);
        return this;
    }

    public CheckoutPage insertLastName(String lastName){
        browser.findElement(By.id("last-name")).sendKeys(lastName);
        return this;
    }

    public CheckoutPage insertPostalCode(String postalCode){
        browser.findElement(By.id("postal-code")).sendKeys(postalCode);
        return this;
    }

    public CheckoutPage clickContinue(){
        browser.findElement(By.id("continue")).click();
        return this;
    }

    public CheckoutPage clickFinish(){
        browser.findElement(By.id("finish")).click();
        return this;
    }

    public String getTextSuccess(){
        return browser.findElement(By.className("complete-header")).getText();
    }

    public String getErrorMsg(){
        return browser.findElement(By.className("error-message-container")).getText();
    }
}
