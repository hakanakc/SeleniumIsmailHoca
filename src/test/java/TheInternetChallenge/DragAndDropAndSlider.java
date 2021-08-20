package TheInternetChallenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
            Thread.sleep(1000);
            action.clickAndHold(fieldB).moveToElement(fieldA).release().perform();
            Thread.sleep(1000);
        }

        driver.navigate().back();
        Thread.sleep(3000);
     //   Horizontal slider

        WebElement horizontalSliderLink = driver.findElement(By.xpath("//a[text()='Horizontal Slider']"));
       horizontalSliderLink.click();
       Thread.sleep(3000);

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

        for(int i= 0;i<9;i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
Thread.sleep(3000);
        slider.sendKeys(Keys.ARROW_LEFT);

        Actions actionSlider = new Actions(driver);
        actionSlider.clickAndHold(slider).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.RIGHT).sendKeys(Keys.ARROW_RIGHT)
       .sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).release().perform();
    }

}
