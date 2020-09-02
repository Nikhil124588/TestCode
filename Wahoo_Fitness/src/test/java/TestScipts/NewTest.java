package TestScipts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pagelibrary.ProductCategory;
import testbase1.TestBase;
@Listeners(listener.Listener.class)
public class NewTest extends TestBase
{
  @BeforeSuite
  public void openbrowser() throws IOException
  {
	  browser();
  }
  @BeforeTest
  public void maximizebrowser()
  {
	  openUrl();
  }
  @BeforeClass
  public void openurl()
  {
	  maximize();
  }
  @BeforeMethod
  public void getCookies()
  {
	 Set<Cookie> ts=driver.manage().getCookies();
	for (Cookie cookie1 : ts)
	{
		System.out.println("cookies are =" +cookie1);
	}
  }
  
  @Test
  public void testPage() throws Exception
  
  {
	 
	  wait1();
	  ProductCategory page=PageFactory.initElements(driver, ProductCategory.class);  
	  page.productAdd();
	  page.checkoutp();
	  page.shippingaddress("someone@whocares.com", "test", "tester", "Comandante Izarduy 67, Barcelona  08940", "5555555555", "4111111111111111" , "08/24", "111");
	  
  }
}