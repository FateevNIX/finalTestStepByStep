package tests;

import org.testng.annotations.Test;


public class AddingProductsToCartTest extends BaseTest {

        @Test
        public void AddingProductsToCart () {

            start()
                    .openHomePage()
                    .enterProductName("text")
                    .clickSubmitButton();

        }
    }