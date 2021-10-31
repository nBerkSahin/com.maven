package JUNIT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02JUNIT {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());

    }

    @Test
    public void facebookTest(){
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());

    }

    @Test
    public void yandexTest(){
        driver.get("https://yandex.com.tr");
        System.out.println(driver.getTitle());

    }

    @After
    public void tearDown(){
        driver.close();

    }

}
