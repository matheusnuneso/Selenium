package modulos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutPage;
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
    }

    @Test
    @DisplayName("finish a buy")
    public void finishABuy(){
        new LoginPage(browser)
                .makeLogin(GlobalVariables.email, GlobalVariables.password)
                .clickInAFilter("Women")
                .addAProductInCart(0);

        browser.get(GlobalVariables.base_url + "?controller=order");

        String successMsg =
                new CheckoutPage(browser)
                .clickProceedCheckout()
                .clickProceedCheckout()
                .markAgreeToTerms()
                .clickProceedCheckout()
                .choosePaymentMethod()
                .clickProceedCheckout()
                .getSuccessMsg();

        Assertions.assertTrue(successMsg.contains("Your order on My Store is complete."));
    }

    @AfterEach
    public void afterEach(){
        browser.quit();
    }
}
