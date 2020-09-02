package pagelibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import testbase1.TestBase;

public class ProductCategory extends TestBase{
public WebDriver Driver;

    @FindBy(xpath="//*[@id=\"onetrust-accept-btn-handler\"]")
    @CacheLookup
    WebElement cookiebutton;
    
	@FindBy(xpath="//span[.='SHOP']")
	@CacheLookup
	WebElement shopbutton;
	
	@FindBy(xpath="//a[@title='KICKR SMART TRAINER']")
	@CacheLookup
	WebElement product1;
	
	@FindBy(xpath="//div[@class='actions add-to-cart-buttons']/child :: button[@type='submit']")
	@CacheLookup   
	WebElement addproduct1;
	
	@FindBy(xpath="//span[@class='minicart-messages']/child :: span[.='You added KICKR SMART TRAINER to your shopping cart.']")
	@CacheLookup
	WebElement verify1;
	
	@FindBy(xpath="//a[@id='btn-minicart-close']")
	@CacheLookup
	WebElement back1;
	
	@FindBy(xpath="//a[@title='TICKR Heart Rate Monitor']")
	@CacheLookup
	WebElement product2;
	
	@FindBy(xpath="//select[@name='super_attribute[92]']")
	@CacheLookup
	WebElement color2;
	
	@FindBy(xpath="//div[@class='actions add-to-cart-buttons']/child :: button[@type='submit']")
	@CacheLookup   
	WebElement addproduct2;
	
	@FindBy(xpath="//span[@class='minicart-messages']/child :: span[.='You added TICKR Heart Rate Monitor to your shopping cart.']")
	@CacheLookup
	WebElement verify2;
	
	@FindBy(xpath="//li[@class='item product product-item']/div/div/div[4]/div/a/span")
	@CacheLookup
	WebElement remove1;
	
	@FindBy(xpath="//a[@class='action viewcart']")
	@CacheLookup
	WebElement viewedit;
	
	@FindBy(xpath="//input[@id='cart-1793947-qty']")
	@CacheLookup
	WebElement quantity;
	
	@FindBy(xpath="//button[@class='action update']")
	@CacheLookup
	WebElement updatebutton;
	
	@FindBy(xpath="//button[@title='Proceed to Checkout']")
	@CacheLookup
	WebElement checkout;


	@FindBy(xpath="//button[@title=' Place Order']")
	@CacheLookup
	WebElement placeorder;
	
	@FindBy(xpath="//*[@id=\"s_method_amstrates_amstrates22\"]")
	@CacheLookup
	WebElement shipmentMethod;
	
	@FindBy(xpath="//div[@class='control _with-tooltip']/child :: input[@type=\"email\"]")
	@CacheLookup
	WebElement mail;
	
	@FindBy(xpath="//*[@id=\"FB9T72P\"]")
	@CacheLookup
	WebElement fname;
	
	@FindBy(xpath="//*[@id=\"KQIYTSC\"]")
	@CacheLookup
	WebElement lname;
	
	@FindBy(xpath="//*[@id=\"RS1B4EW\"]")
	@CacheLookup
	WebElement addr;
	@FindBy(xpath="//*[@id=\"OX131FI\"]")
	@CacheLookup
	WebElement phn;
	@FindBy(xpath="//*[@id=\"root\"]/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input")
	@CacheLookup
	WebElement ccard;
	@FindBy(xpath="//*[@id=\"root\"]/form/div/div[2]/span[2]/span/span/input")
	@CacheLookup
	WebElement ccardexp;
	@FindBy(xpath="//*[@id=\"root\"]/form/div/div[2]/span[3]/span/span/input")
	@CacheLookup
	WebElement cvv;
	
	@FindBy(xpath="//*[@id=\"GN4XKF6\"]")
	@CacheLookup
	WebElement country;
	@FindBy(xpath="//*[@id=\"B9C8K7L\"]")
	@CacheLookup
	WebElement postal;
	
	public void productAdd() throws Exception
	{   cookiebutton.click();
		shopbutton.click();
		
		product1.click();
		
		addproduct1.click();
		if(verify1.equals("You added KICKR SMART TRAINER to your shopping cart."))
		{
			System.out.println("Item added successfully and verified");
		}
		back1.click();
        
		//driver.switchTo().defaultContent();
		//wait1();
		driver.navigate().to("https://eu.wahoofitness.com/devices");
		
		product2.click();
	
		Select sel=new Select(color2);
		sel.selectByIndex(1);
		addproduct2.click();
	
		if(verify2.equals("You added TICKR Heart Rate Monitor to your shopping cart."))
		{
			System.out.println("Item 2 added successfully and verified");
		}
		
	}
	public void checkoutp()
	{
		remove1.click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		viewedit.click();
		wait1();
		quantity.clear();
		quantity.sendKeys("2");
		updatebutton.click();
		wait1();
		checkout.click();
		wait1();
		placeorder.click();
		shipmentMethod.click();
	}

	public void shippingaddress(String mailid,String fname1,String lname1,String address1,String phone1,String creditcard1,String exp,String cv)
	{
		wait1();
	mail.sendKeys(mailid);
	fname.sendKeys(fname1);
	lname.sendKeys(lname1);
	addr.sendKeys(address1);
	phn.sendKeys(phone1);
	country.sendKeys("india");
	postal.sendKeys("411052");
	ccard.sendKeys(creditcard1);
	ccardexp.sendKeys(exp);
	cvv.sendKeys(cv);
	placeorder.click();	
	}
/*	public ProductCategory(WebDriver driver)
	{
		this.driver=driver;
	}*/
}
