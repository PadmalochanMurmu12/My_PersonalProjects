package testCases;

import org.testng.annotations.Test;

import baseClass.Base_Class;
import pageActions.HomePage_Actions;
import pageActions.LoginPage_Actions;
import utils.ElementsFetch;

public class TC_1 extends Base_Class {

	ElementsFetch el= new ElementsFetch();
	HomePage_Actions homePg= new HomePage_Actions();
	LoginPage_Actions loginPg= new LoginPage_Actions();

	@Test
	public void enterCredentials()
	{

		homePg.click_StartHereBtn();
		loginPg.enterCreds();
		//	  loginPg.clickLoginBtn();
		loginPg.verifyLogin();

	}
}
