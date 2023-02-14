package lesson_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class EbayTask {
    public static void main(String[] args) throws InterruptedException {

        String baseUrl = "https://www.ebay.com";

        /**
         * https://www.ebay.com/sch/ebayadvsearch
         * Введите в поиске ‘macbook pro’ и задайте
         * поиск (через кнопку search или через submit by enter?)
         * Распечатайте список макбуков через цикл
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(baseUrl + "/sch/ebayadvsearch");

        driver.findElement(By.cssSelector("[data-testid='_nkw']")).sendKeys("macbook pro", Keys.ENTER);

        // Optional actions for search
//        driver.findElement(By.cssSelector("[data-testid='_nkw']")).sendKeys("macbook pro");
//        driver.findElement(By.cssSelector("[class='btn btn--primary']")).click();
//        driver.findElements(By.cssSelector("[class='btn btn--primary']")).get(0).click();

        List<WebElement> elements = driver.findElements(By.cssSelector("[class=\"s-item__info clearfix\"] > a"));

        System.out.println("elements.size() = " + elements.size());

        elements.forEach(element -> System.out.println(element.getText()));

        elements.get(5).click();

        Thread.sleep(7000);

        driver.close();

        Thread.sleep(3000);
        driver.quit();


    }
}
