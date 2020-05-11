package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.SearchResultsPage;

import static matchers.IsElementDisplayedMatcher.isDisplayed;

public class SearchResultsPageSteps extends BaseSteps {

    public SearchResultsPageSteps(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPageSteps moveToFirstProductInGrid() {
        Actions action = new Actions(driver);
        action.moveToElement(onSearchResultsPage().firstItemInGrid());
        return this;
    }

    public ProductDetailsPageSteps clickOnFirstItem() {
        moveToFirstProductInGrid();
        onSearchResultsPage().moreButtonForFirstItem().should(isDisplayed()).click();
        return new ProductDetailsPageSteps(driver);
    }

    private SearchResultsPage onSearchResultsPage() {
        return on(SearchResultsPage.class);
    }
}
