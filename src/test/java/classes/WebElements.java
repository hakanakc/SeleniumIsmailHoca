package classes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElements {

    WebDriver driver;
    @BeforeMethod

    public void method(){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
  }

  @AfterMethod

    public void After() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
  }

  @Test
    public void elements() throws InterruptedException {
 // CheckBox
//   driver.get("https://demoqa.com/checkbox");
//   WebElement uncheckbox = driver.findElement(By.cssSelector(".rct-icon.rct-icon-uncheck"));
//   uncheckbox.click();
  //    WebElement checkbox = driver.findElement(By.cssSelector("(//*[@stroke='currentColor'])[49]"));


Thread.sleep(3000);
 // Assert.assertTrue(checkbox.isSelected());
// same purpose but a different method
// Assert.assertEquals(checkbox.isSelected(),true);
//
//      driver.get("https://demoqa.com/radio-button");
//      Thread.sleep(2000);
//      WebElement impres = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
//      impres.click();
//      System.out.println(impres.isSelected());


      driver.get("http://omayo.blogspot.com/");
      WebElement boxx = driver.findElement(By.id("checkbox1"));

      if(boxx.isSelected()){boxx.click();

      }






  }


}
