package steps;

import org.openqa.selenium.WebDriver;
import pages.ShoppingCartPage;
import testData.Product;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ShoppingCartPageSteps extends BaseSteps {

    public ShoppingCartPageSteps(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductNames() {
        return onShoppingCartPage().products().description()
                .extract(description -> description.productName().getText());
    }

    public List<Integer> getProductQuantity() {
        return onShoppingCartPage().products().quantityOfProduct()
                .extract(quantity -> Integer.parseInt(quantity.getAttribute("value")));
    }

    public List<Double> getProductPrice() {
        return onShoppingCartPage().products().price()
                .extract(prices -> Double.parseDouble(prices.getText().replace("$", "")));
    }

    public List<String> getProductSize() {
        return onShoppingCartPage().products().description()
                .extract(description -> description.colourAndSize().getText()
                        .substring(description.colourAndSize().getText().length() - 1));
    }

    public ShoppingCartPageSteps checkAllDataMatchPreviouslySelectedValues(List<Product> products) {
        for (int i = 0; i < getProductNames().size(); i++) {
            assertThat(getProductNames().get(i).toLowerCase(), stringContainsInOrder(Arrays.asList(products.get(i).name.toLowerCase().split(" "))));
            assertThat(getProductSize().get(i), equalTo(products.get(i).size));
            assertThat(getProductQuantity().get(i), equalTo(products.get(i).quantity));
            assertThat(getProductPrice().get(i), equalTo(products.get(i).price));
        }
        return this;
    }

    public ShoppingCartPageSteps deleteFirstProductFromCart() {
        click(onShoppingCartPage().products().deleteIcon().get(0));
        return this;
    }

    public ShoppingCartPageSteps checkFirstProductWasDeleted(List<Product> products) {
        onShoppingCartPage().products().description().should(hasSize(1));//проверка что юайка успешно обновилось и продукт уже исчез
        assertThat(getProductNames().get(0).toLowerCase(), not(products.get(0).name.toLowerCase())); //проверка что именно первый продукт был удален
        return this;
    }

    public ShoppingCartPageSteps checkSecondProductIsInList(List<Product> products) {
        assertThat(getProductNames().get(0).toLowerCase(), equalTo(products.get(1).name.toLowerCase()));
        return this;
    }

    private ShoppingCartPage onShoppingCartPage() {
        return on(ShoppingCartPage.class);
    }
}
