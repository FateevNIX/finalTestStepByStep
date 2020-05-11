package pages;

import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.WebElement;
import tests.HtmlElement;

public interface ShoppingCartPage extends BasePage{
    @FindBy("//span[contains(@id, 'total_product_price')]")
    ElementsCollection<WebElement> totalPrice();

    @FindBy("//td/p[@class='product-name']/a")
    ElementsCollection<WebElement> productName();

    @FindBy("//input[@class='cart_quantity_input form-control grey']")
    ElementsCollection<WebElement> quantityOfProduct();

    @FindBy("//td[@class='cart_description']/small/a")
    ElementsCollection<WebElement> colourAndSize();

    @FindBy("//i[@class='icon-trash']")
    HtmlElement trashcanButton();

    @FindBy("//span[@id='summary_products_quantity']")
    HtmlElement shoppingCartContains();
}
