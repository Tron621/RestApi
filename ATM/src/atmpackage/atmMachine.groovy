package atmpackage
import java.lang.String;
import javax.sql.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.*;
import org.openqa.selenium.server.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertTrue;
class atmMachine extends GroovyTestCase{
	public static String  uRL = "https://alttestsite.atlassian.net/login?";
	public static String  uRLCraigslist = "http://austin.craigslist.org/";
	public static String Page = "PageIII";
	private static  WebDriver driver;
	public static String  goturl;
	//public class UsingGoogleSearchPage {
		public static void main(String[] args) {
			// Create a new instance of a driver
			//WebDriver
			driver = new FirefoxDriver();
			//WebElement goturl;
			// Navigate to the right place
			//driver.get(uRL);
			driver.get(uRLCraigslist);
			//assertTrue(driver.getTitle().contains("Craigslist:"));
			driver.manage().window().maximize();
			// and initialise any WebElement fields in it.
			def  page = PageFactory.initElements(driver, atmMachine.class);

			// Page objects
		  
			//page.typeUsername("username");
			//page.typePassword("xanadu");
			//page.submitLogin();
			//page.clickCreateButton("quick-create-page-button");
			//page.createPage("content-title");
			//page.saveNewPage("confirm");
			page.selectMusicalInst("music instr");
			page.clickSearch("guitars");
			page.selectPicview();
			page.selectHomePage(goturl);
			//driver.quit();
		}
		private WebElement username;
		private WebElement password;
		private WebElement login;
	   
		def usernameLocator = By.id("username");
		def passwordLocator = By.id("password");
		def loginButtonLocator = By.id("login");
		def createtextlocator = By.id("quick-create-page-button");
		def typetextlocator = By.id("content-title");
		String queryLocator = "query";
		String thumbnailView = "picview";
		
		    public  selectMusicalInst(String text){
			    goturl = driver.getCurrentUrl();
			    WebElement selectOption = driver.findElement(By.linkText(text));
			    selectOption.click();
			 return goturl;
		}
			public void clickSearch(String text){
				WebElement entertext = driver.findElement(By.id(queryLocator));
				 entertext.sendKeys(text);
				 entertext.sendKeys(Keys.ENTER);
				}
			 public void selectPicview(){
				 WebElement selectPicviewOption = driver.findElement(By.id(thumbnailView));
				  selectPicviewOption.click();
			 }
			 public void selectHomePage(String text){
				 driver.get(text);
				 
			 }
}
