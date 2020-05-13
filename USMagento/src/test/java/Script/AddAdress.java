package Script;

import org.testng.annotations.Test;

import Generic.elsevier.com.baseLib;
import InternalData.Data;
import feature.taskfeature;

public class AddAdress extends baseLib implements Data 
{
	@Test(priority = 3)
	public void editbilladress() throws Exception
	{
		taskfeature tf = new taskfeature(driver);
		tf.EditBillingAddress(username, password, street, city, state, zip, country);
	}
	@Test(priority = 1)
	public void addNewaddress() throws Exception
	{
		taskfeature tf = new taskfeature(driver);
		tf.addnewAdress(username, password, company, telephone, street, city, zip, country, state);
	}
	
	@Test(priority=2)
	public void deleteAddressTest() throws Exception {
		
		taskfeature tf = new taskfeature(driver);
		tf.deleteAdress(username, password);
		
	}
}
