package lesson_02.homeTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HomeTask {
    public static void main(String[] args) throws InterruptedException {

        String baseUrl = "https://devexpress.github.io/testcafe/example";
        String name = "Irina";

        String nameInputSelector = "[data-testid='name-input']";

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(baseUrl);

        typeText(nameInputSelector, name, driver);

        WebElement remoteTestingCheckbox = driver.findElement(By.cssSelector("[data-testid='remote-testing-checkbox']"));
        remoteTestingCheckbox.click();

        clickElement("[data-testid='reusing-js-code-checkbox']", driver);

        WebElement parallelTestingCheckbox = driver.findElement(By.cssSelector("[data-testid='parallel-testing-checkbox']"));
        parallelTestingCheckbox.click();

        WebElement ciCheckbox = driver.findElement(By.cssSelector("[data-testid='ci-checkbox']"));
        ciCheckbox.click();

        WebElement analysisChechbox = driver.findElement(By.cssSelector("[data-testid='analysis-checkbox']"));
        analysisChechbox.click();

        WebElement triedTestCafeCheckbox = driver.findElement(By.cssSelector("[data-testid='tried-testcafe-checkbox']"));
        triedTestCafeCheckbox.click();

        WebElement commentArea = driver.findElement(By.cssSelector("[data-testid='comments-area']"));
        commentArea.sendKeys("my comment");

        WebElement slider = driver.findElement(By.cssSelector("[id=slider]"));
        Actions move = new Actions(driver);
        Action action = move.dragAndDropBy(slider, 30, 0).build();
        action.perform();

        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.cssSelector("[data-testid='submit-button'"));
        submitButton.click();

        WebElement thankYouHeader = driver.findElement(By.cssSelector("[data-testid='thank-you-header'"));

        if (thankYouHeader.getText().equals("Thank you, " + name + "!")){
            System.out.println("Text is correct");
        }
        else {
            System.out.println("Something wrong with text");
        }

        if(driver.getCurrentUrl().equals(baseUrl + "/thank-you.html")){
            System.out.println("URL is correct");
        }
        else {
            System.out.println("Something wrong with URL");
        }

        if (driver.getTitle().equals("Thank you!")){
            System.out.println("Title is correct");
        }
        else {
            System.out.println("Something wrong with title");
        }

        Thread.sleep(3000);

        driver.quit();

    }

    static void clickElement(String selector, WebDriver driver) {

        WebElement element = driver.findElement(By.cssSelector(selector));
        element.click();
    }

    static void typeText(String selector, String text, WebDriver driver) {

        WebElement element = driver.findElement(By.cssSelector(selector));
        element.clear();
        element.sendKeys(text);
    }
}
