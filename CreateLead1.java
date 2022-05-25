package week5.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead1 extends ClassroomSession{
	
	@Test(dataProvider="testData")
	public void runCreateLead(String Uname,String pwd,String cmp,String FName,String LName ) {
		driver.findElement(By.id("username")).sendKeys(Uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cmp);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(FName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LName);
		driver.findElement(By.name("submitButton")).click();
	}
	
	@DataProvider
	public String[][] testData() throws IOException {
		String array[][] = ReadExcelData.readExcel("ceateLead");
		return array;
	}
	

}
