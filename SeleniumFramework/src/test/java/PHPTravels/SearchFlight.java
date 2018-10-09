package PHPTravels;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Utility.ConfigReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class SearchFlight {
	ExtentTest extest;
	ExtentReports exreport;
	WebDriver driver;
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
	  Thread.sleep(2000);
	  //driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[9]/div[2]/div/div/ins")).click();
	  driver.findElement(By.xpath(conf.FlightRoundTripRdBtn())).click();
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath(conf.FlightFrom())).click();
	  
	  //driver.findElement(By.xpath(".//*[@id='select2-drop']/div/input")).sendKeys("Sydney");
	  driver.findElement(By.xpath(conf.FlightToInput())).sendKeys("Syd");
	  
	  Thread.sleep(4000);
	  
	  //driver.findElement(By.className("select2-result-label")).click();
	  driver.findElement(By.className(conf.FlightToResult())).click();
	  
	  //driver.findElement(By.id("s2id_location_to")).click();
	  driver.findElement(By.id(conf.FlightTo())).click();
	  
	  //driver.findElement(By.xpath(".//*[@id='select2-drop']/div/input")).sendKeys("Delhi");
	  driver.findElement(By.xpath(conf.FlightToInput())).sendKeys("Delhi");
	  
	  Thread.sleep(4000);
	  
	  //driver.findElement(By.className("select2-result-label")).click();
	  driver.findElement(By.className(conf.FlightToResult())).click();
	  
	  //driver.findElement(By.xpath(".//*[@name='departure']")).sendKeys("20/10/2018");
	  driver.findElement(By.xpath(conf.FlightDepDate())).sendKeys("2018-10-20");
	  
	  //driver.findElement(By.xpath(".//*[@name='arrival']")).sendKeys("25/10/2018");
	  driver.findElement(By.xpath(conf.FlightArrivalDt())).sendKeys("2018-10-25");
	  
	  //driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[5]/div/input")).clear();
	  driver.findElement(By.xpath(conf.FlightTravellers())).clear();
	  
	  //driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[5]/div/input")).sendKeys("2");
	  driver.findElement(By.xpath(conf.FlightTravellers())).sendKeys("2");
	  
	  //driver.findElement(By.xpath(".//*[@id='body-section']/div[2]/div/form/div[6]/button")).click();
	  driver.findElement(By.xpath(conf.FlightSearchBtn())).click();
	  
	  //String actVal = driver.findElement(By.xpath(".//*[@id='body-section']/div[4]/div/div[3]/div[1]/div")).getText();
	 
	  String actVal = driver.findElement(By.xpath(conf.FlightAvailableLabel())).getText();
	  extest.log(LogStatus.INFO, actVal);
	  
	  String expVal = "AVAILABLE FLIGHTS";
	  extest.log(LogStatus.INFO, expVal);
	  try {
		  //extest.log(LogStatus.INFO, expVal);
		  assertEquals(expVal, actVal);
		  extest.log(LogStatus.PASS, "Flight Search Performed successfully");
		 // extest.addScreenCapture(extentImage);
	  }catch(Exception e) {
		  extest.log(LogStatus.FAIL, "Flight Search cannot be performed successfully");
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
	  Thread.sleep(8000);
	  WebElement element = driver.findElement(By.xpath(conf.FlightCost()));
	  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	  
	  String flgtCost = driver.findElement(By.xpath(conf.FlightCost())).getText();
	  extest.log(LogStatus.INFO, flgtCost);
	  	  
	  driver.findElement(By.xpath(conf.FlightBookBtn())).click();
	  Thread.sleep(8000);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(conf.FlightBookingCost())));
	  
	  String actflgCost = driver.findElement(By.xpath(conf.FlightBookingCost())).getText();
	  extest.log(LogStatus.INFO, actflgCost);
	  
	  if(actflgCost.contains(flgtCost)) {
		  extest.log(LogStatus.PASS, "Actual and Booking cost are equal" + actflgCost);		  
	  }else {
		  extest.log(LogStatus.FAIL, "Actual and Booking cost are not equal, Actual cost is: " + actflgCost + ", Booking Cost is: " + flgtCost);
	  }
	  //Assert.assertEquals(actflgCost, flgtCost);
	  
	  driver.findElement(By.xpath(conf.FirstName())).sendKeys("tester");
	  driver.findElement(By.xpath(conf.LastName())).sendKeys("testing");
	  driver.findElement(By.xpath(conf.Email())).sendKeys("abcd@gmail.com");
	  driver.findElement(By.xpath(conf.ConfirmEmail())).sendKeys("abcd@gmail.com");
	  driver.findElement(By.xpath(conf.Mobile())).sendKeys("0490684444");
	  driver.findElement(By.xpath(conf.Address())).sendKeys("George Street Parramatta NSW 2150");
	  driver.findElement(By.xpath(conf.Country())).click();
	  driver.findElement(By.xpath(conf.CountryInput())).sendKeys("Australia");
	  driver.findElement(By.xpath(conf.CountrySearchResult())).click();
	  
	  extest.log(LogStatus.INFO, "Entered all the Personal details for Booking Flight");
	  
	  WebElement btn = driver.findElement(By.xpath(conf.BookingConfBtn()));
	  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", btn);
	  
	  driver.findElement(By.xpath(conf.BookingConfBtn())).click();
	  Thread.sleep(10000);
	  assertTrue(driver.findElement(By.xpath(conf.PayNowBtn())).isDisplayed());
	  
	  if (driver.findElement(By.xpath(conf.PayNowBtn())).isDisplayed()) {
		  extest.log(LogStatus.PASS, "Pay Now Btn is displayed");
	  }else {
		  extest.log(LogStatus.FAIL, "Pay Now Btn is not displayed");
	  }
	  
	}

	  
	  @AfterClass
	  public void afterClass() {
		  exreport.endTest(extest);
		  exreport.flush();
		  driver.quit();
	  }
  
}
