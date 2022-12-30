package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private WebDriver browser;

    public ProductPage(WebDriver browser) {
        this.browser = browser;
    }

    public String getNameProduct(){
        return browser.findElement(By.className("inventory_details_name")).getText();
    }

}
