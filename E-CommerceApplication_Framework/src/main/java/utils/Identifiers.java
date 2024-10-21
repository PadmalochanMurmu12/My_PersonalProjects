package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import baseClass.Base;

public class Identifiers {

	public WebElement getWebElement(String identifierType, String identifierValue) {

		switch(identifierType)
		{

		case "XPATH":
			return Base.driver.findElement(By.xpath(identifierValue));

		case "CSS":
			return Base.driver.findElement(By.cssSelector(identifierValue));

		case "ClassName":
			return Base.driver.findElement(By.className(identifierValue));

		case "ID":
			return Base.driver.findElement(By.id(identifierValue));

		case "Name":
			return Base.driver.findElement(By.name(identifierValue));

		case "LinkText":
			return Base.driver.findElement(By.linkText(identifierValue));

		case "PatialLinkText":
			return Base.driver.findElement(By.partialLinkText(identifierValue));

		default:
			return null;

		}
	}	
	public List<WebElement> getWebElements(String identifierType, String identifierValue) {

		switch(identifierType)
		{

		case "XPATH":
			return Base.driver.findElements(By.xpath(identifierValue));

		case "CSS":
			return Base.driver.findElements(By.cssSelector(identifierValue));

		case "ClassName":
			return Base.driver.findElements(By.className(identifierValue));

		case "ID":
			return Base.driver.findElements(By.id(identifierValue));

		case "Name":
			return Base.driver.findElements(By.name(identifierValue));

		case "LinkText":
			return Base.driver.findElements(By.linkText(identifierValue));

		case "PatialLinkText":
			return Base.driver.findElements(By.partialLinkText(identifierValue));

		default:
			return null;

		}
	}
}
