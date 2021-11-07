package JUNIT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C07JUNIT_Assertions_3 {

//2. http://automationpractice.com/index.php sayfasina gidelim
//3. Sign in butonuna basalim
//4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid
//email address” uyarisi ciktigini test edelim

    WebDriver driver;

@Before
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.get("http://automationpractice.com/index.php");

}
@Test
    public void test() throws InterruptedException {
    driver.findElement(By.partialLinkText("Sign in")).click();
    driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("ecnecıuın.com"+ Keys.ENTER);

    Thread.sleep(3000);
    WebElement hatayazisi = driver.findElement(By.id("create_account_error"));
    Assert.assertTrue(hatayazisi.isDisplayed());
    driver.close();

}




}
