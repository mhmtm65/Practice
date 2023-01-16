package project;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06 extends TestBase {

    @Test
    public void test() {

        //   Tarayıcıyı başlatın

        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String expectedUrl = driver.getCurrentUrl();
        String actualUrl = "https://automationexercise.com/";
        Assert.assertEquals("url uyusmuyor", expectedUrl, actualUrl);


        //4 . 'Bize Ulaşın' düğmesine tıklayın
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
        waitFor(1);

        //5 . "İLETİŞİME GEÇİN" ifadesinin görünür olduğunu doğrulayın
        driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).isDisplayed();

        waitFor(2);

        //6 . Adı, e-postayı, konuyu ve mesajı girin
        WebElement nameTextBox = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        Faker faker = new Faker();
        nameTextBox.sendKeys(faker.name().firstName(), Keys.TAB, faker.internet().emailAddress(), Keys.TAB, "Hello", Keys.TAB, "hello1");



        nameTextBox.sendKeys(Faker.instance().name().firstName(),
                Keys.TAB, Faker.instance().internet().emailAddress(), Keys.TAB, "Biz Geldik", Keys.TAB, "Selenium zor degil sanki");


        // 7 . Dosya yükleyin

        //8 . 'Gönder' düğmesini tıklayın

        driver.findElement(By.xpath("//input[@name='submit']")).click();
        waitFor(2);

        //9 . Tamam düğmesine tıklayın
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        waitFor(2);

        //10. Başarı mesajını doğrulayın 'Başarı! Bilgileriniz başarıyla gönderildi.' görünür
        WebElement basariMesajiYaziElementi = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(basariMesajiYaziElementi.isDisplayed());
        System.out.println("basariMesajiYaziElementi.getText() = " + basariMesajiYaziElementi.getText());

        waitFor(2);

        //11. 'Ana Sayfa' düğmesine tıklayın ve ana sayfaya başarıyla geldiğini doğrulayın

        WebElement homeButton = driver.findElement(By.xpath("//i[@class='fa fa-angle-double-left']"));
        homeButton.click();
        driver.navigate().back();
        homeButton.click();
        WebElement anasayfaDonus = driver.findElement(By.xpath("(//h2[text()='Full-Fledged practice website for Automation Engineers'])[1]"));
        Assert.assertTrue(anasayfaDonus.isDisplayed());


    }
}
