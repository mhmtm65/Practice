package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {


    @Test
    public void test01() throws InterruptedException {

        // Tarayıcıyı başlatın
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        // Ana sayfanın başarıyla göründüğünü doğrulayın
        String exceptedUrl = driver.getTitle();
        String actualUrl = "Automation Exercise";
        Assert.assertEquals("Url uyusmuyor", exceptedUrl, actualUrl);


        Thread.sleep(1000);

        // 'Kaydol / Giriş Yap' düğmesine tıklayın
        WebElement loginButton = driver.findElement(By.xpath("//a[@href='/login']"));  //.click();
        loginButton.click();

        Thread.sleep(1000);


        //   5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        WebElement loginToYourAccountYaziElementi = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginToYourAccountYaziElementi.isDisplayed());

        //   6. Yanlış e-posta adresi ve şifre girin
        WebElement nameTextBox = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        //nameTextBox.click();
        nameTextBox.sendKeys("hello213@gmail.com", Keys.TAB, "12345");
        Thread.sleep(1000);

        //   7. 'Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        Thread.sleep(1000);


        //   8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür

        WebElement yanlisYaziElementi = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));

        Assert.assertTrue(yanlisYaziElementi.isDisplayed());
    }
}
