package lesson_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstRun {

    public static void main(String[] args) throws InterruptedException {

        // Setup chromedriver
        WebDriverManager.chromedriver().setup();

        // Initialization of ChromeDriver
        WebDriver driver = new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();

        //Navigate to URL
        driver.get("https://www.google.com");

        //Current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //Page Source
//        System.out.println("driver.getPageSource() = " + driver.getPageSource());

        // Title
        System.out.println("driver.getTitle() = " + driver.getTitle());

        //Navigation to different URL
        driver.navigate().to("https://www.yandex.ru");

        //Go Back
        driver.navigate().back();

        //Go Forward
        driver.navigate().forward();

        //Refresh
        driver.navigate().refresh();

        //Get Title
        System.out.println("driver.getTitle() = " + driver.getTitle());

        Thread.sleep(1000);
        driver.quit();
    }
}
