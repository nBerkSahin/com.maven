package JUNIT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03JUNIT {

//2- https://www.amazon.com/ adresine gidin
//3- Browseri tam sayfa yapin
//4-Sayfayi “refresh” yapin
//5- Sayfa basliginin “Amazon” ifadesi icerdigini control edin
//6-Sayfa basliginin “Amazon.com. Spend less. Smile more.” a esit oldugunu control ediniz
//7- URL in amazon.com icerdigini control edin
//8-”Nutella” icin arama yapiniz
//9- Kac sonuc bulundugunu yaziniz
//10-Sayfayi kapatin

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void test1(){
        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");

        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5- Sayfa basliginin “Amazon” ifadesi icerdigini control edin
        if (driver.getTitle().contains("Amazon")){
            System.out.println("1. STEP PASS");
        } else {
            System.out.println("1. STEP FAIL");
        }

        //6-Sayfa basliginin “Amazon.com. Spend less. Smile more.” a esit oldugunu control ediniz
        if (driver.getTitle().contains("Amazon.com. Spend less. Smile more.")){
            System.out.println("2. STEP PASS");
        }else{
            System.out.println("2. STEP FAIL");
        }

        //7- URL in amazon.com icerdigini control edin
        if (driver.getCurrentUrl().contains("amazon.com")){
            System.out.println("3. STEP PASS");
        } else {
            System.out.println("3. STEP FAIL");
        }

        //8-”Nutella” icin arama yapiniz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        //9- Kac sonuc bulundugunu yaziniz
        System.out.println(driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]")).getText());

        //10-Sayfayi kapatin
        driver.close();
    }


}
