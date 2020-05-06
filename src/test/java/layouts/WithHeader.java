package layouts;

import io.qameta.atlas.webdriver.extension.FindBy;
import tests.HtmlElement;

public interface WithHeader {
    @FindBy("id('search_query_top')")
    HtmlElement searchTextBox();
    @FindBy("id('searchbox')/button")
    HtmlElement submitButton();
}
