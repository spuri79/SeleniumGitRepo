package PHPTravels;

import org.testng.annotations.Test;

import com.Utility.ConfigReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SearchHotel {
  
	public static WebDriver driver;
	ExtentTest extest;
	ExtentReports exreport;
	ConfigReader conf = new ConfigReader();

	
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ADITLT22\\eclipse-workspace\\SeleniumFramework\\Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  //Thread.sleep(20000);
  }
 
	
	
  @Test
  public void searchHotel() throws InterruptedException {
	  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HHmmss");
	  Date date = new Date();
	  String extentReport = "C:\\Users\\ADITLT22\\eclipse-workspace\\SeleniumFramework\\ExtentReport\\ExtentReportResults" + dateFormat.format(date) + ".html";
	  
	  exreport = new ExtentReports(extentReport, true);
	  
	  extest = exreport.startTest("Search flight");
	  driver.navigate().to("https://www.phptravels.net/");
	  extest.log(LogStatus.PASS, "PHP Travels URL fetched");
	  try {
		  Assert.assertTrue(driver.getTitle().contains("PHP"));
		  extest.log(LogStatus.PASS, "Title Verified");
		
	  }catch(Exception e){
		  extest.log(LogStatus.FAIL, "Title is incorrect");
		
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  try {
		   FileUtils.copyFile(src, new File("C:\\Users\\ADITLT22\\eclipse-workspace\\SeleniumFramework\\ExtentReport\\ExtentReportResults" + dateFormat.format(date) + ".png"));
		   
		  } catch (IOException e1) {
		   e1.printStackTrace();
		  }
	  }
	  //WebElement inpfield = driver.findElement(By.className("select2-chosen"));
	  WebElement inpfield = driver.findElement(By.className(conf.HotelSearchTextBox()));
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", inpfield);
	  
	  //driver.findElement(By.className("select2-chosen")).click();
	  driver.findElement(By.className(conf.HotelSearchTextBox())).click();
	  
	  //driver.findElement(By.xpath(".//*[@id='select2-drop']/div/input")).sendKeys("Marriot");
	  driver.findElement(By.xpath(conf.HotelNameEnterValue())).sendKeys("Marriot");
	  
	  Thread.sleep(3000);
	  
	  //driver.findElement(By.xpath("//*[@id='select2-drop']/ul/li/ul/li/div/span")).click();
	  driver.findElement(By.xpath(conf.HotelNameSelectValue())).click();
	  
	  //driver.findElement(By.xpath(".//*[@id='dpd1']/div/input")).sendKeys("20/10/2018");
	  driver.findElement(By.xpath(conf.HotelChkInDate())).sendKeys("20/10/2018");
	  
	  //driver.findElement(By.xpath(".//*[@id='dpd2']/div/input")).sendKeys("25/10/2018");
	  driver.findElement(By.xpath(conf.HotelChkOutDate())).sendKeys("25/10/2018");
	  
	 //driver.findElement(By.id("travellersInput")).click();
	  driver.findElement(By.id(conf.HotelGuestField())).click();
	  
	  //driver.findElement(By.id("adultInput")).clear();
	  driver.findElement(By.id(conf.HotelAdultGuest())).clear();
	  
	  //driver.findElement(By.id("adultInput")).sendKeys("3");
	  driver.findElement(By.id(conf.HotelAdultGuest())).sendKeys("3");
	  
	  //driver.findElement(By.id("childInput")).clear();
	  driver.findElement(By.id(conf.HotelChildGuest())).clear();
	  
	  //driver.findElement(By.id("childInput")).sendKeys("2");
	  driver.findElement(By.id(conf.HotelChildGuest())).sendKeys("2");
	  
	  //driver.findElement(By.xpath(".//*[@id='HOTELS']/form/div[5]/button")).click();
	  driver.findElement(By.xpath(conf.HotelSearchBtn())).click();
	  
	  //String stractlabel =driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/div/div[2]/div/span[1]/strong/span")).getText();
	  String stractlabel =driver.findElement(By.xpath(conf.HotelNameLabel())).getText();
	  
	  String strexplabel = "ISLAMABAD MARRIOTT HOTEL";
	  try {
		  assertEquals(stractlabel,strexplabel);
		  extest.log(LogStatus.PASS, "Hotel Search Performed successfully");
		 // extest.addScreenCapture(extentImage);
	  }catch(Exception e) {
		  extest.log(LogStatus.FAIL, "Hotel Search cannot be performed successfully");
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  try {
		   FileUtils.copyFile(src, new File("C:\\Users\\ADITLT22\\eclipse-workspace\\SeleniumFramework\\ExtentReport\\ExtentReportResults" + dateFormat.format(date) + ".png"));
		  // String file = extest.addScreenCapture(extentImage);
		   
		  } catch (IOException e2) {
		   e2.printStackTrace();
		  }
		  //extest.addScreenCapture(extentImage);
	  }
	  
  }
  
  /*
  @Test
  public void searchFlight() throws InterruptedException {
	  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HHmmss");
	  Date date = new Date();
	  String extentReport = "C:\\Users\\ADITLT22\\eclipse-workspace\\SeleniumFramework\\ExtentReport\\ExtentReportResults" + dateFormat.format(date) + ".html";
	  
	  exreport = new ExtentReports(extentReport, true);
	  
	  extest = exreport.startTest("Search flight");
	  driver.navigate().to("https://www.phptravels.net/");
	  extest.log(LogStatus.PASS, "PHP Travels URL fetched");
	  
	  try {
		  Assert.assertTrue(driver.getTitle().contains("PHP"));
		  extest.log(LogStatus.PASS, "Title Verified");
		
	  }catch(Exception e){
		  extest.log(LogStatus.FAIL, "Title is incorrect");
		
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  try {
		   FileUtils.copyFile(src, new File("C:\\Users\\ADITLT22\\eclipse-workspace\\SeleniumFramework\\ExtentReport\\ExtentReportResults" + dateFormat.format(date) + ".png"));
		   
		  } catch (IOException e1) {
		   e1.printStackTrace();
		  }
	  }
	  //driver.findElement(By.xpath(".//*[@id='collapse']/ul[1]/li[3]/a")).click();
	  driver.findElement(By.xpath(conf.FlightLink())).click();
	  //driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[9]/div[2]/div/div/ins")).click();
	  driver.findElement(By.xpath(conf.FlightSearchTxtBox())).click();
	  //WebElement data = driver.findElement(By.id("s2id_location_from"));
	  //JavascriptExecutor js = (JavascriptExecutor) driver;
	  //js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", data);
	  
	  //driver.findElement(By.id("s2id_location_from")).click();
	  driver.findElement(By.id(conf.FlightFrom())).click();
	  
	  //driver.findElement(By.xpath(".//*[@id='select2-drop']/div/input")).sendKeys("Sydney");
	  driver.findElement(By.xpath(conf.FlightToInput())).sendKeys("Sydney");
	  
	  Thread.sleep(4000);
	  
	  //driver.findElement(By.className("select2-result-label")).click();
	  driver.findElement(By.className(conf.FlightToResult())).click();
	  
	  //driver.findElement(By.id("s2id_location_to")).click();
	  driver.findElement(By.id(conf.FlightTo())).click();
	  
	  //driver.findElement(By.xpath(".//*[@id='select2-drop']/div/input")).sendKeys("Delhi");
	  driver.findElement(By.xpath(conf.FlightToInput())).sendKeys("Delhi");
	  
	  Thread.sleep(8000);
	  
	  //driver.findElement(By.className("select2-result-label")).click();
	  driver.findElement(By.className(conf.FlightToResult())).click();
	  
	  //driver.findElement(By.xpath(".//*[@name='departure']")).sendKeys("20/10/2018");
	  driver.findElement(By.xpath(conf.FlightDepDate())).sendKeys("20/10/2018");
	  
	  //driver.findElement(By.xpath(".//*[@name='arrival']")).sendKeys("25/10/2018");
	  driver.findElement(By.xpath(conf.FlightArrivalDt())).sendKeys("25/10/2018");
	  
	  //driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[5]/div/input")).clear();
	  driver.findElement(By.xpath(conf.FlightTravellers())).clear();
	  
	  //driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[5]/div/input")).sendKeys("2");
	  driver.findElement(By.xpath(conf.FlightTravellers())).sendKeys("2");
	  
	  //driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[6]/button")).click();
	  driver.findElement(By.xpath(conf.FlightSearchBtn())).click();
	  
	  //String actVal = driver.findElement(By.xpath(".//*[@id='body-section']/div[4]/div/div[3]/div[1]/div")).getText();
	  String actVal = driver.findElement(By.xpath(conf.FlightAvailableLabel())).getText();
	  
	  String expVal = "AVAILABLE FLIGHTS";
	  try {
		  assertEquals(expVal, actVal);
		  extest.log(LogStatus.PASS, "Search Performed successfully");
		 // extest.addScreenCapture(extentImage);
	  }catch(Exception e) {
		  extest.log(LogStatus.FAIL, "Search cannot be performed successfully");
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  try {
		   FileUtils.copyFile(src, new File("C:\\Users\\ADITLT22\\eclipse-workspace\\SeleniumFramework\\ExtentReport\\ExtentReportResults" + dateFormat.format(date) + ".png"));
		  // String file = extest.addScreenCapture(extentImage);
		   
		  } catch (IOException e2) {
		   e2.printStackTrace();
		  }
		  //extest.addScreenCapture(extentImage);
	  }
	  
	  
	}
*/
  
  @AfterClass
  public void afterClass() {
	  exreport.endTest(extest);
	  exreport.flush();
	  driver.quit();
  }

}
