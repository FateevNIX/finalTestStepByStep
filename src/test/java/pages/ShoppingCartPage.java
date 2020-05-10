package pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import tests.HtmlElement;

public interface ShoppingCartPage extends BasePage {
    @FindBy("//span[contains(@id, 'total_product_price')]")
    HtmlElement totalPrice();

    @FindBy("//p[@class='product-name']/a")
    HtmlElement productName();

    @FindBy("//input[@class='cart_quantity_input form-control grey']")
    HtmlElement quantityOfProduct();

    @FindBy("//td[@class='cart_description']/small/a")
    HtmlElement colourAndSize();

    @FindBy("//i[@class='icon-trash']")
    HtmlElement trashcanButton();
}
