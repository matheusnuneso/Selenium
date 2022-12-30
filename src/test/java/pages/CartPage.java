package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver browser;

    public CartPage(WebDriver browser) {
        this.browser = browser;
    }

    public void removeProduct(Integer index){
        browser.findElements(By.className("cart_button")).get(index).click();
    }

    public void clickCheckoutButton(){
        browser.findElement(By.className("checkout_button")).click();
    }
}
