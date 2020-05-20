package Page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class CheckoutPage {
	
	@FindBy(xpath = "//div[@id='shipping-method-buttons-container']//button[@class='button action continue primary']")
	private @Getter WebElement NextBtn;
   
    @FindBy(id="agreement_checkmo_1")
    private @Getter WebElement agreementCheckbx;
   
    @FindBy(xpath = "//span[text()='Proceed to Pay']")
    private @Getter WebElement ProceedBtn;
   
    public CheckoutPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

}
