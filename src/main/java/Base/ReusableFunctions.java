package Base;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ReusableFunctions {
	public static WebDriver driver;
	
	public ExtentReports extent;
	public static ExtentTest scenarioDef;
	public static ExtentTest features;

	public static String reportLocation = "<>";
	
	//@To setup browser
	public WebDriver setup(String browserType) throws InterruptedException, IOException{
	    if(browserType.contains("Chrome")){ 
		launchChromeBrowser();
		}
		else if (browserType.contains("InternetExplorer")) {
			launchIEBrowser();
		}
		else{
			//driver = new FirefoxDriver();			
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
		}
	// To launch IE Browser
	void launchIEBrowser(){
			    System.setProperty("webdriver.ie.driver","IEDriverServer3.exe");
			//	InternetExplorerOptions options = new InternetExplorerOptions();
			//	options.introduceFlakinessByIgnoringSecurityDomains();
			//	options.requireWindowFocus();
			//	driver = new InternetExplorerDriver(options); 
		 }
		
		// To launch Chrome Browser
	void launchChromeBrowser(){
			 //ChromeOptions options = new ChromeOptions();
			
			 System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("disable-extensions");
			 options.addArguments("no-sandbox");
			 options.setExperimentalOption("useAutomationExtension", false);
			 
			 driver = new ChromeDriver(options);
		 }
	

	public static String pReader(String property) throws IOException{
		FileReader reader=new FileReader("src/test/resources/login.properties");
		String value= propertyReader(reader, property);
		return value;
	}
	//To read property files
	static String propertyReader(FileReader reader,String property) throws IOException{
		Properties p=new Properties();
		p.load(reader);
		String value=p.getProperty(property);
		reader.close();
		return value;
		}
	
	/*public void setPropertyValue(String filePath,String key, String value ) throws IOException {
		FileOutputStream fos=new FileOutputStream(filePath);
		Properties p=new Properties();
		p.setProperty(key, value);
		fos.close();
		
		}
		*/

	
	
    void scrollToElement(WebDriver driver, WebElement element){
    	//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);	
    	Actions actio= new Actions(driver);
    	actio.moveToElement(element).build().perform();
    }
 // To verify if element is present or not
 		 public void AssertElementIsPresent(WebElement element)
 	        {
 	            try
 	            {
 	                org.junit.Assert.assertEquals(true, IsElementPresent(element));

 	            }catch (Exception e)
 	            {
 	                System.out.println(("Test Failed, No element {0} is found "));
 	                //Reporter.log(element+" is not peesent on page");
 	                throw e;
 	            }
 	        }
 		// This Method makes sure that the test case will not fail unless its absolutely necessary. Returns a true or false to AssertElement is Presesent Method
 	        public boolean IsElementPresent(WebElement element)
 	        {
 	            boolean Present = false;
 	            try
 	            {
 	                 if (element.isDisplayed())
 	                {
 	                    Present = true;
 	                    System.out.println("Element Is Seen");
 	                }

 	                else
 	                {
 	                    if (element.isDisplayed())
 	                    { Present = true; }
 	                }
 	                return Present;
 	            }catch (NoSuchElementException E)
 	            {
 	                System.out.println("No Such Element : {0}");
 	                return false;
 	            }
 	        }
 	       
 	       public static boolean isFileDownloaded_Ext(String dirPath, String ext){
 	  		boolean flag=false;
 	  	    File dir = new File(dirPath);
 	  	    File[] files = dir.listFiles();
 	  	    if (files == null || files.length == 0) {
 	  	        flag = false;
 	  	    }
 	  	    
 	  	    for (int i = 1; i < files.length; i++) {
 	  	    	if(files[i].getName().contains(ext)) {
 	  	    		flag=true;
 	  	    	}
 	  	    }
 	  	    return flag;
 	  	}
 	        
 	       public static void windowsTab() throws IOException {
 	    	//get window handlers as list
 	    	  List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
 	    	  //switch to new tab
 	    	  driver.switchTo().window(browserTabs .get(1));
 	    	  String URL = driver.getCurrentUrl();
 	    	  String PdfUrl = pReader("pdfurl");
 	    	  org.junit.Assert.assertEquals(URL,PdfUrl);
 	    	  //driver.close();
 	    	  driver.switchTo().window(browserTabs.get(0));
 	      }
 	      public static void getReportConfigPath() throws IOException{
 	    	  	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
 	    	  	// initialize ExtentReports and attach the HtmlReporter
 	    	  	ExtentReports extent = new ExtentReports();
 	    	  	// attach only HtmlReporter
 	    	  	extent.attachReporter(htmlReporter);
 	    	//  	htmlReporter.flush();
 	    		
 	    	  	//String reportConfigPath = pReader("reportConfigPath");
 	    		//if(reportConfigPath!= null) return reportConfigPath;
 	    		//else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
 	    	}   
 	       
 	     public String GetCurrentDateTime(){
 			DateFormat dateTimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 			Date date = new Date();
 			String CurrentDate = dateTimeFormat.format(date); 
 			return CurrentDate; 
 		}
 	     
 	  //Read html file
 		 public String readHtmlFile(String filePath) {
 	    	  StringBuilder contentBuilder = new StringBuilder();
 		    	  try {
 		    	      BufferedReader in = new BufferedReader(new FileReader(filePath));
 		    	      String str;
 		    	      while ((str = in.readLine()) != null) {
 		    	          contentBuilder.append(str);
 		    	      }
 		    	      in.close();
 		    	  } catch (IOException e) {
 		    	  }
 		      String Htmlcontent = contentBuilder.toString();
 		      //Htmlcontent= Htmlcontent.split("<h1>Test</h1>")[0]+"</body></html>";
 		 	return Htmlcontent;
 			 
 		 } 
 		 
 		//Random number generator
 		 public int randomNumberGenerator () {
 			Random rand = new Random();
 			// Generate random integers in range 0 to 9999 
 	        int rand_int = rand.nextInt(10000);
 	        return rand_int;
 		 }
 		 
 	      
}
