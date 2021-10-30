package d04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01Maven {

    public static void main(String[] args) throws InterruptedException {

//        1- https://www.amazon.com/ sayfasina gidelim
//        2- arama kutusunu locate edelim
//        3- “Samsung headphones” ile arama yapalim
//        4- Bulunan sonuc sayisini yazdiralim
//        5- Ilk urunu tiklayalim
//        6- Sayfadaki tum basliklari yazdiralim


//1- https://www.amazon.com/ sayfasina gidelim
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        // 5 sn boyunca locator u arar. Bulamazsa error döner.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//2- arama kutusunu locate edelim
//3- “Samsung headphones” ile arama yapalim
        //driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input")).sendKeys("Samsung Headphones");
//        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Samsung Headphones");
//        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

        // or

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung Headphones"+ Keys.ENTER);

        //By.className ile locate ettiğimiz webelementinde class atrribue nun değerinde boşluk varsa locator sağlıklı çalışmayabilir.

//4- Bulunan sonuc sayisini yazdiralim
        WebElement syazı = driver.findElement(By.xpath("//div[@class ='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(syazı.getText());

//5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]")).click();


//6- Sayfadaki tum basliklari yazdiralim
        driver.navigate().back();

        List<WebElement> urunlerListesi = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement each:urunlerListesi
             ) {
            System.out.println(each.getText());
        }

    }





}
