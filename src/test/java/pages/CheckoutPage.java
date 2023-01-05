package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private final WebDriver browser;
    public  CheckoutPage(WebDriver browser){
        this.browser = browser;
    }

    public CheckoutPage clickProceedCheckout(){
        browser.findElement(By.cssSelector(".cart_navigation > .button > span")).click();
        return new CheckoutPage(browser);
    }

    public CheckoutPage markAgreeToTerms(){
        browser.findElement(By.id("cgv")).click();
        return this;
    }

    public CheckoutPage choosePaymentMethod(){
        browser.findElement(By.className("cheque")).click();
        return this;
    }

    public String getSuccessMsg(){
        return browser.findElement(By.className("alert")).getText();
    }
}
