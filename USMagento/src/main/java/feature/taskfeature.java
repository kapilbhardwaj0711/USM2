package feature;
import static org.testng.Assert.assertEquals;

import java.text.DecimalFormat;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import Page.object.AddNewAddressPage;
import Page.object.AddressBookPage;
import Page.object.BasePage;
import Page.object.CheckoutPage;
import Page.object.CreateNewCustomerAccountPage;
import Page.object.EditAddressPage;
import Page.object.ForgetPasswordPage;
import Page.object.GuestUserCheckOutPage;
import Page.object.HomePage;
import Page.object.LoginPage;
import Page.object.MedicinePage;
import Page.object.MyAccountPage;
import Page.object.SearchResultPage;
import Page.object.ShoppingCartPage;
import Page.object.SuccessPage;



public class taskfeature 
{
   WebDriver driver;
   CheckoutPage cp;
   Actions action;
   LoginPage lp;
   CreateNewCustomerAccountPage cca;
   BasePage bp;
   MyAccountPage mac;
   EditAddressPage eap;
   AddressBookPage abp;
   AddNewAddressPage anap;
   GuestUserCheckOutPage gucp;
   HomePage hp;
   MedicinePage mp;
   Utility tm;
   SearchResultPage srp;
   ForgetPasswordPage fpp;
   JavascriptExecutor jre;
   WebDriverWait wait;
   ShoppingCartPage scp;
   SuccessPage sp;
   static String orderno;
   public taskfeature(WebDriver driver)
   {
	   this.driver=driver;
	   lp= new LoginPage(driver);
	   cca= new CreateNewCustomerAccountPage(driver);
	   bp= new BasePage(driver);
	   mac= new MyAccountPage(driver);
	   eap= new EditAddressPage(driver);
	   anap = new AddNewAddressPage(driver);
	   gucp= new GuestUserCheckOutPage(driver);
	   hp= new HomePage(driver);
	   mp= new MedicinePage(driver);
	   tm = new Utility(driver);
	   srp=new SearchResultPage(driver);
	   fpp= new ForgetPasswordPage(driver);
	   wait= new WebDriverWait(driver, 20);
	   action=new Actions(driver);
	   cp=new CheckoutPage(driver);
	   scp=new ShoppingCartPage(driver);
	   sp=new SuccessPage(driver);
   }
   
