package project;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04 {

    @Test
    public void Test01() throws InterruptedException {

        Faker faker = new Faker();

        // Tarayıcıyı başlatın
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        // Ana sayfanın başarıyla göründüğünü doğrulayın
        String exceptedTitle = driver.getTitle();
        System.out.println("exceptedTitle = " + exceptedTitle);

        String actualTitle = "Automation Exercise";


        Assert.assertEquals("Url uyusmuyor", exceptedTitle, actualTitle);


        Thread.sleep(1000);

        // 'Kaydol / Giriş Yap' düğmesine tıklayın
        WebElement loginButton = driver.findElement(By.xpath("//a[@href='/login']"));  //.click();
        loginButton.click();

        Thread.sleep(1000);


        //   5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        WebElement loginToYourAccountYaziElementi = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginToYourAccountYaziElementi.isDisplayed());

        //6. Doğru e-posta adresini ve şifreyi girin
        WebElement nameTextBox = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        nameTextBox.sendKeys("aron.rolfson@gmail.com", Keys.TAB, "123456");


        //7. 'Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        Thread.sleep(1000);

        //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        WebElement kullaniciIsmiGorunuyorMu = driver.findElement(By.xpath("//b[text()='hello']"));
        Assert.assertTrue(kullaniciIsmiGorunuyorMu.isDisplayed());

        //9. 'Çıkış' düğmesini tıklayın
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
        Thread.sleep(1000);

        //10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
        String loginSayfasi = driver.getCurrentUrl();
        String actualUrl1 = "https://automationexercise.com/login";
        Assert.assertEquals("Url eslesmiyor", loginSayfasi, actualUrl1);


    }
}
