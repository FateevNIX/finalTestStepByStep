package steps;


import io.qameta.allure.Step;
import io.qameta.atlas.webdriver.AtlasWebElement;
import org.openqa.selenium.WebDriver;
import pages.HomePage;


import static matchers.IsElementDisplayedMatcher.isDisplayed;


public class HomePageSteps extends BaseSteps {
    public String homePageURL = ("http://automationpractice.com");

    public HomePageSteps(WebDriver driver){
       super (driver);
    }

    public String getHomePageURL(){
        return homePageURL;
    }

    @Step
    public HomePageSteps enterProductName(String text){
        AtlasWebElement searchTextBox = onHomePage().searchTextBox().should(isDisplayed());
        searchTextBox.clear();
        searchTextBox.sendKeys(text);
        return this;
    }

    @Step
    public SearchResultsPageSteps clickSubmitButton(){
        onHomePage().submitButton().click();
        return new SearchResultsPageSteps(driver);
    }
    private HomePage onHomePage() { return on(HomePage.class);
    }
}
