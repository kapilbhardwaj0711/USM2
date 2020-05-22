package Script;

import org.testng.annotations.Test;

import Generic.elsevier.com.baseLib;
import InternalData.Data;
import feature.taskfeature;

public class Search_Product extends baseLib implements Data
{
     @Test(priority = 1)
     public void SearchTestBytitle() throws Exception
     {
    	 taskfeature tf = new taskfeature(driver);

    	 tf.searchProductByTitle(username, password, isbnsearch, author, title, keyword);
    	 
     }
     
 /*    @Test(priority = 2)
     public void SearchTestByISBN() throws Exception
     {
    	 taskfeature tf = new taskfeature(driver);

    	 tf.searchProductByISBN(username, password, isbnsearch, author, title, keyword);
    	 
     }
     
     @Test(priority = 3)
     public void SearchTestByAuthor() throws Exception
     {
    	 taskfeature tf = new taskfeature(driver);

    	 tf.searchProductByAuthor(username, password, isbnsearch, author, title, keyword);
    	 
     }
*/}
