package Page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class MyAccountPage 
{
  @FindBy(linkText = "Manage Addresses")
  private @Getter WebElement mangeAcBtn;
  
  @FindBy(xpath="//a[text()='E-alerts Subscriptions']")
  private @Getter WebElement eAlertlink;
  
  @FindBy(xpath="//input[@id='subscription']")
private @Getter WebElement firstSubsBox;
  
  @FindBy(xpath="//input[@id='receive_partner_offer']")
  private @Getter WebElement secondSubsBox;
  
  @FindBy (xpath="//span[text()='Save']")
  private @Getter WebElement saveBtn;
  public MyAccountPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
	  
  }
}
