package layouts;



import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import tests.HtmlElement;


public interface WithHeader   {
    @FindBy("//input[@id='search_query_top']")
    HtmlElement searchTextBox();

    @FindBy("//button[@name='submit_search']")
    HtmlElement submitButton();
}
