package TheInternetChallenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAuth {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test(priority =1)

    public void popupBasicAuth() throws InterruptedException{


        driver.get("https://the-internet.herokuapp.com/basic_auth");

        driver.get("https://<admin>:<admin>@the-internet.herokuapp.com/basic_auth");
   Thread.sleep(3000);


}

@Test(priority = 2)
    public void multipleWindows(){

        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        WebElement clickHere = driver.findElement(By.cssSelector("a[href='/windows/new']"));
        clickHere.click();
      driver.getWindowHandles();






}

}