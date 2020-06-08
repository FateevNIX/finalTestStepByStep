package pages;


import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import tests.HtmlElement;


public interface ProductDetailsPage extends BasePage {
    @FindBy("//p[@id='add_to_cart']")
    HtmlElement addToCartButton();

    @FindBy("//option[contains(@title, '{{ size }}')]")
    HtmlElement selectSize(@Param("size") String size);

    @FindBy("//input[@id='quantity_wanted']")
    HtmlElement quantityTextBox();

    @FindBy("//span[@id='layer_cart_product_title']")
    HtmlElement productNameAtPopup();

    @FindBy("//span[@id='layer_cart_product_attributes']")
    HtmlElement colourAndSizeAtPopup();

    @FindBy("//span[@id='layer_cart_product_quantity']")
    HtmlElement quantityAtPopup();

    @FindBy("//span[contains(@class, 'continue')]")
    HtmlElement continueShoppingButton();

    @FindBy("//span[@id='our_price_display']")
    HtmlElement priceOnPage();

    @FindBy("//span[@id='layer_cart_product_price']")
    HtmlElement priceOnPopup();

    @FindBy("//div[@class='shopping_cart']/a")
    HtmlElement shoppingCartIcon();
}
