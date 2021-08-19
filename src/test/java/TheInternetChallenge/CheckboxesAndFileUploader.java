package TheInternetChallenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesAndFileUploader {

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

@Test

    public void checkBoxes() throws InterruptedException {

    driver.get("https://the-internet.herokuapp.com/checkboxes");

    WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));

    checkbox1.click();
    Thread.sleep(3000);
    WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
    Assert.assertTrue(checkbox2.isEnabled());
    checkbox2.click();
    Assert.assertTrue(checkbox1.isSelected());
    Thread.sleep(5000);
}
// to upload a file
@Test
    public void fileUpload() throws InterruptedException {

    driver.get("https://the-internet.herokuapp.com/upload");

   WebElement uploading = driver.findElement(By.id("file-upload"));

    uploading.sendKeys("C:\\Users\\ayten-hakan\\Desktop\\uploadDocument.txt");

    Thread.sleep(3000);

    WebElement uploadButton = driver.findElement(By.id("file-submit"));
    uploadButton.click();
    WebElement check = driver.findElement(By.tagName("h3"));
    String message = check.getText();
    System.out.println("message = "+message);
    Assert.assertEquals(message,"File Uploaded!");
    Thread.sleep(5000);




}




}
