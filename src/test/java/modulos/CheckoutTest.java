package modulos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutPage;
import pages.ListProductsPage;
import pages.LoginPage;
import utility.GlobalVariables;

import java.time.Duration;

public class CheckoutTest {

    WebDriver browser = new ChromeDriver();

    @BeforeEach
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver", GlobalVariables.path_chrome_driver);

        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.get(GlobalVariables.base_url);

        new LoginPage(browser)
                .submitLoginSuccess(GlobalVariables.standard_user, GlobalVariables.password);

        new ListProductsPage(browser)
                .addRemoveProductInCart(1)
                .clickCartButton()
                .clickCheckoutButton();
    }

    @Test
    @DisplayName("Finish checkout with success")
    public void checkoutNoInsertFirstName(){
        String textSuccess = new CheckoutPage(browser)
                .insertFirstName("Matheus")
                .insertLastName("Nunes")
                .insertPostalCode("36400")
                .clickContinue()
                .clickFinish()
                .getTextSuccess();

        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", textSuccess);
    }

    @Test
    @DisplayName("Go to checkout without insert first-name")
    public void checkoutWithoutFirstName(){
        String errorMsg = new CheckoutPage(browser)
                .clickContinue()
                .getErrorMsg();

        Assertions.assertEquals("Error: First Name is required", errorMsg);
    }

    @Test
    @DisplayName("Go to checkout without insert last-name")
    public void checkoutWithoutLastName(){
        String errorMsg = new CheckoutPage(browser)
                .insertFirstName("Matheus")
                .clickContinue()
                .getErrorMsg();

        Assertions.assertEquals("Error: Last Name is required", errorMsg);
    }

    @Test
    @DisplayName("Go to checkout without insert postal-code")
    public void checkoutWithoutPostalCode(){
        String errorMsg = new CheckoutPage(browser)
                .insertFirstName("Matheus")
                .insertLastName("Nunes")
                .clickContinue()
                .getErrorMsg();

        Assertions.assertEquals("Error: Postal Code is required", errorMsg);

    }

    @AfterEach
    public void afterEach(){ browser.quit(); }

}
