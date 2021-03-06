package feature;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Page.object.BasePage;
import Page.object.HomePage;

public class Utility 
{
	WebDriver driver;
	BasePage bp;
	WebDriverWait wait;
	HomePage hp;
    public Utility(WebDriver driver)
    {
    	this.driver=driver;
    	bp = new BasePage(driver);
    	wait=new WebDriverWait(driver, 20);
    	hp=new HomePage(driver);
    }
    public void searchFuc(String product) throws InterruptedException
    {
    	hp.getStoreLogo().click();
    	Thread.sleep(1000);
    	bp.getSearchBar().sendKeys(product,Keys.ENTER);
    	
    	List<WebElement> links = driver.findElements(By.xpath("//a"));
    	
    	Iterator<WebElement> itr = links.iterator();
    	
    	
    	while (itr.hasNext()) 
    	{
    		WebElement value = itr.next();
    		if (value.getText().contains(product)) 
			{
				value.click();
				break;
			}
			
		}
    	
    }
    public void clearCart()
    {
    	
    	try 
    	{
    	if (bp.getNullValue().getText()=="0") 
    	{
			System.out.println("value is 0 ");
		}
    	else 
    	{
    		   WebDriverWait wait = new WebDriverWait(driver, 10);
    	    //	wait.until(ExpectedConditions.visibilityOf(bp.getCartvalue()));
    	    	bp.getCartvalue();
    	    		
    			bp.getMycartIcon().click();
    		   	wait.until(ExpectedConditions.visibilityOf(bp.getViewCartBtn()));
    		   	bp.getViewCartBtn().click();
    		   	wait.until(ExpectedConditions.visibilityOf(bp.getProceedTochckBtn()));
    			bp.getClearcartBtn().click();
    		  Assert.assertEquals(bp.getEmpyCartSuccessmsg().getText(), "You have no items in your shopping cart.");
    		  		
		}
		} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    	}
    	
		
		
    }
    
    public void CartCount() throws InterruptedException
    {
    	String value = driver.findElement(By.xpath("//span[text()='0']")).getText();
    	if (value=="0") 
    	{
			System.out.println("Cart value is 0 wait for 5 more second");
			Thread.sleep(5000);
		}
    }
    
    public double Discount(double baseAmount,int discount)
    {
		double afterDiscount = baseAmount - (baseAmount * discount / 100);
		System.out.println("After discount your bill is: " + afterDiscount);
		return afterDiscount;
    }
    
    public int isbn(int isbn)
    {
    	
    	return isbn;
    }
    public String trncString(String product)
    {
    	String newActual = product.substring(0, 7);
    	return newActual;
    }
    
    public void customSearchProduct(String product) throws InterruptedException {
    	bp.getSearchBar().sendKeys(product,Keys.ENTER);
    	
  	  	Thread.sleep(3000);
  	  JavascriptExecutor jre = (JavascriptExecutor)driver;
  	   jre.executeScript("window.scrollBy(0,400)");
  	   
  	 List<WebElement> links = driver.findElements(By.xpath("//a"));
 	
 	Iterator<WebElement> itr = links.iterator();
 	
 	
 	while (itr.hasNext()) 
 	{
 		WebElement value = itr.next();
 		if (value.getText().equals(product)) 
			{
				value.click();
				break;
			}
			
		}
  	   Thread.sleep(10000);
  	   bp.getAddToCartbtn().click();
  	 
	   jre.executeScript("window.scrollBy(0,-400)");
	   bp.getSearchBar().clear();
  	   
  	   Thread.sleep(10000);
    }
    
    
    
}
