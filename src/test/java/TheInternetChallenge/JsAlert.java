package TheInternetChallenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsAlert {

    WebDriver driver;// to access from different methods


    @BeforeMethod

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    //js alerts handling
    @Test

    public void jsAlert() throws InterruptedException{
        // Click for Js Alert

        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickButton = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        clickButton.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        String  result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        System.out.println(result);
        String expectResult = "You successfully clicked an alert";
        Assert.assertEquals(expectResult,result);

        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);


        //click for Js Confirm
        WebElement confirmClick = driver.findElement(By.xpath("//*[@onclick='jsConfirm()']"));
        confirmClick.click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        String confirmMessage= driver.findElement(By.cssSelector("#result")).getText();
        System.out.println(confirmMessage);
        String expectMessage = "You clicked: Cancel";
        Assert.assertEquals(confirmMessage,expectMessage);


    }
}
