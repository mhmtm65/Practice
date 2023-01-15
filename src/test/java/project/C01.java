package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {


    @Test
    public void Test() throws InterruptedException {

        //  1) Open the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //  2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //  3) Click on Shop Menu
        WebElement shopMenu = driver.findElement(By.cssSelector("#menu-item-40"));
        shopMenu.click();

        // driver.navigate().back();

        //   shopMenu.click();

        //  4) Now click on Home menu button
        WebElement homeMenu = driver.findElement(By.xpath("//a[text()='Home']"));
        homeMenu.click();


        //  5) Test whether the Home page has Three Sliders only
        WebElement threeSlider = driver.findElement(By.xpath("//html[@class='js csstransitions supports csstransforms3d csstransformspreserve3d']"));
        Assert.assertTrue("Gorunmuyor", threeSlider.isDisplayed());

        Thread.sleep(1000);

        WebElement threeSlider1 = driver.findElement(By.xpath("(//img[@alt='Arrow'])[1]"));
        Assert.assertTrue(" Arrow Gorunmuyor", threeSlider1.isDisplayed());

        Thread.sleep(1000);

        WebElement threeSlider2 = driver.findElement(By.xpath("//a[@class='pull-down']"));
        Assert.assertTrue("threeSlider2 Gorunmuyor ", threeSlider2.isDisplayed());




        //  6) The Home page must contains only three sliders



    //   //1) Open the browser
    //   //2) Enter the URL "http://practice.automationtesting.in/"
    //   driver.get("https://practice.automationtesting.in/");
    //   //3) Click on Shop Menu
    //   driver.findElement(By.linkText("Shop")).click();
    //   driver.navigate().refresh();
    //   driver.findElement(By.linkText("Shop")).click();
    //   //4) Now click on Home menu button
    //   driver.findElement(By.linkText("Home")).click();
    //   //5) Test whether the Home page has Three Arrivals only
    //   driver.findElement(By.xpath("//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']")).isDisplayed();
    //   //6) The Home page must contains only three Arrivals
    //   WebElement threeArrivals = driver.findElement(By.xpath("//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']"));
    //   Assert.assertTrue(threeArrivals.isDisplayed());
    //   //7) Now click the image in the Arrivals
    //   driver.findElement(By.xpath("(//*[@class='woocommerce-LoopProduct-link'])[3]")).click();
    //   //8) Test whether it is navigating to next page where the user can add that book into his basket.
    //   driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']")).click();
    //   Thread.sleep(3000);
    //   driver.findElement(By.xpath("//*[@class='button wc-forward']")).click();
    //   String yeniSayfaUrl = driver.getCurrentUrl();
    //   Assert.assertEquals("https://practice.automationtesting.in/basket/",yeniSayfaUrl);
    //   //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
    //   driver.navigate().back();
    //   Thread.sleep(1000);
    //   driver.navigate().back();
    //   Thread.sleep(1000);
    //   driver.navigate().back();
    //   driver.findElement(By.xpath("(//*[@class='woocommerce-LoopProduct-link'])[3]")).click();
    //   driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']")).click();
    //   Thread.sleep(3000);
    //   driver.findElement(By.xpath("//*[@class='button wc-forward']")).click();
    //   //10) Now clock on Reviews tab for the book you clicked on.
    //   driver.navigate().back();
    //   Thread.sleep(3000);
    //   driver.findElement(By.xpath("//*[@class='reviews_tab']")).click();
    //   //11) There should be a Reviews regarding that book the user clicked on


    }
}
