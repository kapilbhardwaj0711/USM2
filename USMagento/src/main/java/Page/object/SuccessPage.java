package Page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class SuccessPage {
	
	
	@FindBy(xpath="//a[@class='order-number']")
	private @Getter WebElement orderno;
	
	@FindBy(xpath="//a[text()='My Orders']")
	private @Getter WebElement myOrderlink;
	
	public SuccessPage(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }

}