   public void ValidLogin(String username , String password) throws Exception
   {
	   
	// lp.getUsricon().click();
	   lp.getLoginBtn().click();
//	   Thread.sleep(2000);
	   lp.getUntxtb().sendKeys(username);
	   lp.getPwdtxtbx().sendKeys(password,Keys.ENTER);
//	   lp.getLoginBtn().click();
//	  Thread.sleep(2000);
	  String expected="My Account | US Elsevier Health";
	  Assert.assertEquals(driver.getTitle(), expected);
//	  Reporter.log(expected,true);
	  
   }
   public void invalidLogin(String username1,String password1) throws Exception
   {
//	   lp.getUsrico().click();
	   lp.getLoginBtn().click();
//	   Thread.sleep(2000);
	   lp.getUntxtb().sendKeys(username1);
	   lp.getPwdtxtbx().sendKeys(password1,Keys.ENTER);
// lp.getLoginBtn().click();
//	   Thread.sleep(2000);
	   Thread.sleep(5000);
	   String errorMsgxpth="//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']";
	   String expected="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
	   Thread.sleep(5000);
	   Assert.assertEquals(driver.findElement(By.xpath(errorMsgxpth)).getText(), expected);
   }
   public void CreateCust(String firstname ,String lastname,String emailaddess,String passwrd,String cpasswrd,String dateNbirth,String telephone) throws InterruptedException
   {
//	  lp.getUsrico().click();
	  lp.getCreateAc().click();
	  
	  JavascriptExecutor je = (JavascriptExecutor)driver;
	  je.executeScript("window.scrollBy(0,500)");
	 
 	  Select title = new Select(cca.getTitle());
	  title.selectByIndex(3);
	  
	  cca.getFname().sendKeys(firstname);
 	  cca.getLname().sendKeys(lastname);
 	  
 	  Select sel = new Select(cca.getProfsDrpDwn());
 	  sel.selectByIndex(3);
 	  
 	  Select sel1 = new Select(cca.getProfsSubDrpDwn());
 	  sel1.selectByIndex(4);
 	 
 	  Random randomGenerator = new Random();
 	 int randomInt = randomGenerator. nextInt(1000);
 	  
 	  cca.getEmail().sendKeys(firstname+randomInt+"@gmail.com");
 	  cca.getConfEmail().sendKeys(firstname+randomInt+"@gmail.com");
 	  Thread.sleep(20000);
 	  cca.getPwd().sendKeys(passwrd);
 	  cca.getCpwd().sendKeys(cpasswrd);
 	  cca.getChckbx().click();

 	  /*	  cca.getDobIcon().click();
 	  Select sel0 = new Select(cca.getDobYear());
	  sel0.selectByValue("1990");
	  
	  Select sel01 = new Select(cca.getDobMonth());
	  sel01.selectByValue("11");
	  Thread.sleep(1000);
	  
	  cca.getDobDate().click();
	  cca.getTelephone().sendKeys(telephone);
*/ 	  
 
	  
/*
 	  cca.getRegistrBtn().click();
 	  Thread.sleep(5000);
 	  String expected ="Thank you for registering with Elsevier Asia Bookstore.";
 	  Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Thank you for registering with Elsevier Asia Bookstore.']")).getText(), expected);
*/	  
   }
   public void ValidUserproductPurchase(String username,String password,String product) throws Exception
   {

	   ValidLogin(username, password);
       JavascriptExecutor jre = (JavascriptExecutor)driver;
//  jre.executeScript("window.scrollBy(0,-100)");
 
         Thread.sleep(3000);
         tm.clearCart();
         tm.searchFuc(product);
//         srp.getFirstProductOnSearch().click();
//         String title = bp.getProductTitle().getText();
//      String expected = tm.trncString(bp.getProductTitle().getText());
//      String actual = tm.trncString(product);
     Assert.assertTrue(bp.getProductTitle().getText().contains(product));
//          Assert.assertEquals(actual, expected);
     bp.getAddToCartbtn().click();
     WebDriverWait wait = new WebDriverWait(driver, 10);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='counter qty']/span[@class='counter-number']")));
    
//     Thread.sleep(2000);
     bp.getMycartIcon().click();
     wait.until(ExpectedConditions.visibilityOf(bp.getViewCartBtn()));
     bp.getViewCartBtn().click();
//     Thread.sleep(2000);
    
