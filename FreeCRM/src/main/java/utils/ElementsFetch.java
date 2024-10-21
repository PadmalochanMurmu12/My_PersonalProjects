package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.Base_Class;

public class ElementsFetch {

	public WebElement getWebElement(String identifierType, String identifierValue)
	{
		switch(identifierType)
		{
		
		case "XPATH":
			return Base_Class.driver.findElement(By.xpath(identifierValue));
			
		case "CSS":
			return Base_Class.driver.findElement(By.cssSelector(identifierValue));
			
		case "CLASS":
			return Base_Class.driver.findElement(By.className(identifierValue));
			
		case "NAME":
			return Base_Class.driver.findElement(By.name(identifierValue));
			
		case "ID":
			return Base_Class.driver.findElement(By.id(identifierValue));
			
		case "LINK_TEXT":
			return Base_Class.driver.findElement(By.linkText(identifierValue));
			
		case "PARTIAL_LINKTEXT":
			return Base_Class.driver.findElement(By.partialLinkText(identifierValue));
			
		case "TAG_NAME":
			return Base_Class.driver.findElement(By.tagName(identifierValue));
			
			default:
				return null;
		
		}
	}
	
	public List<WebElement> getWebElements(String identifierType, String identifierValue)
	{
		switch(identifierType)
		{
		
		case "XPATH":
			return Base_Class.driver.findElements(By.xpath(identifierValue));
			
		case "CSS":
			return Base_Class.driver.findElements(By.cssSelector(identifierValue));
			
		case "CLASS":
			return Base_Class.driver.findElements(By.className(identifierValue));
			
		case "NAME":
			return Base_Class.driver.findElements(By.name(identifierValue));
			
		case "ID":
			return Base_Class.driver.findElements(By.id(identifierValue));
			
		case "LINK_TEXT":
			return Base_Class.driver.findElements(By.linkText(identifierValue));
			
		case "PARTIAL_LINKTEXT":
			return Base_Class.driver.findElements(By.partialLinkText(identifierValue));
			
		case "TAG_NAME":
			return Base_Class.driver.findElements(By.tagName(identifierValue));
			
			default:
				return null;
		
		}
	}
	
}
