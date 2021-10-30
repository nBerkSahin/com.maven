package d04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02Maven {
    public static void main(String[] args) {

//        1. http://zero.webappsecurity.com sayfasina gidin
//        2. Signin buttonuna tiklayin
//        3. Login alanine “username” yazdirin
//        4. Password alanine “password” yazdirin
//        5. Sign in buttonuna tiklayin
//        6. Pay Bills sayfasina gidin
//        7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
//        8. tarih kismina “2020-09-10” yazdirin
//        9. Pay buttonuna tiklayin
//        10. “The payment was successfully submitted.” mesajinin ciktigini control edin


//1. http://zero.webappsecurity.com sayfasina gidin
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.get("http://zero.webappsecurity.com");

//2. Signin buttonuna tiklayin
driver.findElement(By.id("signin_button")).click();

//3. Login alanine “username” yazdirin
driver.findElement(By.id("user_login")).sendKeys("username");

//4. Password alanine “password” yazdirin
driver.findElement(By.id("user_password")).sendKeys("password");

//5. Sign in buttonuna tiklayin
driver.findElement(By.xpath("//input[@value='Sign in']")).click();

driver.findElement(By.id("details-button")).click();
driver.findElement(By.id("proceed-link")).click();

//6. Pay Bills sayfasina gidin
driver.findElement(By.xpath("//*[@id=\"pay_bills_tab\"]/a")).click();

//7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
driver.findElement(By.id("sp_amount")).sendKeys("5000");

//8. tarih kismina “2020-09-10” yazdirin
driver.findElement(By.id("sp_date")).sendKeys("2021-10-22");

//9. Pay buttonuna tiklayin
driver.findElement(By.xpath("//*[@id=\"pay_saved_payees\"]")).click();

//10. “The payment was successfully submitted.” mesajinin ciktigini control edin
WebElement text1 = driver.findElement(By.xpath("//*[@id=\"alert_content\"]/span"));

        if (text1.isDisplayed()){
            System.out.println("Test Pass");

        }else {
            System.out.println("Test Fail");
        }
    }
}
