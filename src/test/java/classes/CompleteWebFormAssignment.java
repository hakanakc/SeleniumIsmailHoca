package classes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

    driver.quit();
}
@Test
    public void testCompleteWebForm() throws InterruptedException{
    //locate elements
    WebElement firstName = driver.findElement(By.id());




}



}
