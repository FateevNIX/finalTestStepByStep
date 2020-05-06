package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SearchResultsPage;
import pages.ShoppingCartPage;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.stringContainsInOrder;

public class ProductDetailsPageSteps {
    /*WebDriver driver;
    public ProductDetailsPageSteps(WebDriver driver) {
        this.driver = driver;
    }

    public ProductDetailsPage selectSize(char size) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(selectSizeM));
        if (size == 'S') {
            driver.findElement(selectSizeS).click();
        } else if (size == 'M') {
            driver.findElement(selectSizeM).click();
        } else if (size == 'L') {
            driver.findElement(selectSizeL).click();
        }
        return this;
    }

    public ProductDetailsPage setQuantityTo(String quantity) {

        driver.findElement(quantityTextBox).clear();
        driver.findElement(quantityTextBox).sendKeys(quantity);
        return this;
    }

    public ProductDetailsPage clickAddToCard() {
        addToCartButton);
        return this;
    }

    public ProductDetailsPage clickContinueShoppingAtPopup() {
        driver.findElement(continueShoppingButton).click();
        return this;
    }

    public String getProductName() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productNameAtPopup));
        return driver.findElement(productNameAtPopup).getText();
    }

    public int getQuantityAtPopup() {
        int quantityOnPopup = Integer.parseInt(driver.findElement(quantityAtPopup).getText());
        return quantityOnPopup;
    }

    public char getSizeAtPopup() {
        WebElement elem = driver.findElement(colourAndSizeAtPopup);
        int lastChar = elem.getText().length() - 1;
        char size = elem.getText().charAt(lastChar); //в строке находится цвет и размер. Я забираю только размер
        return size;
    }

    public double getPriceAtPage() {
        double priceAtPage = Double.parseDouble(driver.findElement(priceOnPage).getText().replace("$", ""));
        return priceAtPage;
    }

    public double getPriceAtPopup() {
        double priceAtPopup = Double.parseDouble(driver.findElement(priceOnPopup).getText().replace("$", ""));
        return priceAtPopup;
    }

    public ProductDetailsPage checkThatAllDataMatchTheSelectedValues(String productName, int quantity, char size) {

        assertThat(getProductName().toLowerCase(), stringContainsInOrder(Arrays.asList(productName.toLowerCase().split(" "))));
        assertThat(getQuantityAtPopup(), equalTo(quantity));
        assertThat(getSizeAtPopup(),equalTo(size));
        double totalPrice = getPriceAtPage() * quantity; //сумма в попапе равняется сумме на странице умноженной на количество товара
        assertThat(getPriceAtPopup(), equalTo(totalPrice));
        return this;
    }

    public ProductDetailsPage enterProductName(String text) {
        driver.findElement(searchTextBox).clear(); //текст остается в строке поиска, потому добавлена эта строка для очистки поля перед вводом
        driver.findElement(searchTextBox).sendKeys(text);
        return this;
    }

    public SearchResultsPage clickSubmitButton() {
        driver.findElement(submitButton).click();
        return new SearchResultsPage();
    }

    public ShoppingCartPage clickShoppingCart(){
        driver.findElement(shoppingCartIcon).click();
        return new ShoppingCartPage();
    }
    private ProductDetailsPage onProductDetailsPage(){return on(ProductDetailsPage.class);*/
}
