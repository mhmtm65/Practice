import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {


    @Test
    public void Test01() throws InterruptedException {

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

        // 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        WebElement newUserSignupYazisi = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignupYazisi.isDisplayed());

        // Adı ve e-posta adresini girin
        // 'Kaydol' düğmesini tıklayın
        WebElement nameTextBox = driver.findElement(By.xpath("//*[@placeholder='Name']"));
        nameTextBox.sendKeys("Hello", Keys.TAB, "ksj76888@gmail.com", Keys.TAB, Keys.ENTER);


        // 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
        driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed();

        Thread.sleep(1000);

        // Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi

        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("freya", Keys.TAB);

        WebElement day = driver.findElement(By.id("days"));
            day.sendKeys("5", Keys.TAB, "April", Keys.TAB, "1994");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();
        Thread.sleep(3000);


        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("hello", Keys.TAB, "ye", Keys.TAB, "Freya", Keys.TAB, "Adres1", Keys.TAB,
                "Adres2", Keys.TAB, "Canada", Keys.TAB, "state", Keys.TAB, "ISt", Keys.TAB, "01-212", Keys.TAB, "05224", Keys.TAB, Keys.ENTER);

        //  'Bültenimize kaydolun!' onay kutusunu seçin.
        //  'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        //  Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        //  'Hesap Oluştur düğmesini' tıklayın


        //  'HESAP OLUŞTURULDU!' görünür
        WebElement hesapOlusturulduYaziElementi = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(hesapOlusturulduYaziElementi.isDisplayed());

        Thread.sleep(1000);

        //  'Devam Et' düğmesini tıklayın
        WebElement devamButton = driver.findElement(By.xpath("//a[text()='Continue']"));
        devamButton.click();
        Thread.sleep(1000);

        //  "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        driver.navigate().back();
        Thread.sleep(1000);
        devamButton.click();

        WebElement kullaniciIsmiGorunuyorMu = driver.findElement(By.xpath("//b[text()='Hello'] "));
        Assert.assertTrue(kullaniciIsmiGorunuyorMu.isDisplayed());


        Thread.sleep(1000);


        //  'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        Thread.sleep(1000);

        //  'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın
        WebElement hesapSilindiYaziElementi = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(hesapSilindiYaziElementi.isDisplayed());

    }
}
