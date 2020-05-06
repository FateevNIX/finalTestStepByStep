package pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.By;


import javax.xml.soap.Text;

public interface ShoppingCartPage extends BasePage {
    By totalPrice = By.xpath("//span[contains(@id, 'total_product_price')]");
    @FindBy("//td[2]/p/a")
    Text productName();
    By quantityOfProduct = By.xpath("//td[5]/input[2]");
    By colourAndSize = By.xpath("//small[2]/a");
    By trashcanButton = By.xpath("//a[@class='cart_quantity_delete']/i");
}
