package steps;

import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;

import org.openqa.selenium.WebDriver;
import tests.BaseTest;


public class BaseSteps extends BaseTest {

    public WebDriver driver;

    public BaseSteps(WebDriver driver) { this.driver = driver;}
    Atlas atlas = new Atlas(new WebDriverConfiguration(driver));


    public <T extends WebPage> T on(Class<T> page) {

        return atlas.create(driver, page);
    }


}
