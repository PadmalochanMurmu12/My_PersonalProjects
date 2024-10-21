package baseClass;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public class Base_Class {

	String path= System.getProperty("user.dir");
	public static WebDriver driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	@BeforeTest
	public void beforeTest()
	{
		sparkReporter= new ExtentSparkReporter(path+File.separator+"Reports"+File.separator+"TestReports.html");
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.STANDARD);
		extent.setSystemInfo("HostName", "null");
		extent.setSystemInfo("Username", "Root");
		extent.setSystemInfo("OS", "Windows 11");
		sparkReporter.config().setDocumentTitle("Test Report");
		sparkReporter.config().setReportName("Automation Test Result");
	}
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser, Method testMethod)
	{
		logger= extent.createTest(testMethod.getName());
		setupDriver(browser);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName() + "Test case failed", ExtentColor.RED));
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable() + "Test case failed", ExtentColor.RED));
		}

		else if(result.getStatus()== ITestResult.SKIP)
		{
			logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName() + "Test case Skipped", ExtentColor.ORANGE));
		}

		else if(result.getStatus()== ITestResult.SUCCESS)
		{
			logger.log(Status.PASS,MarkupHelper.createLabel(result.getName() + "Test case Passed", ExtentColor.GREEN));
		}

	}

	@AfterClass
	public void afterTest()
	{
		extent.flush();
		driver.quit();
	}


	public void setupDriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}

		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}

		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
	}
}