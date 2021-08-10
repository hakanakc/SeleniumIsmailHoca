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

    public void method() {
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

        if (boxx.isSelected()) {
            boxx.click();

        }

    }
// football fixture for Turkey league

    @Test
    public void Football() {

        driver.get("https://www.tff.org/default.aspx?pageID=198");
        WebElement grandTable = driver.findElement(By.xpath("//*[@id='ctl00_MPane_m_198_10561_ctnr_m_198_10561_Panel1']//tr[14]/td[9]"));
        System.out.println(grandTable.getText());

        int row = 20;
        int column = 8;
        WebElement Table = driver.findElement(By.xpath("//*[@id='ctl00_MPane_m_198_10561_ctnr_m_198_10561_Panel1']//tr[" + row + "]/td[" + column + "]"));
        System.out.println(Table.getText());


        for (int i = 1; i < 21; i++) {
            for (int j = 1; j < 9; j++) {
                WebElement fenerbahce = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + 8 + "]/td[" + 9 + "]"));
                System.out.print(fenerbahce.getText() + " ");
            }
            System.out.println();
        }
//
//
//          driver.get("https://demoqa.com/webtables");
//          //                                          table             head/body  Row         Column
//          WebElement demo=driver.findElement(By.xpath("//div[@class='rt-table']/div[2]/div[3]/div/div[4]"));
//          System.out.println(demo.getText());


    }
}

