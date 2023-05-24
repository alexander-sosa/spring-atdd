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

public class BuscarGoogleTest {
    private WebDriver driver;

    @BeforeTest
    public void setDriver() throws  Exception {
        String path = "E:\\Phoenix Docs\\Universidad Catolica Boliviana\\8vo Semestre\\SIS 312 - Gestion de Calidad de Sistemas";
        System.setProperty("webdriver.chrome.driver", path);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void paginaPrincipalGoogle(){
        // 1. Preparacion de la prueba
        String googleUrl = "https://www.google.com";
        driver.get(googleUrl);

        // 2. Logica de la prueba:
        // En el campo de texto escribir un criterio de busqueda
        // capturar el campo de busqueda
        WebElement campoBusqueda = driver.findElement(By.name("q"));
        campoBusqueda.sendKeys("Universidad Catolica Boliviana");
        campoBusqueda.submit();

        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        // 3. verificar la situacion esperada
        WebElement result = driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div[2]/h2/span"));
        String label = result.getText();
        // System.out.println("Texto resultado: " + label);
        assertEquals(label, "Universidad Católica Boliviana");
    }

    @AfterTest
    public void closeDriver() throws Exception{
        driver.quit();
    }
}
