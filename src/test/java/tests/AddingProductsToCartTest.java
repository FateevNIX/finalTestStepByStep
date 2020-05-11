package tests;

import org.testng.annotations.Test;
import steps.ProductDetailsPageSteps;

import java.util.ArrayList;
import java.util.List;


public class AddingProductsToCartTest extends BaseTest {


    @Test
    public void autoTest() {
        List<String> allProductNames = new ArrayList<String>();
        List<Double> allPricseAtPopup = new ArrayList<Double>();
        String searchDress = "Printed Dress", searchBlouse = "blouse";
        int[] quantity = {10, 1};
        String[] size = {"M", "S"};
        ProductDetailsPageSteps productDetailsPageSteps = new ProductDetailsPageSteps(driver);

        productDetailsPageSteps
                .enterProductName(searchDress)
                .clickSubmitButton()
                .clickOnFirstItem()
                .selectSize(size[0])
                .setQuantityTo(String.valueOf(quantity[0]))
                .clickAddToCard()
                .checkThatAllDataMatchTheSelectedValues(searchDress, quantity[0], size[0]);

        allProductNames.add(productDetailsPageSteps.getProductName());
        allPricseAtPopup.add(productDetailsPageSteps.getPriceAtPopup());

        productDetailsPageSteps
                .clickContinueShoppingAtPopup()
                .enterProductName(searchBlouse)
                .clickSubmitButton()
                .clickOnFirstItem()
                .selectSize(size[1])
                .clickAddToCard()
                .checkThatAllDataMatchTheSelectedValues(searchBlouse, quantity[1], size[1]);

        allProductNames.add(productDetailsPageSteps.getProductName());
        allPricseAtPopup.add(productDetailsPageSteps.getPriceAtPopup());

        productDetailsPageSteps
                .clickContinueShoppingAtPopup()
                .clickShoppingCart()
                .checkAllDataMatchPreviouslySelectedValues(allProductNames, size, quantity, allPricseAtPopup)
                .deleteFirstProductFromCart()
                .checkFirstProductWasDeleted(allProductNames)
                .checkSecondProductIsInList(allProductNames);

    }
}

        /*    1. Open home page
            2. Search for the "Printed Dress"
            3. Select first result
            4. Select size M
            5. Select quantity 10
            6. Click add to card
            7. On popup verify that all data match the selected values and total price is correct
            8. Continue shopping
            9. Search for blouse
            10. Select size S
            11. Click add to card
            12. On popup verify that all data match the selected values and total price is correct
            13. Continue shopping
            14. Open shopping card
            15. Verify that shopping card contains both products with correct data
            16. Remove Printed Dress
            17. Verify that product has been removed and the second product still displayed on the card*/