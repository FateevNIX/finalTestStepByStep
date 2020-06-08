package blocks.shoppingCartPageBlocks;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import tests.HtmlElement;

public interface Description extends AtlasWebElement<Description> {

    @FindBy("./p/a")
    HtmlElement productName();

    @FindBy("./small/a")
    HtmlElement colourAndSize();
}