     //jre.executeScript("window.scrollBy(0,100)");
     //wait.until(ExpectedConditions.visibilityOf(bp.getProceedTochckBtn()));
     Thread.sleep(5000);
     bp.getProceedTochckBtn().click();
     Thread.sleep(3000);
     jre.executeScript("window.scrollBy(0,200)");
     Thread.sleep(3000);
     cp.getNextBtn().click();
     Thread.sleep(3000);
     cp.getAgreementCheckbx().click();
     Thread.sleep(3000);
     cp.getProceedBtn().click();
     
     
    orderno= sp.getOrderno().getText();
	 System.out.println(orderno);
     
	   
}

   public void EbookPurchaseValidUser(String username ,String password,String Ebook ) throws Exception 
   {
	   ValidLogin(username, password);
	   Thread.sleep(5000);
	   WebElement prod = driver.findElement(By.xpath("(//a[@title='Product Format'])[1]"));
	   WebElement paperbook = driver.findElement(By.xpath("(//a/span[text()='Books'])[1]"));
	  Actions act = new Actions(driver);
	  act.moveToElement(prod);
	  paperbook.click();
//	   Thread.sleep(5000);
   }

   public void ValidMaxCartCount(String username ,String password ) throws Exception 
   {
	   ValidLogin(username, password);
	      
       JavascriptExecutor jre = (JavascriptExecutor)driver;
          jre.executeScript("window.scrollBy(0,-100)");
          tm.clearCart();
       Actions act = new Actions(driver);
       act.moveToElement(bp.getProductFormat()).perform();
       bp.getEbookCategory().click();
       Thread.sleep(2000);
//      bp.ClearCart();
/*           String val = bp.getCartvalue().getText();
//       int value = Integer.parseInt(val);
          if (val.equalsIgnoreCase(""))
      {  
              System.out.println("Cart is empty");
      }
          else
          {
              System.out.println("i am in else ");
              bp.getMycartIcon().click();
              bp.getViewCartBtn().click();
              Thread.sleep(3000);
              tm.clearCart();
       }
*/      
     
//      tm.searchFuc(ebook);
      List<WebElement> numberofbooks = driver.findElements(By.xpath("//span[text()='Add to Cart']"));
  
      for (int i = 0; i < 5; i++)
      {
          WebElement book = numberofbooks.get(i);
          book.click();
          Thread.sleep(2000);
        
      }
     
     
/*       JavascriptExecutor jre = (JavascriptExecutor)driver;
      jre.executeScript("window.scrollBy(0,-300)");
*/       WebDriverWait wait = new WebDriverWait(driver, 30);
//      wait.until(ExpectedConditions.visibilityOf(bp.getCartvalue5()));
     
    
      jre.executeScript("window.scrollBy(0,-300)");
     
     
      act.moveToElement(bp.getProductFormat()).perform();
      bp.getBooksCategory().click();
     
      List<WebElement> Ebooks = driver.findElements(By.xpath("//span[text()='Add to Cart']"));
       for (int i = 3; i <10; i++)
       {
          WebElement Ebook1 = Ebooks.get(i);
          Ebook1.click();
          Thread.sleep(2000);
         
       }
          JavascriptExecutor jre1 = (JavascriptExecutor)driver;
          jre1.executeScript("window.scrollBy(0,-400)");
         
         
          Assert.assertEquals(bp.getCartvalue().getText(), "10");
//          wait.until(ExpectedConditions.visibilityOf(bp.getCartvalue10()));
          bp.getMycartIcon().click();
         
          wait.until(ExpectedConditions.visibilityOf(bp.getViewCartBtn()));
          bp.getViewCartBtn().click();
         
    
//      bp.getProceedTochckBtn().click();
//      String title = "Checkout";
//      Assert.assertEquals(driver.getTitle(),title);
   }
   
   public void GuestUserProductPurchase(String username,String password,String product,
		   String Guestemail,String firstname,String lastname,String street,String company,String city,
		   	String state,String zip,String country,String telephone)throws Exception
   {
	   tm.searchFuc(product);
	     Thread.sleep(3000);
	  /*   bp.getSearchBar().sendKeys(product,Keys.ENTER);
	       Thread.sleep(2000);
	       List<WebElement> links = driver.findElements(By.xpath("//a"));
	      
	       Iterator<WebElement> itr = links.iterator();
	       while(itr.hasNext())
	       {
	           WebElement txt = itr.next();
	           String value ="Robbins & Cotran Pathologic ...";
	           System.out.println("string value:- "+txt.getText());
	           if (txt.getText().contains(value))
	           {
	               txt.click();
	               break;
	           }
	        }
	    */   
//	       srp.getFirstProductOnSearch().click();
//	       Assert.assertEquals(bp.getProductIsbn().getText(), product);
	     bp.getAddToCartbtn().click();
	       WebDriverWait wait = new WebDriverWait(driver, 10);
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='counter qty']/span[@class='counter-number']")));
	      
//	       Thread.sleep(2000);
	       System.out.println("7");
	       bp.getMycartIcon().click();
	       System.out.println("8");
	       wait.until(ExpectedConditions.visibilityOf(bp.getViewCartBtn()));
	       System.out.println("9");
	       bp.getViewCartBtn().click();
//	      
	       System.out.println("10");
	       Thread.sleep(3000);
	       bp.getProceedTochckBtn().click();
	       System.out.println("11");
	       wait.until(ExpectedConditions.visibilityOf(gucp.getGemail()));
//	       Thread.sleep(10000);
	       gucp.getGemail().sendKeys(Guestemail);
//	       Thread.sleep(1000);
	       gucp.getGFname().sendKeys(firstname);
	       gucp.getGLname().sendKeys(lastname);
	       gucp.getGStreet().sendKeys(street);
	      
	       gucp.getGCity().sendKeys(city);
	      
	       Select sel1 = new Select(gucp.getGState());
	       sel1.selectByIndex(2);
	      
	       gucp.getGZip().sendKeys(zip);
	       gucp.getGCompany().sendKeys(company);
	       gucp.getGPhone().sendKeys(telephone);
	     
	      
