package modulos;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

}
