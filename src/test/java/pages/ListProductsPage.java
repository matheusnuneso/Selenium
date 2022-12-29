package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListProductsPage {

    private WebDriver browser;

    public ListProductsPage(WebDriver browser) {
        this.browser = browser;
    }

    public String existsHeader(){
        return browser.findElement(By.className("title")).getText();
    }

}