//	       Select sel = new Select(gucp.getGCountry());
//	       sel.selectByVisibleText(country);
	              
//	       Thread.sleep(2000);
	      
	       gucp.getGNextBtn().click();
	      
	       String expected="Checkout | US Elsevier Health";
	       Assert.assertEquals(driver.getTitle(), expected);
   }
   
public void EditBillingAddress(String username, String password,String street,String city,String state,String zip,String country) throws Exception
   
{
	 ValidLogin(username, password); 
	 mac.getMangeAcBtn().click();
Thread.sleep(5000);

	 driver.findElement(By.linkText("Change Billing Address")).click();

	 eap.getStreet1().sendKeys(Keys.CONTROL,"a");
	 eap.getStreet1().sendKeys(Keys.DELETE);
	 eap.getStreet1().sendKeys(street);
	 
	 eap.getCity().sendKeys(Keys.CONTROL,"a");
	 eap.getCity().sendKeys(Keys.DELETE);
	 eap.getCity().sendKeys(city);
	 
	 eap.getZipcode().sendKeys(Keys.CONTROL,"a");
	 eap.getZipcode().sendKeys(Keys.DELETE);
	 eap.getZipcode().sendKeys(zip);
	 
	 Thread.sleep(5000);
	 //wait.until(ExpectedConditions.elementToBeSelected(eap.getCountry()));
	 Select sel = new Select(eap.getCountry());
	 sel.selectByVisibleText(country);
	 

	 Select sel1= new Select(eap.getStateDrpDwn());
	 sel1.selectByVisibleText(state);
	 eap.getSubmit().click();
	 
	 Thread.sleep(3000);
	 Assert.assertEquals("You saved the address.", driver.findElement(By.xpath("//div[@data-bind='html: message.text']")).getText());
   
   }
   
   public void addnewAdress(String username, String password, String company, String telephone, String street, String city, String zip, String country, String state) throws Exception
   {
	   ValidLogin(username, password);
	   mac.getMangeAcBtn().click();
	   jre = (JavascriptExecutor)driver;
	   jre.executeScript("window.scrollBy(0,400)");
	   
	   String txt = driver.findElement(By.xpath("//div[@class='primary']/button/span[text()='Add New Address'][1]")).getText();
	  	    
	   if ("Add New Address".equalsIgnoreCase(txt)) 
	   {
		   driver.findElement(By.xpath("//div[@class='primary']/button/span[text()='Add New Address'][1]")).click();
	   }
	   

	  Thread.sleep(10000);
	   eap.getStreet1().sendKeys(street);
	   anap.getCompanyName().sendKeys(company);
	   anap.getTelephone().sendKeys(telephone);
	
	   eap.getCity().sendKeys(city);
	   eap.getZipcode().sendKeys(zip);
	   Thread.sleep(1000);
	   
	   Select sel = new Select(eap.getCountry());
	   sel.selectByVisibleText(country);
	   
	   Thread.sleep(1000);
	   Select sel1= new Select(eap.getStateDrpDwn());
	   sel1.selectByVisibleText(state);
	   eap.getSubmit().click();
	   Thread.sleep(3000);
	   Assert.assertEquals("You saved the address.", driver.findElement(By.xpath("//div[@data-bind='html: message.text']")).getText());
   }
   
   
   
   public void deleteAdress(String username, String password) throws Exception
   {
	   ValidLogin(username, password);
	   mac.getMangeAcBtn().click();
	   jre = (JavascriptExecutor)driver;
	   jre.executeScript("window.scrollBy(0,800)");
	   
	   Thread.sleep(10000);
	   driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
	   Thread.sleep(10000);
	   
	   driver.findElement(By.xpath("//span[text()='OK']")).click();
	   
	
	   Thread.sleep(10000);
	   
	   Assert.assertEquals(driver.findElement(By.xpath("//div[text()='You deleted the address.']")).getText(),"You deleted the address.");
	    
	   
   }
   public void checkFilter() throws InterruptedException
     {
	   
	   action =new Actions(driver);
	   action.moveToElement(hp.getSubjectBtn()).moveToElement(hp.getMedicineBtn()).moveToElement(hp.getAnatomyBtn()).click().build().perform();
	   	   
	    jre = (JavascriptExecutor)driver;
	   jre.executeScript("window.scrollBy(0,200)");
	   jre.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", bp.getPriceFilterBtn());
	   bp.getPriceFilterBtn().click();
	   Thread.sleep(3000);
	   jre.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", bp.getPriceFilterValue());
	   bp.getPriceFilterValue().click();
	   
	   Thread.sleep(3000);
	   //jre.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", bp.getPbYearFilter());
	   //bp.getPbYearFilter().click();
	   Thread.sleep(5000);
	   //jre.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", bp.getYrFilterValue());
	   //bp.getYrFilterValue().click();
	   Thread.sleep(3000);
	   //Thread.sleep(5000);
	   //mp.getProductItem().click();
	   
	   jre.executeScript("window.scrollBy(0,500)");
	   Thread.sleep(4000);
	   bp.getAddToCartbtn().click();
	   //action.moveToElement(bp.getAddToCartbtn()).click().build().perform();
	   //bp.getAddToCartbtn().click();
	   Thread.sleep(10000);
	   action.moveToElement(bp.getMycartIcon()).moveToElement(bp.getViewCartBtn()).click().build().perform();
	  // bp.getMycartIcon().click();
	   Thread.sleep(3000);
	   //bp.getViewCartBtn().click();
	   Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Shopping Cart')]")).getText(), "SHOPPING CART");
	   
	  double price=Double.parseDouble(driver.findElement(By.xpath("(//span[@class='price'])[4]")).getText().substring(1, 2));
	  System.out.println(price);
	 
	  Assert.assertTrue(price>=0 && price<=100);
	}
   
   public void GuestDiscountCoupon(String product,int Discount,String coupon) throws Exception
   {
	   String oldprice;
//     System.out.println(product);
     
//     Thread.sleep(5000);
//     bp.ClearCart();
//     String val1=driver.findElement(By.xpath("//span[@class='counter qty empty']/span[@class='counter-number']")).getText();
      
//     System.out.println("cart value is :-"+val1);
/*       String val = bp.getCartvalue().getText();
     System.out.println("cart value "+val);
    
//     int value = Integer.parseInt(val);
     if (val.equalsIgnoreCase("")) 
     {s
         
         System.out.println("Cart is empty ");
     }
     else 
     {
//         System.out.println(" i am in else condition");
         bp.getMycartIcon().click();
         bp.getViewCartBtn().click();
         Thread.sleep(3000);
         tm.clearCart();
      }
*/
     Thread.sleep(1000);
     tm.searchFuc(product);
     bp.getAddToCartbtn().click();
     WebDriverWait wait = new WebDriverWait(driver, 10);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='counter qty']/span[@class='counter-number']")));
     
