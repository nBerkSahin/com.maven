package JUNIT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C07JUNIT_Assertions_2 {

//https://www.youtube.com adresine gidin
//titleTest => Sayfa başlığının “YouTube” oldugunu test edin
//imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
//Search Box 'in erisilebilir oldugunu test edin (isEnabled())
//wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");

    }

    @Test
    public void test1(){
    //titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        Assert.assertEquals(driver.getTitle(),"YouTube");
    }

    @Test
    public void test2(){
    //imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]")).isDisplayed());
    }

    @Test
    public void test3(){
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.id("search-input")).isEnabled());
    }

    @Test
    public void test4(){
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertNotEquals(driver.getTitle(),"youtube");
    }

}
