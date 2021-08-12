package classes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class StudentRegistrationForm {

    WebDriver driver;

@BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {

    Thread.sleep(3000);

    driver.quit();
    }

    @Test
    public void registerStudent() throws InterruptedException {
    driver.navigate().to("https://demoqa.com/automation-practice-form");


    //firstName
    WebElement firstname = driver.findElement(By.id("firstName"));
    firstname.sendKeys("john");
    // LastName
     WebElement lastname = driver.findElement(By.xpath("//*[@placeholder ='Last Name']"));
   lastname.sendKeys("Doe");
   // Email
   WebElement email = driver.findElement(By.id("userEmail"));
   email.sendKeys("JohnDoe@email.com");
// Gender
 WebElement genderOther = driver.findElement(By.xpath("(//*[@class='custom-control-label'])[3]"));
  //     WebElement genderOther = driver.findElement(By.xpath("//input[@name='gender'and @id='gender-radio-3']"));
   //    alternative/similar usages for above.
      //  WebElement genderOther = driver.findElement(By.xpath("//input[@name='gender'][@id='gender-radio-3']"));
//  WebElement genderOther = driver.findElement(By.xpath("//input[@name='gender' or @id='gender-radio-3']"));
   genderOther.click();

   WebElement phoneNumber = driver.findElement(By.id("userNumber"));
phoneNumber.sendKeys("1231231212");
Thread.sleep(2000);
phoneNumber.clear();
phoneNumber.sendKeys("6546847812");
Thread.sleep(3000);


// Select date of birth.
WebElement clickDoB = driver.findElement(By.id("dateOfBirthInput"));
clickDoB.click();
Thread.sleep(2000);


// Requirement/ Test Data: Select 10 Jan 1990
       // Select month
        WebElement selectMonth = driver.findElement(By.className("react-datepicker__month-select"));
        Select select = new Select(selectMonth);
        select.selectByIndex(0); //selects January
  //      select.selectByValue("2");
//        select.selectByVisibleText("March");
          Thread.sleep(2000);
         //  Select year
        WebElement selectYear = driver.findElement(By.cssSelector(".react-datepicker__year-select"));
select=  new Select(selectYear);
select.selectByValue("1990");

// Select Day
WebElement selectDay = driver.findElement(By.cssSelector(".react-datepicker__day.react-datepicker__day--010"));
selectDay.click();

// Assert date
//        String actualDate = clickDoB.getAttribute("value");
//        System.out.println("actual date is = "+ actualDate);
//        String expectedDate = "10 Jan 1991";
//        Assert.assertEquals(actualDate,expectedDate);

// Select element
//        WebElement subjectArea = driver.findElement(By.id("subjectsInput"));subjectArea.sendKeys("m");
//        List<WebElement> courses = driver.findElements(By.cssSelector(".subjects-auto-complete__menu.css-26l3qy-menu"));
//        for (WebElement course : courses) {System.out.println(course.getText());course.click();}

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        // subject
        WebElement lesson = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        lesson.sendKeys("Maths");
        Thread.sleep(3000);
        lesson.sendKeys(Keys.ENTER);
        Thread.sleep(3000);



    }


}