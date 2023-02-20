package homeTask3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBoxInput;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchSubmitButton;

    @FindBy(css = "[class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']")
    private WebElement nextPageButton;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchTextBoxInput() {
        return searchTextBoxInput;
    }

    public void setSearchTextBoxInput(WebElement searchTextBoxInput) {
        this.searchTextBoxInput = searchTextBoxInput;
    }

    public WebElement getSearchSubmitButton() {
        return searchSubmitButton;
    }

    public void setSearchSubmitButton(WebElement searchSubmitButton) {
        this.searchSubmitButton = searchSubmitButton;
    }

    public WebElement getNextPageButton() {
        return nextPageButton;
    }

    public void setNextPageButton(WebElement nextPageButton) {
        this.nextPageButton = nextPageButton;
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<WebElement> searchResults) {
        this.searchResults = searchResults;
    }

    @FindAll(@FindBy(css = "[data-component-type='s-search-results'] h2>a>span "))
    private List<WebElement> searchResults;


}
