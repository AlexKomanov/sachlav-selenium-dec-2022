package lesson_03.homeTask;

import homeTask3.ForLoop;
import homeTask3.MainPage;
import homeTask3.WhileLoop;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTask {

    static WebDriver driver;
    public static void main(String[] args) {




            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("https://www.amazon.com/");

            MainPage mainPageAmazon = new MainPage(driver);
            mainPageAmazon.typeText(mainPageAmazon.getSearchTextBoxInput(), "tent");

            sleep(1000);
            mainPageAmazon.clickElement(mainPageAmazon.getSearchSubmitButton());
            sleep(1000);

            ForLoop forLoop = new ForLoop(mainPageAmazon);
            forLoop.printProducts(10);

            System.out.println("\n++++++++++++++++ next loop +++++++++++++++\n");

            driver.get("https://www.amazon.com/");
            mainPageAmazon.typeText(mainPageAmazon.getSearchTextBoxInput(), "tent");
            mainPageAmazon.clickElement(mainPageAmazon.getSearchSubmitButton());

            WhileLoop whileLoop = new WhileLoop(mainPageAmazon);
            whileLoop.printProducts(10);

            driver.quit();
        }

        public static void sleep(int timeout) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
