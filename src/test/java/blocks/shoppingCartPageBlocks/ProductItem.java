package blocks.shoppingCartPageBlocks;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import tests.HtmlElement;

public interface ProductItem extends AtlasWebElement<ProductItem> {

    @FindBy(".//i[@class='icon-trash']")
    ElementsCollection<HtmlElement> deleteIcon();

    @FindBy(".//input[contains(@class, 'cart_quantity_input')]")
    ElementsCollection<HtmlElement> quantityOfProduct();

    @FindBy(".//span[contains(@id, 'total_product_price')]")
    ElementsCollection<HtmlElement> price();

    @FindBy(".//td[@class='cart_description']")
    ElementsCollection<Description> description();
}
