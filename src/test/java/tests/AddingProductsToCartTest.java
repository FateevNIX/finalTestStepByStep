package tests;

import org.testng.annotations.Test;
import steps.HomePageSteps;


public class AddingProductsToCartTest extends BaseTest {

        @Test
        public void AddingProductsToCart () {
            HomePageSteps homePageSteps = new HomePageSteps(driver);
            homePageSteps.
                    enterProductName("text").
                    clickSubmitButton();

        }
    }