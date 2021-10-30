package d04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03Maven {

//1. “https://www.saucedemo.com” Adresine gidin
//2. Username kutusuna “standard_user” yazdirin
//3. Password kutusuna “secret_sauce” yazdirin
//4. Login tusuna basin
//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
//6. Add to Cart butonuna basin
//7. Alisveris sepetine tiklayin
//8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
//9. Sayfayi kapatin

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

//2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

//3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

//4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement urun1 = driver.findElement(By.xpath("//*[@class='inventory_item_name']"));
        driver.findElement(By.xpath("//*[@class='inventory_item_name']")).click();

//6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

//7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        WebElement text = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]"));

        if (text.isDisplayed()){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

//9. Sayfayi kapatin
        driver.close();

    }
}
