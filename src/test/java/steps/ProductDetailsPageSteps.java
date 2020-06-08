package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ProductDetailsPage;
import testData.Product;

import java.util.Arrays;

import static matchers.IsElementDisplayedMatcher.isDisplayed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.stringContainsInOrder;

public class ProductDetailsPageSteps extends BaseSteps {
    public ProductDetailsPageSteps(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPageSteps selectSize(String size) {
        click(onProductDetailsPage().selectSize(size).should(isDisplayed()));
        return this;
    }

    public ProductDetailsPageSteps setQuantityTo(int quantity) {
        enterText(onProductDetailsPage().quantityTextBox(), (String.valueOf(quantity)));
        return this;
    }

    public ProductDetailsPageSteps clickAddToCard() {
        click(onProductDetailsPage().addToCartButton());
        return this;
    }

    public ProductDetailsPageSteps clickContinueShoppingAtPopup() {
        click(onProductDetailsPage().continueShoppingButton());
        return this;
    }

    public String getProductName() {
        return onProductDetailsPage().productNameAtPopup().should(isDisplayed()).getText();
    }

    public int getQuantityAtPopup() {
        return Integer.parseInt(onProductDetailsPage().quantityAtPopup().should(isDisplayed()).getText());
    }

    public String getSizeAtPopup() {
        String colourAndSizeText = onProductDetailsPage().colourAndSizeAtPopup().should(isDisplayed()).getText();
        return colourAndSizeText.substring(colourAndSizeText.length() - 1); //в строке находится цвет и размер. Я забираю только размер
    }

    //тут можно бы принимать на входе просто Double, но в тесте тогда сюда передается quantity, и может путать. Так красивей.
    public double getFullPriceOfProduct(Product product) {
        return product.quantity * (Double.parseDouble(onProductDetailsPage().priceOnPage().getText().replace("$", "")));
    }

    public double getPriceAtPopup() {
        return Double.parseDouble(onProductDetailsPage().priceOnPopup().getText().replace("$", ""));
    }

    public ProductDetailsPageSteps checkThatAllDataMatchTheSelectedValues(Product product) {
        assertThat(getProductName().toLowerCase(), stringContainsInOrder(Arrays.asList(product.name.toLowerCase().split(" "))));
        assertThat(getQuantityAtPopup(), equalTo(product.quantity));
        assertThat(String.valueOf(getSizeAtPopup()), equalTo(product.size));
        assertThat(getPriceAtPopup(), equalTo(product.price));
        return this;
    }

    public ShoppingCartPageSteps clickShoppingCart() {
        click(onProductDetailsPage().shoppingCartIcon());
        return new ShoppingCartPageSteps(driver);
    }

    private ProductDetailsPage onProductDetailsPage() {
        return on(ProductDetailsPage.class);
    }
}