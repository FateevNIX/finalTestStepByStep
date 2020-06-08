package pages;


import blocks.searchResultspageBlocks.ProductsList;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface SearchResultsPage extends BasePage {

    @FindBy("//ul[contains(@class, 'product_list')]")
    ProductsList productsList();


}
