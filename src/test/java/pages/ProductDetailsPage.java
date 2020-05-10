package pages;


import io.qameta.atlas.webdriver.extension.FindBy;
import tests.HtmlElement;


public interface ProductDetailsPage extends BasePage {
    @FindBy("//p[@id='add_to_cart']")
    HtmlElement addToCartButton();

    @FindBy("//select[@id='group_1']/option[1]")
    HtmlElement selectSizeS();

    @FindBy("//select[@id='group_1']/option[2]")
    HtmlElement selectSizeM();

    @FindBy("//select[@id='group_1']/option[3]")
    HtmlElement selectSizeL();

    @FindBy("//input[@id='quantity_wanted']")
    HtmlElement quantityTextBox();

    @FindBy("//span[@id='layer_cart_product_title']")
    HtmlElement productNameAtPopup();

    @FindBy("//span[@id='layer_cart_product_attributes']")
    HtmlElement colourAndSizeAtPopup();

    @FindBy("//span[@id='layer_cart_product_quantity']")
    HtmlElement quantityAtPopup();

    @FindBy("//span[@class='continue btn btn-default button exclusive-medium']")
    HtmlElement continueShoppingButton();

    @FindBy("//span[@id='our_price_display']")
    HtmlElement priceOnPage();

    @FindBy("//span[@id='layer_cart_product_price']")
    HtmlElement priceOnPopup();

    @FindBy("//div[@class='shopping_cart']/a")
    HtmlElement shoppingCartIcon();
}
