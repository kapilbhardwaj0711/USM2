package Script;

import org.testng.annotations.Test;

import Generic.elsevier.com.baseLib;
import InternalData.Data;
import feature.taskfeature;

public class Search_Product extends baseLib implements Data
{
     @Test
     public void CustomSearchTest() throws Exception
     {
    	 taskfeature tf = new taskfeature(driver);

    	 tf.searchProductByFormat(username, password, isbnsearch, author, title, keyword);
    	 
     }
}
