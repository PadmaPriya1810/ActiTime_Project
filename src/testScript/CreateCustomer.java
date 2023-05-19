package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLib.BaseClass;

public class CreateCustomer extends BaseClass 
{
	@Test
	public void createCustomer() throws IOException
		{
		String customername=du.getDataFromExcel("Sheet2", 0, 1);
		int num=cu.getRandomNum();
		//ReInitializing customername
		customername=customername+num;		
		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.cssSelector(".title.ellipsis")).click();
		driver.findElement(By.className("createNewCustomer")).click();
		driver.findElement(By.cssSelector(".inputFieldWithPlaceholder.newNameField.inputNameField")).sendKeys(customername);
		driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']")).sendKeys(du.getDataFromExcel("Sheet2", 1, 1));
		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();	
		cu.explicitTextToBePresentInElementLocated(driver, 10, By.cssSelector(".titleEditButtonContainer>.title"), customername);
		String expcustomername=driver.findElement(By.cssSelector(".titleEditButtonContainer>.title")).getText();
		//System.out.println(expcustomername);
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(customername.contains(expcustomername));
		System.out.println("Pass");
		sa.assertAll();
		}
	
	@Test
	public void title()
	{
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void url()
	{
		System.out.println(driver.getCurrentUrl());
	}
}
