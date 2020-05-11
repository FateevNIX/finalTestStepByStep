package steps;


import org.openqa.selenium.WebDriver;
import pages.HomePage;


public class HomePageSteps extends BaseSteps {


    public HomePageSteps(WebDriver driver) {
        super(driver);
    }


    private HomePage onHomePage() {
        return on(HomePage.class);
    }
}
