package pages;

import blocks.shoppingCartPageBlocks.ProductItem;
import io.qameta.atlas.webdriver.extension.FindBy;
import tests.HtmlElement;

public interface ShoppingCartPage extends BasePage{

    @FindBy(".//div[@id='order-detail-content']")
    ProductItem products();
}
