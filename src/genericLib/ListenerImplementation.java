package genericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result)
	{
		//TO GET THE FAILURE TEST CASE NAME
		String tcName=result.getName();
		
		//TAKE SCREENSHOT
		TakesScreenshot ts=(TakesScreenshot)BaseClass.listenerdriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./FailedTcScreenshot/"+tcName+".png");
		try 
		{
			FileUtils.copyFile(src,trg);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
