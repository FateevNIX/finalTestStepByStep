package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ProductDetailsPage;

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
        if (size == "S") {
            onProductDetailsPage().selectSizeS().should(isDisplayed()).click();
        } else if (size == "M") {
            onProductDetailsPage().selectSizeM().should(isDisplayed()).click();
        } else if (size == "L") {
            onProductDetailsPage().selectSizeL().should(isDisplayed()).click();
        }
        return this;
    }

    public ProductDetailsPageSteps setQuantityTo(String quantity) {

        onProductDetailsPage().quantityTextBox().clear();
        onProductDetailsPage().quantityTextBox().sendKeys(quantity);
        return this;
    }

    public ProductDetailsPageSteps clickAddToCard() {
        onProductDetailsPage().addToCartButton().click();
        return this;
    }

    public ProductDetailsPageSteps clickContinueShoppingAtPopup() {
        onProductDetailsPage().continueShoppingButton().should(isDisplayed()).click();
        return this;
    }

    public String getProductName() {
        return onProductDetailsPage().productNameAtPopup().should(isDisplayed()).getText();
    }

    public int getQuantityAtPopup() {
        int quantityOnPopup = Integer.parseInt(onProductDetailsPage().quantityAtPopup().getText());
        return quantityOnPopup;
    }

    public char getSizeAtPopup() {
        WebElement elem = onProductDetailsPage().colourAndSizeAtPopup();
        int lastChar = elem.getText().length() - 1;
        char size = elem.getText().charAt(lastChar); //в строке находится цвет и размер. Я забираю только размер
        return size;
    }

    public double getPriceAtPage() {
        double priceAtPage = Double.parseDouble(onProductDetailsPage().priceOnPage().getText().replace("$", ""));
        return priceAtPage;
    }

    public double getPriceAtPopup() {
        double priceAtPopup = Double.parseDouble(onProductDetailsPage().priceOnPopup().getText().replace("$", ""));
        return priceAtPopup;
    }

    public ProductDetailsPageSteps checkThatAllDataMatchTheSelectedValues(String productName, int quantity, String size) {
        assertThat(getProductName().toLowerCase(), stringContainsInOrder(Arrays.asList(productName.toLowerCase().split(" "))));
        assertThat(getQuantityAtPopup(), equalTo(quantity));
        assertThat(String.valueOf(getSizeAtPopup()), equalTo(size));
        double totalPrice = getPriceAtPage() * quantity; //сумма в попапе равняется сумме на странице умноженной на количество товара
        assertThat(getPriceAtPopup(), equalTo(totalPrice));
        return this;
    }

    public ProductDetailsPageSteps enterProductName(String text) {
        onProductDetailsPage().searchTextBox().should(isDisplayed()).clear();
        onProductDetailsPage().searchTextBox().sendKeys(text);
        return this;
    }

    public SearchResultsPageSteps clickSubmitButton() {
        onProductDetailsPage().submitButton().click();
        return new SearchResultsPageSteps(driver);
    }

    public ShoppingCartPageSteps clickShoppingCart() {
        onProductDetailsPage().shoppingCartIcon().click();
        return new ShoppingCartPageSteps(driver);
    }

    private ProductDetailsPage onProductDetailsPage() {
        return on(ProductDetailsPage.class);
    }
}