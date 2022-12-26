package modulos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Test junit")
public class Teste {

    @Test
    public void testTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver108\\chromedriver.exe");

        WebDriver navegador = new ChromeDriver();

        navegador.manage().window().maximize();

        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        navegador.get("http://automationpractice.pl/index.php");
    }


}
