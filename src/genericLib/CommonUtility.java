package genericLib;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility 
{
	public int getRandomNum()
	{
		Random r=new Random();
		int num=r.nextInt(1000);
		return num;
	}
	
	public String getMsgFromAlert(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();	
		String msg=alt.getText();
		return msg;
	}
	
	public void alertCancel(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();	
		alt.dismiss();
	}
	
	public void alertOK(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();	
		alt.accept();
	}
	
	public void sendMsgInAlert(WebDriver driver,String text)
	{
		Alert alt=driver.switchTo().alert();
		alt.sendKeys(text);
	}
	
	public void explicitTextToBePresentInElementLocated(WebDriver driver,long sec,By locator,String data)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, data));
	}
	
	public void explicitVisibilityOfElementLocated(WebDriver driver,long sec,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void actionScrollByAmount(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.scrollByAmount(x,y).perform();
	}
	
	public void mouseMoveToElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void mouseDoubleClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();;
	}
	
	public void mouseDragAndDrop(WebDriver driver,WebElement source,WebElement destination)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(source, destination).perform();
	}
	
	public void listSelectByVisibleText(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	public List<WebElement> listGetOptions(WebElement element)
	{
		Select s=new Select(element);
		List<WebElement> list=s.getOptions();
		return list;
	}
}
