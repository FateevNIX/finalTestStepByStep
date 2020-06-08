package steps;

import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;
import tests.HtmlElement;

import static matchers.IsElementDisplayedMatcher.isDisplayed;


public class BaseSteps {

    public WebDriver driver;

    private Atlas atlas;

    public Actions getActions() {
        return actions;
    }

    private Actions actions;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        atlas = new Atlas(new WebDriverConfiguration(driver));
        actions = new Actions(driver);

    }

    public <T extends WebPage> T on(Class<T> page) {
        return atlas.create(driver, page);
    }

    public void enterText(HtmlElement element, String text) {
        element.should(isDisplayed());
        element.clear();
        element.sendKeys(text);
    }

    public void click(HtmlElement element) {
        element.should(isDisplayed());
        element.click();
    }

    //Объеденил методы enterProductName и clickSubmitButton. Плюс вынес метод в BaseSteps поскольку его можно юзать на любой странице
    public SearchResultsPageSteps searchProductName(String text) {
        enterText(onBasePage().searchTextBox(), text);
        click(onBasePage().submitButton());
        return new SearchResultsPageSteps(driver);
    }

    private BasePage onBasePage() {
        return on(BasePage.class);
    }
}
