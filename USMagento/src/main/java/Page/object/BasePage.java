package Page.object;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import lombok.Getter;

public class BasePage
{
	@FindBy(id="search")
	private @Getter WebElement searchBar;
	
	@FindBy(id="product-addtocart-button")
	private @Getter WebElement addToCartbtn;
	
	@FindBy(xpath = "//div[@class='minicart-wrapper']/a[@class='action showcart']")
	private @Getter WebElement MycartIcon;
	
	@FindBy(xpath ="//a/span[text()='VIEW CART']")
	private @Getter WebElement ViewCartBtn;
	
	@FindBy(xpath = "//button/span[text()='Proceed to Checkout']")
	private @Getter WebElement proceedTochckBtn;
	
	@FindBy(xpath = "//dt[text()='Price']")
	private @Getter WebElement priceFilterBtn;
	
	@FindBy(xpath = "//*[@id=\"narrow-by-list\"]/dd[2]/ol/li[2]/a")
	private @Getter WebElement priceFilterValue;
	
	@FindBy(xpath = "//a[@class='logo']")
	private @Getter WebElement logo;
	
	@FindBy(xpath = "//span[@class='counter-number']")
	private @Getter WebElement Cartvalue;
	
	@FindBy(xpath = "//span[@class='counter-number']")
	private @Getter WebElement Cartvalue10;
	
	@FindBy(xpath = "(//span[text()='5'])[1]")
	private @Getter WebElement Cartvalue5;
	
	@FindBy(xpath = "//div//span[text()='Empty Cart']")
	private @Getter WebElement clearcartBtn;
	
	@FindBy(xpath = "//div/p[text()='You have no items in your shopping cart.']")
	private @Getter WebElement empyCartSuccessmsg;
	
	@FindBy(xpath = "//div[@itemprop='sku']")
	private @Getter WebElement productIsbn;
	
	@FindBy(xpath = "//h1[@class='page-title']")
	private @Getter WebElement productTitle;
	
	@FindBy(xpath =   "(//a[@title='Product Format'])[1]")
	private @Getter WebElement productFormat;
	
	@FindBy(xpath = "(//a/span[text()='Ebooks'])[1]")
	private @Getter WebElement EbookCategory;
	
	
	@FindBy(xpath = "(//a/span[text()='Books'])[1]")
	private @Getter WebElement BooksCategory;
	
	public BasePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClearCart() throws InterruptedException
	{
		
		  String val = getCartvalue().getText();
		   System.out.println("cart value "+val);
		   
		  
//		   int value = Integer.parseInt(val);
		   if (val.equalsIgnoreCase("")) 
		   {
			 System.out.println("Cart is empty ");
		   }
		   else 
		   {
//			   System.out.println(" i am in else condition");
			   getMycartIcon().click();
			   getViewCartBtn().click();
//			   Thread.sleep(3000);
			   clearcartBtn.click();
			   Assert.assertEquals(getEmpyCartSuccessmsg().getText(), "You have no items in your shopping cart.");
			}
		   
	}
	
	
}
