package lesson_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormTask {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.automation.co.il/tutorials/selenium/demo1/indexID.html");
        // Page 1

        String expectedErrorText = "This field is required.";

        By firstName = By.cssSelector("#firstname");
        By lastName = By.id("lastname");
        By email = By.name("email");
        By nextButton = By.cssSelector("#next");
        By firstNameError = By.cssSelector("[id=\"firstname-error\"]");
        By lastNameError = By.cssSelector("[id=\"lastname-error\"]");
        By emailError = By.cssSelector("[id=\"email-error\"]");

        clickElement(nextButton);

        validateText(firstNameError, expectedErrorText);
        validateText(lastNameError, expectedErrorText);
        validateText(emailError, expectedErrorText);

        typeText(firstName, "Alex");
        typeText(lastName, "Komanov");
        typeText(email, "ako@gmail.com");

        clickElement(nextButton);



        Thread.sleep(2000);
        driver.quit();
    }

    public static void validateText(By selector, String expectedText) {
        WebElement element = driver.findElement(selector);
        if (element.getText().equals(expectedText)) {
            System.out.println("Text is correct");
        }
        else {
            System.out.println("Text is incorrect");
        }
    }

    public static void typeText(By selector, String text) {
        WebElement element = driver.findElement(selector);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public static void clickElement(By selector) {
        WebElement element = driver.findElement(selector);
        element.click();
    }
}
