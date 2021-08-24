package classes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompleteWebFormAssignment {
WebDriver driver;


@BeforeMethod

    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://formy-project.herokuapp.com/form");

}

@AfterMethod
    public void tearDown(){

//    driver.quit();
}
@Test
    public void testCompleteWebForm() throws InterruptedException{
    //locate elements
    WebElement firstName = driver.findElement(By.id("first-name"));
    firstName.sendKeys("John");
    WebElement lastName = driver.findElement(By.id("last-name"));
    lastName.sendKeys("Doe");

    WebElement jobTitle = driver.findElement(By.id("job-title"));
    jobTitle.sendKeys("QA Tester");

    WebElement education = driver.findElement(By.id("radio-button-3"));
   education.click();

    WebElement gender = driver.findElement(By.id("checkbox-3"));
    gender.click();

    driver.findElement(By.id("select-menu"));

    Select experience =new Select(driver.findElement(By.id("select-menu")));

    experience.selectByVisibleText("0-1");

WebElement dateArea = driver.findElement(By.id("datepicker"));

dateArea.click();



  WebElement datePicker = driver.findElement(By.xpath("//*[@class='datepicker-days']//*[@class='datepicker-switch']"));
    WebElement previousButton = datePicker.findElement(By.xpath("//*[@class='datepicker-days']//*[@class='prev']"));
  WebElement submit = driver.findElement(By.linkText("Submit"));


  //action

    // Select date 1

    while (!datePicker.getText().equals("December 2008")) {
        previousButton.click();
    }
    Thread.sleep(5000);
  WebElement day = driver.findElement(By.xpath("//*[@class='day' and contains(text(),'28')]"));
  day.click();
Thread.sleep(5000);

submit.click();

Thread.sleep(2000);
String headerText=driver.findElement(By.tagName("h1")).getText();
String alert = driver.findElement(By.cssSelector(".alert.alert-success")).getText();


    System.out.println("alert= " + alert);
    System.out.println("headerText= "+ headerText);
}

}
