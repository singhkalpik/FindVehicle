package Find_Vehicle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import okio.Timeout;

public class Find_Vehicle {
	
	private static final String Assert = null;
	static String URL = "https://covercheck.vwfsinsuranceportal.co.uk/";
	static String VehicleValue = "OV12UYY";
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		WebElement vehicle = driver.findElement(By.id("vehicleReg"));
		vehicle.clear();
		vehicle.click();
		WebElement sendVehicle = driver.findElement(By.id("vehicleReg"));
		sendVehicle.sendKeys(VehicleValue);
		WebElement clickVehicle = driver.findElement(By.cssSelector("#page-container > div.dlg-dealersearch-control > form > button > span"));
		clickVehicle.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		WebElement elementValue= driver.findElement(By.cssSelector("#page-container > div:nth-child(4) > div.result"));
		elementValue.getText();
			
		if(driver.getPageSource().contains("OV12UYY"))
		{
			System.out.println("Vehicle is exist");
			
		}
		else
		{
			System.out.println("Vehicle not present");
		}
			
		driver.quit();
	}

}
