package modulos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.ProductPage;
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
    }

    @Test
    @DisplayName("cart start empty")
    public void cartStartEmpty(){
        String quantityCart = new CartPage(browser).getEmptyCart();

        Assertions.assertEquals("(empty)", quantityCart);
    }

    @Test
    @DisplayName("add a product in cart")
    public void addAProductInCart(){
        new ProductPage(browser)
                .clickInAFilter("Women")
                .addAProductInCart(0);

        String quantityCart = new CartPage(browser).getQuantityInCart();
        Assertions.assertEquals("1", quantityCart);
    }

    @Test
    @DisplayName("add two products in cart")
    public void addTwoProductsInCart(){
        new ProductPage(browser)
                .clickInAFilter("Women")
                .addAProductInCart(0)
                .addAProductInCart(1);

        String quantityCart = new CartPage(browser).getQuantityInCart();
        Assertions.assertEquals("2", quantityCart);
    }

    @AfterEach
    public void afterEach(){
        //browser.quit();
    }

}
