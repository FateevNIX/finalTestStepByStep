package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.BaseSteps;

public class BaseTest {
    BaseSteps steps;

    public WebDriver driver;
    public BaseSteps start() {
        return steps;
    }

    @BeforeClass
    public void setUp() {
       WebDriverManager.chromedriver().setup();
       steps = new BaseSteps(driver);
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
