package selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

ExtentReports extent;

@BeforeTest

public void config()

{

// ExtentReports , ExtentSparkReporter

String path =System.getProperty("user.dir")+"\\reports\\index.html";

ExtentSparkReporter reporter = new ExtentSparkReporter(path);

reporter.config().setReportName("Web Automation Results");

reporter.config().setDocumentTitle("Test Results");

extent =new ExtentReports();

extent.attachReporter(reporter);

extent.setSystemInfo("Tester", "Rahul Shetty");

}

@Test

public void initialDemo()

{

ExtentTest test= extent.createTest("Initial Demo");

System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM\\Drivers\\chromedriver.exe"); test.info("driver is set");

WebDriver driver =new ChromeDriver();

driver.get("https://rahulshettyacademy.com"); test.info("website is launched");

System.out.println(driver.getTitle());test.info("title is fetched");

driver.close(); test.info("driver is closed");

test.error("thiss is error");

//test.fail("Result do not match");

extent.flush();

}

}



