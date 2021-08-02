package classes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

WebDriver driver;


    @Test

    public void baseTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();

        driver.navigate().to("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.quit();
    }

    @Test

    public void singleInputField() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        //     driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys("Hello World");

        WebElement enterMessage = driver.findElement(By.xpath("//input[@placeholder='Please enter your Message']"));
        enterMessage.sendKeys("Hello world");


        WebElement showMessageButton = driver.findElement(By.xpath("//button[@onclick='showInput();']"));

        showMessageButton.click();
           Thread.sleep(3000);


        String str = driver.findElement(By.xpath("//span[@id='display']")).getText();
        System.out.println(str);
        Assert.assertEquals(str,"Hello world");

    }

    @Test

    public void basicCalculation() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

      WebElement enterA = driver.findElement(By.xpath("//input[@id='sum1']"));
int a = 10;
// dikkat send.keys herzaman string gonderir bu yuzden asagida direk tirnak icine yazilmadi sayilar.
enterA.sendKeys(String.valueOf(a));


        int b = 20;
     WebElement enterB = driver.findElement(By.xpath("//input[@id='sum2']"));


    enterB.sendKeys(String.valueOf(b));

     WebElement getTotalButton= driver.findElement(By.xpath("//button[@onclick='return total()']"));

     getTotalButton.click();


     WebElement total = driver.findElement(By.xpath("//span[@id='displayvalue']"));
      String actualTotal=   total.getText();

     Assert.assertEquals(actualTotal,"30");

     Thread.sleep(5000);
     driver.quit();


    }








}
