package automation.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import automation.resources.ExtentReportedNG;

public class Listners extends BaseTest implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent =ExtentReportedNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe 
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); // unique id(submitorder) -> Test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, result.getMethod().getMethodName()+" Test case is Passed ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
//		test.log(Status.FAIL, result.getMethod().getMethodName()+" Test case is Failed ");
//		test.fail(result.getThrowable());
		
		extentTest.get().fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//screenshot on test failure 
		String filepath = null;
		 try {
			 filepath =getScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 extentTest.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getMethod().getMethodName()+" Test case is Skipped ");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
	
	

}
