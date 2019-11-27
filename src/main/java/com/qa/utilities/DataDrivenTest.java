package com.qa.utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTest {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares&Drivers\\WebDriver\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://qclocalpreprod.qfund.net/cc/demoIndex.do");
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\HEM\\Desktop\\Automation Data\\TestDataDDT-1.xlsx");
		reader.addColumn("DDT", "Status");
		
		for(int rownum=2; rownum<=reader.getRowCount("DDT");rownum++){
			String username = reader.getCellData("DDT", "Username", rownum);
			System.out.println(username);
			String password = reader.getCellData("DDT", "Password", rownum);
			System.out.println(password);
			String storeid = reader.getCellData("DDT", "storeID", rownum);
			System.out.println(storeid);
			
			driver.findElement(By.name("loginRequestBean.userId")).clear();
			driver.findElement(By.name("loginRequestBean.userId")).sendKeys(username);
			driver.findElement(By.name("loginRequestBean.password")).clear();
			driver.findElement(By.name("loginRequestBean.password")).sendKeys(password);
			driver.findElement(By.name("loginRequestBean.locNbr")).clear();
			driver.findElement(By.name("loginRequestBean.locNbr")).sendKeys(storeid);
			driver.findElement(By.name("login")).click();
			
			reader.setCellData("DDT", "Status", rownum, "Pass");
			
		}
		

	}

}
