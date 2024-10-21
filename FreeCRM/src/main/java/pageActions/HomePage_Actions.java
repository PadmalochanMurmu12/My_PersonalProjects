package pageActions;

import org.openqa.selenium.WebDriver;

import pomStructures.HomePg;
import pomStructures.HomePage_Elements;
import utils.ElementsFetch;

public class HomePage_Actions {

	ElementsFetch el= new ElementsFetch();
//	WebDriver driver;
//	HomePg hpg;
//	
//	public HomePage_Actions(WebDriver driver)
//	{
//		this.driver= driver;
//		hpg= new HomePg(driver);
//	}
	
	public void click_StartHereBtn() {
		
		el.getWebElement("XPATH", HomePage_Elements.StartHereBtn).click();
//		hpg.getStartHereBtn().click();
		
	}
}
