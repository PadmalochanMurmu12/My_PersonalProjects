package pomStructures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePg
{
	public static WebDriver driver;
	public HomePg(WebDriver d)
	{
		driver= d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how= How.XPATH,using= "//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']") WebElement StartHereBtn;
	
	public WebElement getStartHereBtn()
	{
		return StartHereBtn;
	}
}
