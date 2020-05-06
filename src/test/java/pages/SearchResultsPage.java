package pages;


import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import tests.HtmlElement;

public interface SearchResultsPage extends WebPage {
    
    @FindBy("#center_column > ul > li:nth-child(1)")
    HtmlElement firstItemInGrid();
    @FindBy("li:nth-child(1) * a.button.lnk_view.btn.btn-default")
    HtmlElement moreButtonForFirstItem();

}
