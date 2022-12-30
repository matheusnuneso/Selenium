package modulos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

        productsPage.addProductInCart(1);
        Integer quant = productsPage.getQuantityProductCart();

        Assertions.assertEquals(1, quant);
    }

    @Test
    @DisplayName("Add two products in Cart")
    public void addTwoProductsInCart(){
        ListProductsPage productsPage = new ListProductsPage(browser);

        productsPage.addProductInCart(1);
        productsPage.addProductInCart(2);
        Integer quant = productsPage.getQuantityProductCart();

        Assertions.assertEquals(2, quant);
    }

    @AfterEach
    public void afterEach(){
        browser.quit();
    }

}
