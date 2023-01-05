package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private final WebDriver browser;

    public  ProductPage(WebDriver browser){
        this.browser = browser;
    }

    public ProductPage searchAProduct(String nameProduct){
        browser.findElement(By.id("search_query_top")).sendKeys(nameProduct);
        browser.findElement(By.className("button-search")).click();
        return this;
    }

    public String getSearchWord(){
        return browser.findElement(By.className("lighter")).getText();
    }

    public ProductPage clickInAFilter(String filter){
        String xpath = "//a[@title='" + filter + "']";
        browser.findElement(By.xpath(xpath)).click();
        return this;
    }

    public String getNameOfTheCategory(){
        return browser.findElement(By.className("category-name")).getText();
    }

    public ProductPage clickInAProduct(int index){
        browser.findElements(By.cssSelector(".product-container .product-name")).get(index).click();
        return this;
    }

    public WebElement getElementToAddCart(){
        return browser.findElement(By.id("buy_block"));
    }

    public String getErrorMsg(){
        return browser.findElement(By.className("alert-warning")).getText();
    }

    public ProductPage addAProductInCart(int index){
        this.clickInAProduct(index);
        browser.findElement(By.name("Submit")).click();
        browser.findElement(By.className("continue")).click();
        browser.findElement(By.xpath("//span[@class='navigation_page']//a")).click();
        return this;
    }
}
