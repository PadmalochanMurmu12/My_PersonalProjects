package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.*;
import pageobjects.*;

public class SingleProduct extends Base{

	@Test(priority=1, description="Search from Google")
	public void searchFromGoogle() {
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		Google_Page tc1= new Google_Page(driver);
		tc1.sendQuerytoGoogle(prop.getProperty("MyApp"));
		List<WebElement> auto= driver.findElements(By.xpath(loc.getProperty("autoSuggestions")));

		for(WebElement options: auto) {
			if(options.getText().equalsIgnoreCase(prop.getProperty("MyApp"))) {
				options.click();
				break;
			}
		}

		tc1.clickSearchResult();
	}

	@Test(priority= 2, description="Verify the page and adding products to cart")
	public void homePage() {
		GreenKart_HomePage tc2= new GreenKart_HomePage(driver);
		WebElement logo= driver.findElement(By.cssSelector(loc.getProperty("appLogo")));
		Assert.assertTrue(logo.isDisplayed(), "Checking if Logo is displayed");
		tc2.searchProduct(prop.getProperty("MyProduct"));
		tc2.clickAddToCart();
		tc2.clickCartIcon();
		tc2.proceedToCheckout();

	}

	@Test(priority= 3, description="Verify product, Applying promocode and proceed")
	public void checkoutPage(){
		Product_Details tc3= new Product_Details(driver);
		tc3.enterPromocode(prop.getProperty("Promocode"));
		WebElement successMsg= driver.findElement(By.xpath(loc.getProperty("successAlert")));

		if(successMsg.isDisplayed()) {
			System.out.println("Promocode Applied Successfully");
		}

		else {
			System.out.println("Check Your code");
		}
		
		tc3.clickPlaceOrder();

	}

	@Test(priority= 4, description="Select the country")
	public void selectCountry() {
		SelectCountry tc4= new SelectCountry(driver);
		WebElement selectDropdown= driver.findElement(By.cssSelector(loc.getProperty("dropdown")));
		Select select= new Select(selectDropdown);
		select.selectByVisibleText(prop.getProperty("myCountry"));
		tc4.clickCheckBox();
		tc4.clickProceedBtn();
	}

}
