package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ListProductsPage {

    private final WebDriver browser;

    private final String titleClass = "inventory_item_name";

    public ListProductsPage(WebDriver browser) {
        this.browser = browser;
    }

    public String existsHeader(){
        return browser.findElement(By.className("title")).getText();
    }

    public ListProductsPage selectProductSort(String filter){
        new Select(browser.findElement(By.className("product_sort_container"))).selectByValue(filter);
        return this;
    }

    public String getPriceElementByIndex(Integer index){
        String xpath = "(//div[@class='inventory_item_price'])["+ index +"]";
        return browser.findElement(By.xpath(xpath)).getText();
    }

    public ProductPage clickFirstProduct(){
        browser.findElement(By.className(titleClass)).click();
        return new ProductPage(browser);
    }

    public String getNameFirstProduct(){
        return browser.findElement(By.className(titleClass)).getText();
    }

    public ListProductsPage addRemoveProductInCart(Integer index){
        browser.findElements(By.className("btn_inventory")).get(index).click();
        return this;
    }

    public Integer getQuantityProductCart(){
       String quant = browser.findElement(By.className("shopping_cart_badge")).getText();
       return Integer.valueOf(quant);
    }

    public CartPage clickCartButton(){
        browser.findElement(By.className("shopping_cart_link")).click();
        return new CartPage(browser);
    }
}
