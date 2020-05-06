package steps;

import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;


public class BaseSteps {

    public WebDriver driver;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }

    public <T extends WebPage> T on(Class<T> page) {
        Atlas atlas = new Atlas();
        return atlas.create(driver, page);
    }

    @Step
    public HomePageSteps openHomePage() {
        HomePageSteps homePageSteps = new HomePageSteps(driver);
        driver.get(homePageSteps.getHomePageURL());
       
        return homePageSteps;
    }
    @Step
    public SearchResultsPageSteps openSearchResultsPage() {
        SearchResultsPageSteps searchResultsPageSteps = new SearchResultsPageSteps(driver);
        driver.get(searchResultsPageSteps.getSearchResultsPageURL());
        return searchResultsPageSteps;
    }

}
