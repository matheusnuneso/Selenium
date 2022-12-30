package modulos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.ListProductsPage;
import pages.LoginPage;
import utility.GlobalVariables;

import java.time.Duration;

public class CartTest {

    WebDriver browser = new ChromeDriver();

    @BeforeEach
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver", GlobalVariables.path_chrome_driver);

        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.get(GlobalVariables.base_url);

        new LoginPage(browser)
                .submitLoginSuccess(GlobalVariables.standard_user, GlobalVariables.password);
    }

    @Test
    @DisplayName("Add a product in Cart")
    public void addAProductInCart(){
        ListProductsPage productsPage = new ListProductsPage(browser);

        productsPage.addRemoveProductInCart(1);
        Integer quant = productsPage.getQuantityProductCart();

        Assertions.assertEquals(1, quant);
    }

    @Test
    @DisplayName("Add two products in Cart")
    public void addTwoProductsInCart(){
        ListProductsPage productsPage = new ListProductsPage(browser);

        productsPage.addRemoveProductInCart(1);
        productsPage.addRemoveProductInCart(2);
        Integer quant = productsPage.getQuantityProductCart();

        Assertions.assertEquals(2, quant);
    }

    @Test
    @DisplayName("Remove a product of cart in list product page")
    public void removeProductOfCart(){
        ListProductsPage productsPage = new ListProductsPage(browser);

        productsPage.addRemoveProductInCart(1);
        productsPage.addRemoveProductInCart(2);

        Integer quantBeforeRemove = productsPage.getQuantityProductCart();
        productsPage.addRemoveProductInCart(1);
        Integer quantAfterRemove = productsPage.getQuantityProductCart();

        Assertions.assertTrue(quantAfterRemove < quantBeforeRemove);
    }

    @Test
    @DisplayName("Remove a product of cart in cart page")
    public void removeProductOfCart2(){
        ListProductsPage productsPage = new ListProductsPage(browser);

        productsPage.addRemoveProductInCart(1);
        productsPage.addRemoveProductInCart(2);

        Integer quantBeforeRemove = productsPage.getQuantityProductCart();
        productsPage.clickCartButton().removeProduct(1);
        Integer quantAfterRemove = productsPage.getQuantityProductCart();

        Assertions.assertTrue(quantAfterRemove < quantBeforeRemove);
    }

    @AfterEach
    public void afterEach(){
        browser.quit();
    }

}
