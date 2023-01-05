package modulos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ProductPage;
import utility.GlobalVariables;

import java.time.Duration;

public class ProductTest {

    WebDriver browser = new ChromeDriver();

    @BeforeEach
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver", GlobalVariables.path_chrome_driver);

        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.get(GlobalVariables.base_url);
    }

    @Test
    @DisplayName("search a product")
    public void searchProduct(){
        String wordSearched =
                new ProductPage(browser)
                .searchAProduct("dress")
                .getSearchWord()
                .toLowerCase();

        Assertions.assertTrue(wordSearched.contains("dress"));
    }

    @Test
    @DisplayName("search a product that does not exist")
    public void searchProductNotExist(){
        String expectedError = "No results were found for your search";
        String errorMsg =
                new ProductPage(browser)
                .searchAProduct("pineapple")
                .getErrorMsg();

        Assertions.assertTrue(errorMsg.contains(expectedError));
    }

    @Test
    @DisplayName("filter a product")
    public void filterAProduct(){
        String categorySelected =
                new ProductPage(browser)
                .clickInAFilter("Women")
                .getNameOfTheCategory()
                .toLowerCase();

        Assertions.assertTrue(categorySelected.contains("women"));
    }

    @Test
    @DisplayName("click in a product")
    public void clickInAProduct(){
        WebElement webElement =
                new ProductPage(browser)
                .clickInAFilter("Women")
                .clickInAProduct(0)
                .getElementToAddCart();

        Assertions.assertTrue(webElement.isDisplayed());
    }

    @AfterEach
    public void afterEach(){
        browser.quit();
    }

}
