package genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//Methods Common For Browser Actions - BaseClass
public class BaseClass
{
	public static WebDriver listenerdriver;//SS ITestListener
	public WebDriver driver;
	public DataUtility du=new DataUtility(); //Change default to public - B'Coz We Need to Access in another Package (Child class)
	public CommonUtility cu=new CommonUtility();
	
	//@Parameters("browser") --> Cross Browser Execution
	@BeforeClass(alwaysRun=true)
	public void launchBrowser() //-->(String browser) as Arg for Cross Browser Execution 
	{
//		if(browser.equals("chrome"))
//		{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
//		}
//		else if(browser.equals("edge")) -->Cross Browser Execution
//		{
//		EdgeOptions options=new EdgeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		driver=new EdgeDriver(options);
//		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Parameters({"username","password"})//Parameterization Concept -From "parameter - .xml file"
	@BeforeMethod(alwaysRun=true)
	public void login(String username,String password ) throws IOException
	{
		driver.get(du.getDataFromProperties("url"));
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("keepLoggedInCheckBox")).click();
		driver.findElement(By.id("loginButton")).click();
	}
	
	@AfterMethod(alwaysRun=true)
	public void logout()
	{
		driver.findElement(By.id("logoutLink")).click();
	}
	
	@AfterClass(alwaysRun=true)
	public void closeBrowser()
	{
		driver.quit();
	}
}
