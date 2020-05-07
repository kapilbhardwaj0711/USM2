package Page.object;

import java.awt.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class SearchResultPage 
{
  @FindBy(xpath = "//div[@class='products wrapper grid products-grid']//a")
  private @Getter WebElement FirstProductOnSearch;
  
  @FindBy(xpath = "//span[text()='Add to Cart']")
  private java.util.List<WebElement>numberofbooks;
  
  
  public SearchResultPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
}
