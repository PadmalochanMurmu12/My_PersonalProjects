package pageActions;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import pomStructures.LoginPage_Elements;
import utils.Constants;
import utils.ElementsFetch;

public class LoginPage_Actions {

	ElementsFetch el= new ElementsFetch();
	public void enterCreds()
	{
		el.getWebElement("NAME", LoginPage_Elements.emailField).sendKeys(Constants.email);
		el.getWebElement("NAME", LoginPage_Elements.passwordField).sendKeys(Constants.pass+Keys.ENTER);

	}

	public void verifyLogin() {
		Assert.assertFalse(el.getWebElement("XPATH", LoginPage_Elements.err_Msg).isDisplayed());
	}
}
