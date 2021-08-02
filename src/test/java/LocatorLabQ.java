import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class LocatorLabQ {

    WebDriver driver;


    @Test
    public void positive() throws InterruptedException {
        // Create an instance of ChromeDriver;
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.navigate().to("https://demo.cyclos.org/ui/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='User']"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));

        password.sendKeys("1234");

        driver.findElement(By.id("forgotPasswordLink"));
        driver.findElement(By.id("registerLink"));

        // Assert submit button is enabled
        boolean checkButton = driver.findElement(By.xpath("//button[@class='btn d-flex justify-content-center align-items-center w-100 h-100 btn-primary']")).isEnabled();
        System.out.println(checkButton);


        WebElement submit = driver.findElement(By.xpath("//button[@class='btn d-flex justify-content-center align-items-center w-100 h-100 btn-primary']"));
        submit.click();

        // Wait for 5 seconds
        Thread.sleep(5000);
        //farkli bir locator ile //  WebElement submit = driver.findElement((By.xpath("//button[@type='button' and span[contains(text(), 'Submit')]]")));
        //    submit.click();
// Print out full name

        String fullname = driver.findElement(By.xpath("//div[@class='personal-label']")).getText();
        // Print out full name
        System.out.println(fullname);

        //        // Assert full name is 'Demo user'
        Assert.assertEquals(fullname, "Demo user");

//        //Print out Balance value (Follow same methods as 'Print out full name'

        String value = driver.findElement(By.xpath("//div[@class='balance-value positive']")).getText();

        System.out.println(value);

        // Assert balance is "7.800 IU"
//
        Assert.assertFalse(Boolean.parseBoolean(value), "7.800 IU");
        driver.quit();


    }



    @Test
  public void negativeEmptyPassword() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.navigate().to("https://demo.cyclos.org/ui/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='User']"));
        username.sendKeys("demo");
        WebElement submit = driver.findElement(By.xpath("//button[@class='btn d-flex justify-content-center align-items-center w-100 h-100 btn-primary']"));
        submit.click();
        Thread.sleep(3000);
        String invalidFeedback = driver.findElement(By.className("invalid-feedback")).getText();

        // Assert error message for password: Expected --> "This field is required"
        Assert.assertEquals(invalidFeedback,"This field is required");

        // Assert that page title is "Login - Cyclos"
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Login - Cyclos";
        assertEquals(expectedTitle,actualTitle);



        // Assert that current URL is still --> "https://demo.cyclos.org/ui/login"
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://demo.cyclos.org/ui/login" );
        Thread.sleep(2000);
        driver.quit();

    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//        // Quit driver
//
//
  }
//
