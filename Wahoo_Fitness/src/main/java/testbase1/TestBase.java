package testbase1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase 
{
	public WebDriver driver;
	Properties pro=new Properties();
	public FileInputStream fis;
	public void browser() throws IOException
	{
	 fis=new FileInputStream("D:\\SeleniumTest\\Wahoo_Fitness\\src\\main\\java\\config\\properties\\config.properties");
	 pro.load(fis);
	 System.setProperty("webdriver.chrome.driver", pro.getProperty("chrome"));
	 driver = new ChromeDriver();
	}
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	 
	public void openUrl()
	{
		driver.get(pro.getProperty("url"));
	}
	public void wait1()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
    public void screenshot(String resultname) throws Exception
    {
    	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(src, new File("D:\\SeleniumTest\\Wahoo_Fitness\\src\\main\\java\\screenshots" + resultname+""+".jpg"));
    	
    }
  
	
}
