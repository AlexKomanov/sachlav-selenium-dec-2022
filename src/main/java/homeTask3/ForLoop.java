package homeTask3;

import org.openqa.selenium.WebElement;

public class ForLoop {

    MainPage mainPageAmazon;

    public ForLoop(MainPage mainPageAmazon) {
        this.mainPageAmazon = mainPageAmazon;
    }

    public void printProducts(int pages){

        for (int i = 1; i <= pages ; i++) {
            System.out.println("----------------page " + i + "--------------------");
            for (WebElement element: mainPageAmazon.getSearchResults()) {
                if (element.getText() != "") {
                    System.out.println(element.getText());
                    System.out.println("---------------------------------------------");
                }
            }
            mainPageAmazon.clickElement(mainPageAmazon.getNextPageButton());
        }

    }
}
