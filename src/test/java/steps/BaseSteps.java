package steps;

import io.qameta.atlas.core.Atlas;

import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;

import org.openqa.selenium.WebDriver;


public class BaseSteps {

    public WebDriver driver;

    private Atlas atlas;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        atlas = new Atlas(new WebDriverConfiguration(driver));
    }

    public <T extends WebPage> T on(Class<T> page) {

        return atlas.create(driver, page);
    }


}
