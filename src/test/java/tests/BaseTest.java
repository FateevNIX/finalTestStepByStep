package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import steps.HomePageSteps;
import steps.ProductDetailsPageSteps;
import testData.Product;
import java.util.ArrayList;
import java.util.List;


public class BaseTest {
    public String baseURL = ("http://automationpractice.com");
    public WebDriver driver;
    List<Product> products = new ArrayList<>();
    HomePageSteps onHomePageSteps;
    ProductDetailsPageSteps onProductDetailsPageSteps;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseURL);
        onHomePageSteps = new HomePageSteps(driver);
        onProductDetailsPageSteps = new ProductDetailsPageSteps(driver);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
