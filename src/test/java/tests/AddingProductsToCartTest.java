package tests;

import org.testng.annotations.Test;
import testData.Product;

public class AddingProductsToCartTest extends BaseTest {


    @Test
    public void autoTest() {
        Product dress = new Product("Printed Dress", "M", 10, 0);
        Product blouse = new Product("blouse", "S", 1, 0);
        products.add(dress);
        products.add(blouse);

        onHomePageSteps
                .enterProductName(dress.name)
                .clickOnFirstItem()
                .selectSize(dress.size)
                .setQuantityTo(dress.quantity);

        dress.price = onProductDetailsPageSteps.getFullPriceOfProduct(dress);

        onProductDetailsPageSteps
                .clickAddToCard()
                .checkThatAllDataMatchTheSelectedValues(dress)
                .clickContinueShoppingAtPopup()
                .enterProductName(blouse.name)
                .clickOnFirstItem()
                .selectSize(blouse.size);

        blouse.price = onProductDetailsPageSteps.getFullPriceOfProduct(blouse);

        onProductDetailsPageSteps
                .clickAddToCard()
                .checkThatAllDataMatchTheSelectedValues(blouse)
                .clickContinueShoppingAtPopup()
                .clickShoppingCart()
                .checkAllDataMatchPreviouslySelectedValues(products)
                .deleteFirstProductFromCart()
                .checkFirstProductWasDeleted(products)
                .checkSecondProductIsInList(products);

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