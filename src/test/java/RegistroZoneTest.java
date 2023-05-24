import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class RegistroZoneTest {
    private WebDriver driver;

    @BeforeTest
    public void setDriver() throws  Exception {
        String path = "E:\\Phoenix Docs\\Universidad Catolica Boliviana\\8vo Semestre\\SIS 312 - Gestion de Calidad de Sistemas";
        System.setProperty("webdriver.chrome.driver", path);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void verificarMensajeErrorAlRegistrar() {
        // 1. Preparacion de la prueba
        String url = "https://dzone.com";
        driver.get(url);

        // 2. Logica de la prueba:
        // En el campo de texto escribir un criterio de busqueda
        // capturar el campo de busqueda
        WebElement joiningLink = driver.findElement(By.id("//*[@id=\"ng-app\"]/body/div[2]/div/div/div[1]/div/div[2]/div[2]/a[2]"));
        joiningLink.sen
        String label = joiningLink.getText();
        joiningLink.click();

        try{
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        WebElement joiningBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div[2]/div[3]/button"));
        String labelBtn = joiningLink.getText();
        joiningBtn.click();
    }

    @AfterTest
    public void closeDriver() throws Exception {
        driver.quit();
    }
}
