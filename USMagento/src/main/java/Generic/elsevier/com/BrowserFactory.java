
package Generic.elsevier.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class BrowserFactory 
{
   public static WebDriver launch(String browserName)
   {
	   WebDriver driver= null;
	   if (browserName.equalsIgnoreCase("chrome"))
	   {
		System.setProperty("webdriver.chrome.driver", "./ExeFile/chromedriver.exe");
		//driver= new ChromeDriver();
		/*ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");*/

        driver = new ChromeDriver();
		Reporter.log("chrome Launched",true);
	   }
	   else if (browserName.equalsIgnoreCase("ie")) 
	   {
		  System.setProperty("webdriver.ie.driver", "./ExeFile/IEDriverServer.exe");
		  driver=new InternetExplorerDriver();
		  Reporter.log("internet explorer launched",true);
	   } 
	   return driver;
   }
}
