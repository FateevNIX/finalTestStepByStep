package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ShoppingCartPage;

import java.util.ArrayList;
import java.util.List;

import static matchers.HasTextMatcher.hasText;
import static matchers.IsElementDisplayedMatcher.isDisplayed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class ShoppingCartPageSteps extends BaseSteps {

    public ShoppingCartPageSteps(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductNames() {
        List<WebElement> resultList = onShoppingCartPage().productName();
        List<String> titlesOfProducts = new ArrayList<String>();
        for (WebElement resultItem : resultList) {
            titlesOfProducts.add(resultItem.getText());
        }
        return titlesOfProducts;
    }

    public List<Integer> getProductQuantity() {
        List<WebElement> resultList = onShoppingCartPage().quantityOfProduct();
        List<Integer> quantityOfProducts = new ArrayList<Integer>();
        for (WebElement resultItem : resultList) {
            quantityOfProducts.add(Integer.parseInt(resultItem.getAttribute("value")));
        }
        return quantityOfProducts;
    }

    public List<Double> getProductPrice() {
        List<WebElement> resultList = onShoppingCartPage().totalPrice();
        List<Double> productPrices = new ArrayList<Double>();
        for (WebElement resultItem : resultList) {
            productPrices.add(Double.parseDouble(resultItem.getText().replace("$", "")));
        }
        return productPrices;
    }

    public List<String> getProductSize() {
        List<WebElement> resultList = onShoppingCartPage().colourAndSize();
        List<String> sizeOfProduct = new ArrayList<String>(resultList.size());
        for (WebElement resultItem : resultList) {
            int lastChar = resultItem.getText().length() - 1;
            sizeOfProduct.add(resultItem.getText().substring(lastChar));
        }
        return sizeOfProduct;
    }

    public ShoppingCartPageSteps checkAllDataMatchPreviouslySelectedValues(List<String> productName, String[] size, int[] quantity, List<Double> productPrice) {
        int i = 0;

        while (i < getProductNames().size()) {
            assertThat(getProductNames().get(i).toLowerCase(), equalTo(productName.get(i).toLowerCase()));
            assertThat(getProductSize().get(i), equalTo(size[i]));
            assertThat(getProductQuantity().get(i), equalTo(quantity[i]));
            assertThat(getProductPrice().get(i), equalTo(productPrice.get(i)));
            i++;
        }
        return this;
    }

    public ShoppingCartPageSteps deleteFirstProductFromCart() {
        onShoppingCartPage().trashcanButton().should(isDisplayed()).click();
        return this;
    }

    public ShoppingCartPageSteps checkFirstProductWasDeleted(List<String> productsName) {
        onShoppingCartPage().shoppingCartContains().should(hasText("1 Product")); //это костыльно, но пока лучше придумать не смог
        assertThat(getProductNames().get(0).toLowerCase(), not(productsName.get(0).toLowerCase()));
        return this;
    }

    public ShoppingCartPageSteps checkSecondProductIsInList(List<String> productsName) {
        assertThat(getProductNames().get(0).toLowerCase(), equalTo(productsName.get(1).toLowerCase()));
        return this;
    }

    private ShoppingCartPage onShoppingCartPage() {
        return on(ShoppingCartPage.class);
    }
}
