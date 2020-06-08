package blocks.searchResultspageBlocks;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import tests.HtmlElement;

public interface ProductsList extends AtlasWebElement<ProductsList> {

    @FindBy(".//a[contains(@class, 'lnk_view')]")
    ElementsCollection<HtmlElement> moreButton();
}
