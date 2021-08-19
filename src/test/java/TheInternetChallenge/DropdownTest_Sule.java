package TheInternetChallenge;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.junit.After;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTest_Sule {

WebDriver driver;

@BeforeMethod
    public void setup() {

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


}
@Test
    public void dropdown() throws InterruptedException{

    driver.get("https://the-internet.herokuapp.com/");
    WebElement dropdownlink = driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul[1]/li[11]/a[1]"));
 //   alternative to above xpaths
  //  WebElement dropdownlink = driver.findElement(By.xpath("//*[text()='Dropdown']"));
//    WebElement dropdownlink= driver.findElement(By.linkText("Dropdown"));

    dropdownlink.click();

    WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
    Select select = new Select(dropdown);
    String firstOption = select.getFirstSelectedOption().getText();


    select.selectByIndex(1);
    Thread.sleep(5000);

    select.selectByIndex(2);
List<WebElement> allOptions= select.getOptions();

for(WebElement w: allOptions) {
    System.out.println(w.getText());
}
// assert that there are 3 items in dropdown menu
    Assert.assertTrue(allOptions.size()==3);
}
@After
    public void teardown() throws InterruptedException{

    Thread.sleep(5000);
    driver.quit();
}


}
