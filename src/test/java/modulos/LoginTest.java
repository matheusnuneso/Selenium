package modulos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utility.GlobalVariables;

import java.time.Duration;

public class LoginTest {

    WebDriver browser = new ChromeDriver();

    @BeforeEach
    public void testTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver108\\chromedriver.exe");

        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.get("https://www.saucedemo.com/");
    }

    @Test
    @DisplayName("login successfully")
    public void loginSuccess(){
        String title =
                new LoginPage(browser)
                .submitLoginSuccess(GlobalVariables.standard_user, GlobalVariables.secret_sauce)
                .existsHeader();

        Assertions.assertEquals("PRODUCTS", title);
    }

    @AfterEach
    public void afterEach(){
        browser.quit();
    }

}
