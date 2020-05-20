package Script;

import org.testng.annotations.Test;

import Generic.elsevier.com.baseLib;
import InternalData.Data;
import feature.taskfeature;

public class SuccessPageTest extends baseLib implements Data{

	
	@Test(priority = 1)
	public void myOrderValdation() throws Exception
	{
		taskfeature tf = new taskfeature(driver);
		tf.orderNoConfirm(username, password, product);
		
		
		
		
		
	}
}
