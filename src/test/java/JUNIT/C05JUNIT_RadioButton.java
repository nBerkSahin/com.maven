package JUNIT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C05JUNIT_RadioButton {

//- https://www.facebook.com adresine gidin
//- “Create an Account” button’una basin
//- “radio buttons” elementlerini locate edin
//- Secili degilse cinsiyet butonundan size uygun olani secin

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void test1() throws InterruptedException {
        //- https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //- “Create an Account” button’una basin
        driver.findElement(By.xpath("//*[.='Yeni Hesap Oluştur']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[.='sex'])[2]")).click();

    }


}