//     Thread.sleep(2000);
     bp.getMycartIcon().click();
     wait.until(ExpectedConditions.visibilityOf(bp.getViewCartBtn()));
     bp.getViewCartBtn().click();
//     
//     boolean bol = driver.findElement(By.xpath("//span[@class='old-price']/span[@class='price']")).isDisplayed();
//    System.out.println(bol);
   
    if (driver.findElement(By.xpath("//td[@class='col price']//span[@class='price']")).isDisplayed()) 
   {
       
      oldprice =driver.findElement(By.xpath("//td[@class='col price']//span[@class='price']")).getText();
      //  System.out.println("if condtion is :"+oldprice);



   } 
   else 
   {
       oldprice = driver.findElement(By.xpath("//span[@class='old-price']/span[@class='price']")).getText();
        System.out.println("else condtion is :"+oldprice);
   }
    
    String basefare = oldprice.substring(1);
    double basefare1 = Double.parseDouble(basefare);
    
    String value = driver.findElement(By.xpath("//div[@class='field qty']//input")).getAttribute("value");
//    System.out.prin    tln(value);
    double qty = Double.parseDouble(value);
    double finlprice = qty*basefare1;
    
//    double val2 = finlprice/4;
    double val2 = tm.Discount(finlprice, Discount);
//    System.out.println("discounted price "+val2);
    
//    double afterdiscount = basefare1-val2;
//  System.out.println(afterdiscount);
    
    DecimalFormat df2 = new DecimalFormat("$#.##");
