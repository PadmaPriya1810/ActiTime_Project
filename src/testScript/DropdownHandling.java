package testScript;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLib.BaseClass;

public class DropdownHandling extends BaseClass
{
	@Test
	public void dropdownHandling() throws EncryptedDocumentException, IOException
	{
		driver.findElement(By.cssSelector(".popup_menu_button.popup_menu_button_settings ")).click();
		
		driver.findElement(By.xpath("//div[text()='Manage system settings & configure actiTIME']/preceding-sibling::div")).click();

		//User Groups DropDown Location
		WebElement dropdown=driver.findElement(By.id("userGroupNamingCodeSelect"));
		
		cu.listSelectByVisibleText(dropdown,du.getDataFromExcel("Sheet2", 3, 1));
		
		List<WebElement> list=cu.listGetOptions(dropdown);
		
		//Create ArrayList to Use "sort(List l)" -Accepts only list
		ArrayList alist=new ArrayList();
		
		for(int i=0;i<list.size();i++)
		{
			alist.add(list.get(i).getText());
		}
		System.out.println(alist);//[-- custom name --, Department, Cost Center, Location, Team, User Group]	
		
		cu.listSelectByVisibleText(dropdown, "Location");
		
		String msg=driver.findElement(By.id("FormModifiedTextCell")).getText();
		System.out.println(msg);
	}
}
