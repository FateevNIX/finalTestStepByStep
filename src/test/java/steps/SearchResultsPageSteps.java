package steps;

import org.openqa.selenium.WebDriver;
import pages.SearchResultsPage;
import tests.HtmlElement;

import static matchers.IsElementDisplayedMatcher.isDisplayed;

public class SearchResultsPageSteps extends BaseSteps {

    public SearchResultsPageSteps(WebDriver driver) {
        super(driver);
    }

    //объеденил с методом clickOnFirstItem поскольку больше нигде не использовался
  /*  public SearchResultsPageSteps moveToFirstProductInGrid() {
        getActions().moveToElement(onSearchResultsPage().firstItemInGrid());
        return this;
    }*/

  //Можно переделать, чтоб на любой элемент клацнуть можно, но в задании говорится что нужно именно по первому
    public ProductDetailsPageSteps clickOnFirstItem() {
        HtmlElement firstItemInGrid = onSearchResultsPage().productsList().moreButton().get(0).should(isDisplayed());
        getActions().moveToElement(firstItemInGrid);
        click(firstItemInGrid);
        return new ProductDetailsPageSteps(driver);
    }

    private SearchResultsPage onSearchResultsPage() {
        return on(SearchResultsPage.class);
    }
}
