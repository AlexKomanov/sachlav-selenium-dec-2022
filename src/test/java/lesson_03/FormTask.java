package lesson_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormTask {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Page 1

        String expectedErrorText = "This field is required.";

        By firstName = By.cssSelector("#firstname");
        By lastName = By.id("lastname");
        By email = By.name("email");
        By nextButton = By.cssSelector("#next");
        By firstNameError = By.cssSelector("id=\"firstname-error\"");
        By lastNameError = By.cssSelector("[id=\"lastname-error\"]");
        By emailError = By.cssSelector("[id=\"email-error\"]");



        Thread.sleep(2000);
        driver.quit();
    }

    public static void validateText(By selector, String expectedText, WebDriver driver) {
        WebElement element = driver.findElement(selector);
        if (element.getText().equals(expectedText)) {
            System.out.println("Text is correct");
        }
        else {
            System.out.println("Text is incorrect");
        }
    }

    public static void typeText(By selector, String text, WebDriver driver) {
        WebElement element = driver.findElement(selector);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public static void clickElement(By selector, WebDriver driver) {
        WebElement element = driver.findElement(selector);
        element.click();
    }
}
