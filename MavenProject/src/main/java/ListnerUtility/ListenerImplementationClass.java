package ListnerUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import BaseClassUtility.BaseClass;
import Generic_Utility.Java_Utility;

public class ListenerImplementationClass implements ITestListener, ISuiteListener{
	 
		@Override
		public void onStart(ISuite suite) {
			System.out.println("Report Configuration");
		}

		@Override
		public void onFinish(ISuite suite) {
			System.out.println("Report Back up");
		}

		@Override
		public void onTestStart(ITestResult result) {
			System.out.println("=====START====="+result.getMethod().getMethodName()+"=======");
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			System.out.println("=====SUCCESS====="+result.getMethod().getMethodName()+"=======");
			}

		@Override
		public void onTestFailure(ITestResult result) {
			String methodName = result.getMethod().getMethodName();
			Java_Utility jutil= new Java_Utility();
			String currentTime = jutil.getSystemDateAndTimeForScreenshot();
			TakesScreenshot tks= (TakesScreenshot)BaseClass.sdriver;
			File temp = tks.getScreenshotAs(OutputType.FILE);
			File perm= new File("./errorShots/"+methodName+currentTime+".png");
			try {
				FileHandler.copy(temp, perm);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("=====FAILED====="+methodName+"=======");
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			System.out.println("=====SKIPPED====="+result.getMethod().getMethodName()+"=======");
		}
		
}	