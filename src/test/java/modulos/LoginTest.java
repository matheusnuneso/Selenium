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
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver", GlobalVariables.path_chrome_driver);

        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.get(GlobalVariables.base_url);
    }

    @Test
    @DisplayName("login successfully")
    public void loginSuccess(){
        String title =
                new LoginPage(browser)
                .submitLoginSuccess(GlobalVariables.standard_user, GlobalVariables.password)
                .existsHeader();

        Assertions.assertEquals("PRODUCTS", title);
    }

    @Test
    @DisplayName("Login with locked out user")
    public void loginLockedOutUser(){
        String msgError =
                new LoginPage(browser)
                .submitLoginFailure(GlobalVariables.locked_out_user, GlobalVariables.password)
                .getErrorMsg();

        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", msgError);
    }

    @Test
    @DisplayName("Login no insert username")
    public void loginNoUsername(){
        String msgError =
                new LoginPage(browser)
                .submitLoginFailure("", "123456")
                .getErrorMsg();

        Assertions.assertEquals("Epic sadface: Username is required", msgError);
    }

    @Test
    @DisplayName("Login no insert password")
    public void loginNoPassword(){
        String msgError =
                new LoginPage(browser)
                .submitLoginFailure(GlobalVariables.standard_user, "")
                .getErrorMsg();

        Assertions.assertEquals("Epic sadface: Password is required", msgError);
    }

    @Test
    @DisplayName("Login with incorrect data")
    public void loginWithIncorrectData(){
        String msgError =
                new LoginPage(browser)
                .submitLoginFailure("Incorrect-User", "Incorrect-Password")
                .getErrorMsg();

        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", msgError);
    }

    @AfterEach
    public void afterEach(){
        browser.quit();
    }

}
