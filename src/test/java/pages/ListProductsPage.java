package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ListProductsPage {

    private WebDriver browser;

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
}
