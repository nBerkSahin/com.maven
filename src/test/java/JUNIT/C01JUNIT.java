package JUNIT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01JUNIT {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test1(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

    }

    @Test
    public void test2(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung"+ Keys.ENTER);

    }

    @Test
    public void test3(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);

    }

    @AfterClass
    public static void teardown(){
        driver.close();

    }



}
