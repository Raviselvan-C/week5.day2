package week5.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class DuplicateLead extends ClassroomSession{
	
	@org.testng.annotations.Test(dataProvider="testData1")
	public void runDuplicateLead(String Uname,String pwd,String pH) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(Uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pH);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();
		
}
	@DataProvider
	public String[][] testData1() throws IOException {
		String array[][] = ReadExcelData.readExcel("duplicateLead");
		return array;
	}

}
