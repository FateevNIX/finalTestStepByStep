package steps;
import io.qameta.atlas.webdriver.AtlasWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import pages.SearchResultsPage;
import static matchers.IsElementDisplayedMatcher.isDisplayed;
public class SearchResultsPageSteps extends BaseSteps {
    private String searchResultsPageURL = ("http://automationpractice.com/index.php?controller=search");
    public SearchResultsPageSteps(WebDriver driver){
        super (driver);
    }
    public String getSearchResultsPageURL(){
        return searchResultsPageURL;
    }

    public SearchResultsPageSteps moveToFirstProductInGrid(){
        // new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(firstItemInGrid)); пока оставил как напоминание что тут надо убедится что элемент отображается
        Actions action = new Actions(driver);
        AtlasWebElement elem = onSearchResultsPage().firstItemInGrid().should(isDisplayed());
        action.moveToElement(elem);
        return this;
    }
    public ProductDetailsPageSteps clickOnFirstItem(){
        moveToFirstProductInGrid().onSearchResultsPage().moreButtonForFirstItem().click();
      //  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(moreButtonForFirstItem)); пока оставил как напоминание что тут надо убедится что элемент отображается
        return new ProductDetailsPageSteps();
    }
    private SearchResultsPage onSearchResultsPage() {
        return on(SearchResultsPage.class);
    }
}