//  System.out.println("Two decimal :- "+df2.format(afterdiscount)); 
    String discountedvalue = df2.format(val2);
    System.out.println(discountedvalue);
    
    driver.findElement(By.id("coupon_code")).sendKeys(coupon);
    driver.findElement(By.xpath("//button//span[text()='Apply']")).click();
    
    
//  List<WebElement> numberOfSubtotal = driver.findElements(By.xpath("//td[@class='col subtotal']"));
//  Iterator<WebElement> itr = numberOfSubtotal.iterator();
    
//  String subtotalval = itr.next().getText();
//  System.out.println("subtotal value "+subtotalval);
//  Assert.assertEquals(discountedvalue, subtotalval);
   
   }  
   
   public void MultiCart(String product,String flashcard,String Ebook) throws InterruptedException
   {
	   tm.searchFuc(product);
       bp.getAddToCartbtn().click();
       tm.searchFuc(flashcard);
       bp.getAddToCartbtn().click();
       tm.searchFuc(Ebook);
       bp.getAddToCartbtn().click();
      
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='counter qty']/span[@class='counter-number']")));
      
//       Thread.sleep(2000);
       bp.getMycartIcon().click();
       wait.until(ExpectedConditions.visibilityOf(bp.getViewCartBtn()));
       bp.getViewCartBtn().click();
    
//       List<WebElement> productlist = driver.findElements(By.xpath("//tbody[@class='cart item']//a"));
      
       JavascriptExecutor jre = (JavascriptExecutor)driver;
       jre.executeScript("window.scrollBy(0,100)");
       wait.until(ExpectedConditions.visibilityOf(bp.getProceedTochckBtn()));
      
       List<WebElement> count = scp.getSubtotalitem();
       for (int i = 0; i <= count.size(); i++)
       {
            String subtotal = count.get(i).getText();
            subtotal.substring(0, 1);
            System.out.println(subtotal);
       }
      
//       bp.getProceedTochckBtn().click();
//       Assert.assertEquals("Customer Login | US Elsevier Health", driver.getTitle());
	   
   }
   
   
   
   public void validDiscountCoupon(String username,String password,String product,int Discount,String coupon) throws Exception
   {
	   ValidLogin(username, password);
       String oldprice;
//       System.out.println(product);
       
//       Thread.sleep(5000);
//       bp.ClearCart();
//       String val1=driver.findElement(By.xpath("//span[@class='counter qty empty']/span[@class='counter-number']")).getText();
        
//       System.out.println("cart value is :-"+val1);
/*       String val = bp.getCartvalue().getText();
       System.out.println("cart value "+val);
      
//       int value = Integer.parseInt(val);
       if (val.equalsIgnoreCase("")) 
       {s
           
           System.out.println("Cart is empty ");
       }
       else 
       {
//           System.out.println(" i am in else condition");
           bp.getMycartIcon().click();
           bp.getViewCartBtn().click();
           Thread.sleep(3000);
           tm.clearCart();
        }
*/
       Thread.sleep(1000);
       tm.searchFuc(product);
       bp.getAddToCartbtn().click();
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='counter qty']/span[@class='counter-number']")));
       
//       Thread.sleep(2000);
       bp.getMycartIcon().click();
       wait.until(ExpectedConditions.visibilityOf(bp.getViewCartBtn()));
       bp.getViewCartBtn().click();
//       
//       boolean bol = driver.findElement(By.xpath("//span[@class='old-price']/span[@class='price']")).isDisplayed();
//      System.out.println(bol);
     
      if (driver.findElement(By.xpath("//td[@class='col price']//span[@class='price']")).isDisplayed()) 
     {
         
        oldprice =driver.findElement(By.xpath("//td[@class='col price']//span[@class='price']")).getText();
        //  System.out.println("if condtion is :"+oldprice);

 

     } 
     else 
     {
         oldprice = driver.findElement(By.xpath("//span[@class='old-price']/span[@class='price']")).getText();
          System.out.println("else condtion is :"+oldprice);
     }
      
      String basefare = oldprice.substring(1);
      double basefare1 = Double.parseDouble(basefare);
      
      String value = driver.findElement(By.xpath("//div[@class='field qty']//input")).getAttribute("value");
//      System.out.prin    tln(value);
      double qty = Double.parseDouble(value);
      double finlprice = qty*basefare1;
      
