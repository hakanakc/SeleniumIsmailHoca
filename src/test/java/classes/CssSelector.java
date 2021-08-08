package classes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;

public class CssSelector {

    WebDriver driver;
     @Test
    public void css() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/text-box");
       driver.manage().window().maximize();
      //  Dimension dim= new Dimension(400, 800);
      //  driver.manage().window().setSize(dim);

        //CSS tagName[AttributeName='AttributeValue']
              // note that there is a gap before the tag 'input' meaning it can start with any tag just like "//" in xpath
         // you can use * as as well
   WebElement email =  driver.findElement(By.cssSelector(" input[type='email']"));
         email.sendKeys("merhaba");

         // id TagName#idvalue or only #idvalue
       WebElement name = driver.findElement(By.cssSelector("#userName"));
       name.sendKeys("Ahmet");


          // scrolling down on a page
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,20)", "");
         Thread.sleep(2000);


       //Class Tagname.classValue  . means that tag name is starting with a class

         WebElement submitButton=driver.findElement(By.cssSelector(" button.btn.btn-primary"));

         // page will be scrolled down until element is visible
         js.executeScript("arguments[0].scrollIntoView();", submitButton);
         submitButton.click();

//         STARTING WITH	TagName[attribute^=‘value’]


         WebElement address = driver.findElement(By.cssSelector("textarea[id^='permanentA']"));
         address.sendKeys("Sheffield");

//         ENDING WITH	TagName[attribute$=‘value’]
         WebElement adressBox = driver.findElement(By.cssSelector("textarea[id$='rentAddress']"));
         adressBox.sendKeys("United Kingdom");
         submitButton.click();

   //      CONTAINS	TagName[attribute*=‘value’]

         WebElement currentAddress = driver.findElement(By.cssSelector("*[placeholder*='ent Add']"));
         currentAddress.sendKeys("Glasgow Rangers");
         submitButton.click();






    }


}
