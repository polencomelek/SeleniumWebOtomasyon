
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Testing {

    public WebDriver driver;
    private java.lang.Object System;

    @Before
    public void Start(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\polen\\IdeaProjects\\PolenComelek\\geckodriver.exe");

        //Chorome Driver oluşturma.

        driver=new ChromeDriver();

        // Website URL
        String url ="https://www.gittigidiyor.com/";
        driver.get(url);


        //ekranı maximize etme

        driver.manage().window().maximize();

        //Control

        String NewUrl;
        NewUrl=driver.getCurrentUrl();
        Assert.assertEquals(url,NewUrl);


        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);




    }


    @Test
    public void Test() throws InterruptedException {

        // Giriş yap a tıklanır.

        WebElement girisbutonu= driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[1]/div[2]"));
        girisbutonu.click();

        // yapın altında ki giriş butonuna tıklanır.

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement girisbutonu1= driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a"));
        girisbutonu1.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // kontrol

        String BeklenenURL=driver.getCurrentUrl();

        Assert.assertEquals("https://www.gittigidiyor.com/uye-girisi",BeklenenURL);


        // username girişi

        WebElement emailkutusu= driver.findElement(By.id("L-UserNameField"));
        emailkutusu.click();
        emailkutusu.sendKeys("yourmail@gmail.com");//Your Mail


        // password girişi

        WebElement password = driver.findElement(By.id("L-PasswordField"));
        password.click();
        password.sendKeys("your password");//Your Password
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);


        //Login buttonuna tıklanması

        driver.findElement(By.id("gg-login-enter")).click();
        Thread.sleep(3000);
        String Kontrol=driver.getTitle();

        //Kontrol

        Assert.assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi",Kontrol);

        // Search Bilgisayar  yazılıp tıklanması


        WebElement aramakutusu = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input"));
        aramakutusu.click();
        aramakutusu.sendKeys("Bilgisayar");

        driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[2]/button")).click();
        Thread.sleep(3000);




        //2. Sayfa



        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div/a/span")).click();
        WebElement sayfadegis=driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div[5]/ul/li[2]/a"));
        sayfadegis.click();
        WebElement kontrol2 =driver.findElement(By.cssSelector("a[class='current']"));
        String sayfa2=kontrol2.getText();
        Assert.assertEquals("2",sayfa2);
        Thread.sleep(3000);



        // ürün seçilimi



        driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div[3]/div[2]/ul/li[32]/a/div")).click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);



        //Seçilen ürünün Fiyatı


        WebElement secilenUrun = driver.findElement(By.cssSelector("div[id='sp-price-discountPrice']"));
        String urunFiyat=secilenUrun.getText();
        driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);


        //Seçilen ürünün Sepete eklenmesi



        driver.findElement(By.cssSelector("button[id='add-to-basket']")).click();
        Thread.sleep(3000);

        //SEPETİM


        driver.findElement(By.cssSelector("a[class='dIB']")).click();



        //Sepetteki ürünün fiyati


        WebElement Sepette = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[5]/div[1]/div[2]/strong[2]"));
        String SepetteFiyat =Sepette.getText();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);



        //Fiyat Kıyaslaması


        Assert.assertEquals(urunFiyat,SepetteFiyat);

        //Adet arttırma


        Thread.sleep(3000);
        WebElement Deger = driver.findElement(By.cssSelector("option[value='2']"));
        Deger.click();

        //Adet konrolü


        String deger2=Deger.getText();
        Assert.assertEquals("2",deger2);


        Thread.sleep(3000);

        //Sepetin Boşalt



        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[6]/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/a/i")).click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        //Kontrol aşaması


        Thread.sleep(3000);
        String kontrol3=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[2]/h2")).getText();
        Assert.assertEquals("Sepetinizde ürün bulunmamaktadır.",kontrol3);
        Thread.sleep(3000);

    }
    @After
    public void Finish(){
        driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
        driver.quit();




    }













}
