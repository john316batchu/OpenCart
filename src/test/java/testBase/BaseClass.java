package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger log;
	public Properties prop;
	
	public BaseClass() throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		prop=new Properties();
		prop.load(fis); 
		
	}
	

	@Parameters({"browser"})
	@BeforeClass(groups= {"sanity","master","regression"})
	public void setUp(String br) throws IOException {
	
		if(br.equals("Chrome")) {
			driver=new ChromeDriver();
		}else if(br.equals("Edge")) {
		driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log=LogManager.getLogger(this.getClass());
	}
	
	@AfterClass(groups= {"sanity","master","regression"})
	public void tearDown() {
	//	driver.quit();		
	}
	
	public String generateRandomString() {
		String randomString=RandomStringUtils.randomAlphabetic(5);
		return randomString;
	}
	
	public String generateRandomNumber() {
		String randomNumber=RandomStringUtils.randomNumeric(5);
		return randomNumber;
	}
	
	public String generateRandomAlphaNumeric() {
		String randomAlphaNumeric=RandomStringUtils.randomAlphanumeric(8);
		return randomAlphaNumeric;
	}
	
	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot screenshot =(TakesScreenshot)driver;
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		String filepath=new String(System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png");
		
		try {
			FileUtils.copyFile(source, new File(filepath));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filepath;
	}
	
	

}
