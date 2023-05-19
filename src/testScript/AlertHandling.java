package testScript;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import genericLib.BaseClass;


public class AlertHandling extends BaseClass{
	
	@Test
	public void alertHandling() throws EncryptedDocumentException, IOException
	{
		//Settings
		driver.findElement(By.cssSelector(".popup_menu_button.popup_menu_button_settings ")).click();
		
		//Types Of Work
		driver.findElement(By.linkText("Types of Work")).click();
		
		//Create Type Of Work
		driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
		
		//Enter Name & Cancel
		driver.findElement(By.name("name")).sendKeys(du.getDataFromExcel("Sheet2", 2, 1));
		driver.findElement(By.xpath("//input[@onclick='handleCancel();']")).click();
			
		//Switch To Alert & GetText()
		System.out.println(cu.getMsgFromAlert(driver));
		
		//Cancel
		cu.alertCancel(driver);
	}
}
