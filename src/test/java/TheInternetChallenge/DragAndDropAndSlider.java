package TheInternetChallenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class DragAndDropAndSlider {

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

    @Test
    public void DragAndDropAnd_Slider() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement fieldA = driver.findElement(By.id("column-a"));
        WebElement fieldB = driver.findElement(By.id("column-b"));
        Actions action = new Actions(driver);
        // to do the same action 2 times we created for loop below
        for (int i = 0; i < 2; i++) {

            action.clickAndHold(fieldA).moveToElement(fieldB).release().perform();
            Thread.sleep(3000);
            action.clickAndHold(fieldB).moveToElement(fieldA).release().perform();
            Thread.sleep(3000);
        }

    }

}
