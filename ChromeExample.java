import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeExample {
	
 private static String driverPath = "D:/softwares/development/common/helpers/chromedriver_win32/";
 private static String sUrl = "https://accounts.google.com/ServiceLogin";
 private static String sUserName = "dpmrkt1";
 private static String sPassword = "dpmrkt1";
 private static WebDriver driver;
 
	public static void main(String []args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(sUrl);
		
		WebElement username = driver.findElement(By.id("identifierId"));
		username.clear();
		username.sendKeys(sUserName);
		
		WebElement identifierNext = driver.findElement(By.id("identifierNext"));
		identifierNext.click();
		
		waitForPageLoaded(30);
		
		WebElement password = driver.findElement(By.cssSelector("input[class='whsOnd zHQkBf']"));
		password.clear();
		password.sendKeys(sPassword);
		
		WebElement show = driver.findElement(By.cssSelector("svg[class='VhKI7c']"));
		show.click();
		
		WebElement passwordNext = driver.findElement(By.id("passwordNext"));
		passwordNext.click();
		
	}
	
	public static void waitForPageLoaded(int sec) throws InterruptedException 
	{      
		ExpectedCondition<Boolean> expectation = (WebDriver driver) -> {return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");};
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(expectation);
    }
}