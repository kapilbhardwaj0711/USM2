package Page.object;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class ShoppingCartPage 
{
	@FindBy(xpath = "//td[@data-th='Subtotal']")
	private @Getter List<WebElement> subtotalitem;
	
    public ShoppingCartPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
}
