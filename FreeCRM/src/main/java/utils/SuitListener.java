package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import baseClass.Base_Class;

public class SuitListener implements ITestListener, IAnnotationTransformer {

	String path= System.getProperty("user.dir");
	
	public void onTestFailure(ITestResult result)
	{
		String fileName= (path+File.separator+"Screenshots"+File.separator+result.getMethod().getMethodName());
		File file= ((TakesScreenshot)Base_Class.driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File(fileName +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void transform(
		      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
	{
		annotation.setRetryAnalyzer(RetryTests.class);
	}
}
