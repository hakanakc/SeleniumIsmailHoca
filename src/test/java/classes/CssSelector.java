package classes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelector {

    WebDriver driver;
     @Test
    public void css() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/text-box");

        //CSS tagName[AttributeName='AttributeValue']
              // note that there is a gap beofre the tag 'input' meaning it can start with any tag just like "//" in xpath
         // you can use * as as well
   WebElement email =  driver.findElement(By.cssSelector(" input[type='email']"));
         email.sendKeys("merhaba");

         // id TagName#idvalue or only #idvalue
       WebElement name = driver.findElement(By.cssSelector("#userName"));
       name.sendKeys("Ahmet");






    }


}
