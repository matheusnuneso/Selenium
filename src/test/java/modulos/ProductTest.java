package modulos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ListProductsPage;
import pages.LoginPage;
import utility.GlobalVariables;

import java.time.Duration;

public class ProductTest {

    WebDriver browser = new ChromeDriver();

    @BeforeEach
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver108\\chromedriver.exe");

        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.get("https://www.saucedemo.com/");

        new LoginPage(browser)
        .submitLoginSuccess(GlobalVariables.standard_user, GlobalVariables.password);
    }

    @Test
    @DisplayName("Order by high price")
    public void orderByHighPrice() {
        ListProductsPage productsPage = new ListProductsPage(browser).selectProductSort("hilo");

        Double highPrice = Double.parseDouble(
                productsPage.getPriceElementByIndex(1).replaceAll("\\$\\d{0}", ""));

        Double lowPrice = Double.parseDouble(
                productsPage.getPriceElementByIndex(2).replaceAll("\\$\\d{0}", ""));

        Assertions.assertTrue(highPrice > lowPrice);
    }

    @Test
    @DisplayName("Order by low price")
    public void orderByLowPrice() {
        ListProductsPage productsPage = new ListProductsPage(browser).selectProductSort("lohi");

        Double lowPrice = Double.parseDouble(
                productsPage.getPriceElementByIndex(1).replaceAll("\\$\\d{0}", ""));

        Double highPrice = Double.parseDouble(
                productsPage.getPriceElementByIndex(2).replaceAll("\\$\\d{0}", ""));

        Assertions.assertTrue(lowPrice < highPrice);
    }

    @AfterEach
    public void afterEach(){ browser.quit(); }

}
