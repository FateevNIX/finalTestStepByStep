package pages;


import io.qameta.atlas.webdriver.extension.FindBy;
import tests.HtmlElement;

public interface SearchResultsPage extends BasePage {
    
    @FindBy("//a[@class='quick-view']")
    HtmlElement firstItemInGrid();
    @FindBy("//a[@class='button lnk_view btn btn-default']")
    HtmlElement moreButtonForFirstItem();

}