//      double val2 = finlprice/4;
      double val2 = tm.Discount(finlprice, Discount);
//      System.out.println("discounted price "+val2);
      
//      double afterdiscount = basefare1-val2;
//    System.out.println(afterdiscount);
      
      DecimalFormat df2 = new DecimalFormat("$#.##");
//    System.out.println("Two decimal :- "+df2.format(afterdiscount)); 
      String discountedvalue = df2.format(val2);
      System.out.println(discountedvalue);
      
      driver.findElement(By.id("coupon_code")).sendKeys(coupon);
      driver.findElement(By.xpath("//button//span[text()='Apply']")).click();
      
      
//    List<WebElement> numberOfSubtotal = driver.findElements(By.xpath("//td[@class='col subtotal']"));
//    Iterator<WebElement> itr = numberOfSubtotal.iterator();
      
//    String subtotalval = itr.next().getText();
//    System.out.println("subtotal value "+subtotalval);
//    Assert.assertEquals(discountedvalue, subtotalval);   
   }
  public void GuestUserNotBuyEbook(String Ebook) throws Exception
   {
	  tm.searchFuc(Ebook);
//    srp.getFirstProductOnSearch().click();
    bp.getAddToCartbtn().click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='counter qty']/span[@class='counter-number']")));
   
//    Thread.sleep(2000);
    bp.getMycartIcon().click();
    wait.until(ExpectedConditions.visibilityOf(bp.getViewCartBtn()));
    bp.getViewCartBtn().click();
//   
    bp.getProceedTochckBtn().click();
    Thread.sleep(3000);
   }
  public void Forgetpassword() throws InterruptedException
  {
//	   lp.getUsrico().click();
	   lp.getLoginBtn().click();
	   Thread.sleep(3000);
	   lp.getForgetPassbtn().click();
	   Thread.sleep(2000);
	   fpp.getEmailid().sendKeys("kapil.bhardwaj@infoprolearning.com");
	   
	   fpp.getSubmit().click();
	   
	   
	   driver.get("https://login.microsoftonline.com/");
	   Thread.sleep(5000);
	   
	   driver.findElement(By.id("i0116")).sendKeys("kapil.bhardwaj@infoprolearning.com");
	   driver.findElement(By.id("idSIButton9")).click();
	   Thread.sleep(5000);
	   driver.findElement(By.id("i0118")).sendKeys("infopro@123");
	   
	   driver.findElement(By.id("idSIButton9")).click();
	   driver.findElement(By.id("idBtn_Back")).click();
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("//div[text()=' Outlook ']")).click();
	   Thread.sleep(5000);
	   Set<String> windowsId = driver.getWindowHandles();
	   
	   Iterator<String> itr = windowsId.iterator();
	   String parent = itr.next();
	   String child = itr.next();
	   driver.switchTo().window(child);
