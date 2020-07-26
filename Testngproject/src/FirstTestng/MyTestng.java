package FirstTestng;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyTestng extends ObjectRepository {
	
	String path = "C:\\Users\\663977\\Downloads\\chromedriver_win32\\chromedriver.exe";
	static WebDriver driver = null;
	 //Trail for commit
	
	@BeforeClass
	public void driver() {

		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();

	}

	@Test(priority = 1)
	public void Tabmenuselection() throws IOException {

		driver.findElement(Lmobile).click();
		//driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Screenshot.Takesnap("Tabselection");
	}

	@Test(priority = 0)
	public void launchurl() throws InterruptedException, IOException {
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);

		driver.manage().window().maximize();
		Screenshot.Takesnap("Launchurl");

	}
	@Test(priority = 3)
	public void selectvalue() throws IOException {
		
		Actions action = new Actions(driver);
		WebElement dropdown = driver.findElement(Ldrop);
		action.moveToElement(dropdown).click().build().perform();
		Screenshot.Takesnap("Dropdown");

		Select select = new Select(dropdown);
		select.selectByVisibleText("Newest Arrivals");
		driver.manage().timeouts().implicitlyWait(19, TimeUnit.SECONDS);
		Screenshot.Takesnap("dropdownResults");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void searchbox() throws InterruptedException, IOException {

		driver.findElement(Ltextbox).clear();
		driver.findElement(Ltextbox).sendKeys("Samsung");
		Thread.sleep(2000);
		Screenshot.Takesnap("Searchbox");

		WebElement elesearch = driver.findElement(Lsearch);
		elesearch.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Screenshot.Takesnap("SearchResults");
	}

	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
