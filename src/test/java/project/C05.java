package project;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.io.IOException;
import java.util.List;

public class C05 extends TestBase {


    @Test
    public void Test() throws IOException {

        //   Tarayıcıyı başlatın

        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String expectedUrl = driver.getCurrentUrl();
        String actualUrl = "https://automationexercise.com/";
        Assert.assertEquals("url uyusmuyor", expectedUrl, actualUrl);

        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        WebElement loginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        loginButton.click();


        //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        WebElement yeniKullaniciKaydiYaziElementi = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(yeniKullaniciKaydiYaziElementi.isDisplayed());
        System.out.println("yeniKullaniciKaydiYaziElementi.getText() = " + yeniKullaniciKaydiYaziElementi.getText());
        waitFor(2);
        takeScreenShotOfPage();

        //6. Adı ve kayıtlı e-posta adresini girin
        //7. 'Kaydol' düğmesini tıklayın
        WebElement nameTextBox = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        nameTextBox.sendKeys("hello", Keys.TAB, "aron.rolfson12343@gmail.com", Keys.TAB, Keys.ENTER);


        // 8. 'E-posta Adresi zaten mevcut!' hatasını doğrulayın. görünür

      // WebElement emailZatenMevcutYaziElementi = driver.findElement(By.xpath("//p[text()='Email Address already exist!']"));
      // Assert.assertTrue(emailZatenMevcutYaziElementi.isDisplayed());
      // System.out.println("emailZatenMevcutYaziElementi.getText() = " + emailZatenMevcutYaziElementi.getText());

        // month taki dropdowndan herhangi bir datayi secelim

        WebElement aylarDropdown=driver.findElement(By.xpath("//select[@id='months']"));

        Select dropdown=new Select(aylarDropdown);
       /* dropdown.selectByIndex(2);
        waitFor(3);
        dropdown.selectByVisibleText("March");
        waitFor(3);
        dropdown.selectByValue("6");
        waitFor(3);  */

        List<WebElement> listDropDown =dropdown.getOptions();
        listDropDown.stream().forEach(t-> System.out.println(t.getText()));
        System.out.println("**************");

        for (WebElement drop:listDropDown) {
            System.out.println("drop.getText() = " + drop.getText());
            Assert.assertEquals(listDropDown,drop);

        }



    }
}
