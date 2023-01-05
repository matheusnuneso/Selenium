package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver browser;

    public  CartPage(WebDriver browser){
        this.browser = browser;
    }

    public String getEmptyCart(){
        return browser.findElement(By.cssSelector(".shopping_cart .ajax_cart_no_product")).getText();
    }

    public String getQuantityInCart(){
        return browser.findElement(By.cssSelector(".shopping_cart .ajax_cart_quantity")).getText();
    }

    public CartPage deleteProduct() {
        browser.findElement(By.className("cart_quantity_delete")).click();
        return this;
    }

    public String getEmptyCartMsg(){
        return browser.findElement(By.className("alert-warning")).getText();
    }

}
