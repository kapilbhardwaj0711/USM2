package Page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class HomePage 
{
  @FindBy(xpath = "(//a[@class='ammenu-link -main -parent                           '])[1]")
  private @Getter WebElement subjectBtn;
  
  @FindBy(xpath="(//a[@title='Medicine'])[1]")
  private @Getter WebElement medicineBtn;
  		
  @FindBy(xpath="//a[@class='logo']")
private @Getter WebElement storeLogo;
  
  @FindBy(xpath = "//a[@title='Anatomy' ]/span[1]")
  private @Getter WebElement anatomyBtn;
  
  @FindBy(linkText = "e-Books")
  private @Getter WebElement ebooksbtn;
  
  @FindBy(xpath="//span[@class='logged-in']")
  private @Getter WebElement UserIcon;
  
  @FindBy(xpath="//a[contains(text(),'Log Out')]")
  private @Getter WebElement logOutBtm;
  
  
  @FindBy (xpath="(//a[@data-action=\"add-to-wishlist\"])[1]")
  private @Getter WebElement wishlistItem;
  
  public HomePage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
}