//	   WebDriverWait wait = new WebDriverWait(driver, 30);
//	   wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//span[text()='Junk Email']"))));
//	   driver.findElement(By.xpath("//span[text()='Junk Email']")).click();
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("//span[starts-with(text(),'Password Reset Confirmation for kapil bhardwaj')][1]")).click();
	   driver.findElement(By.linkText("Set a New Password")).click();
	   
	   Thread.sleep(5000);
	   
	   Set<String> sessions = driver.getWindowHandles();
	   Iterator<String> itr1 = sessions.iterator();
	   String first = itr1.next();
	   System.out.println(first);
	   String second = itr1.next();
	   System.out.println(second);
	   
	   String third = itr1.next();
	   driver.switchTo().window(third);
	  
	   
	   
	   Random ran = new Random();
	   int passnum = ran.nextInt();
	   
	   String newpass = "Infopro"+passnum;
	   System.out.println(newpass);
			  
	   Thread.sleep(5000);
	   driver.findElement(By.id("password")).sendKeys(newpass);
	   driver.findElement(By.id("password-confirmation")).sendKeys(newpass);
	   driver.findElement(By.xpath("//button/span[text()='Set a New Password']")).submit();
	   Thread.sleep(5000);
	   
	 
	   driver.findElement(By.id("email")).sendKeys("kapil.bhardwaj@infoprolearning.com");
	   driver.findElement(By.id("pass")).sendKeys(newpass);
	   driver.findElement(By.id("send2")).submit();
	   
	   Thread.sleep(20000);
	   
	   
  }

  
  public void searchProductByFormat(String username,String password, String isbnsearch, String Author, String title, String keyword) throws Exception {
	  
	   ValidLogin(username, password);
	  
	  Thread.sleep(1000);
	  
	  tm.customSearchProduct(isbnsearch);

	 
	  tm.customSearchProduct(title);
	 
	  tm.customSearchProduct(Author);
	  
	  tm.customSearchProduct(keyword);
	  

	  
	  Thread.sleep(5000);
	action.moveToElement(bp.getMycartIcon()).moveToElement(bp.getViewCartBtn()).click().build().perform();
	  
		  
	  
  }
  
  
  public void ESubscribeAlert(String username, String password) throws Exception {
	  
	  ValidLogin(username, password);
	  
	  Thread.sleep(2000);
	  JavascriptExecutor jre = (JavascriptExecutor)driver;
	  jre.executeScript("window.scrollBy(0,800)");
	  
	  mac.getEAlertlink().click();
	  Thread.sleep(2000);
	  mac.getFirstSubsBox().click();
	  mac.getSecondSubsBox().click();
	  mac.getSaveBtn().click();
	  
	  
  }
  
  
  public void logOut() throws Exception  {
	  
	  action.moveToElement(hp.getUserIcon()).moveToElement(hp.getLogOutBtm()).click().build().perform();
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).getText(), "Log In");
	  
  }
  
 public void wishList(String username, String password) throws Exception {
	  
	  ValidLogin(username, password);
	  
	  hp.getStoreLogo().click();
	  Thread.sleep(10000);
	  
	  hp.getWishlistItem().click();
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//a[@class='product-item-link']")).getText(), driver.findElement(By.xpath("(//a[@class='product-item-link'])[1]")).getText());
 }
  
 
 public void EbookMaxCount() throws InterruptedException
 {
     JavascriptExecutor jre = (JavascriptExecutor)driver;
      jre.executeScript("window.scrollBy(0,-100)");
     
   //   String val = bp.getNullValue().getText();
   //   System.out.println(val);
      tm.clearCart();
     Actions act = new Actions(driver);
     act.moveToElement(bp.getProductFormat()).perform();
     bp.getEbookCategory().click();
     Thread.sleep(2000);
    
     List<WebElement> numberofbooks = driver.findElements(By.xpath("//span[text()='Add to Cart']"));
     
     for (int i = 0; i < 7; i++)
     {
         WebElement book = numberofbooks.get(i);
         book.click();
         Thread.sleep(2000);
       
     }
     JavascriptExecutor jre1 = (JavascriptExecutor)driver;
     jre1.executeScript("window.scrollBy(0,-400)");
    
     Assert.assertEquals(bp.getCartvalue().getText(), "5");
     
    
 }

  public void orderNoConfirm(String username, String password, String product) throws Exception {
	  
	  ValidLogin(username, password);
      JavascriptExecutor jre = (JavascriptExecutor)driver;


        Thread.sleep(3000);
        tm.clearCart();
        tm.searchFuc(product);

    bp.getAddToCartbtn().click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='counter qty']/span[@class='counter-number']")));
   

    bp.getMycartIcon().click();
    wait.until(ExpectedConditions.visibilityOf(bp.getViewCartBtn()));
    bp.getViewCartBtn().click();

    Thread.sleep(5000);
    bp.getProceedTochckBtn().click();
    Thread.sleep(3000);
    jre.executeScript("window.scrollBy(0,200)");
    Thread.sleep(5000);
    cp.getNextBtn().click();
    Thread.sleep(3000);
    cp.getAgreementCheckbx().click();
    Thread.sleep(3000);
    cp.getProceedBtn().click();
    
    
    String orderno= sp.getOrderno().getText();
	 System.out.println(orderno);
	 
	action.moveToElement(hp.getUserIcon()).moveToElement(hp.getMyAccountLink()).click().build().perform();

	  
	  Thread.sleep(5000);
	  sp.getMyOrderlink().click();
	  
	 	  
	  Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[1]")).getText(), orderno);
	  
	  
	  
	  
	  
  }
 
}
   


