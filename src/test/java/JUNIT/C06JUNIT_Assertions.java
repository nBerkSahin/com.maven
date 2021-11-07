package JUNIT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C06JUNIT_Assertions {

//https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
//Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
//titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
//logoTest => BestBuy logosunun görüntülendigini test edin
//FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void test(){

//https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
        driver.get("https://www.bestbuy.com");
        String url = driver.getCurrentUrl().toString();

//Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        Assert.assertEquals("İstenen URL bulunamadı",url,"https://www.bestbuy.com/");

//titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        Assert.assertFalse("İstenmeyen kelime title da var",driver.getTitle().contains("Rest"));


//logoTest => BestBuy logosunun görüntülendigini test edin
        Assert.assertTrue("Logo görünmüyor",driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());

//FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement a = driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(a.isDisplayed());

    }


}
