package ddtesting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utilities.RowColUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
public class FixedDeposit {
	public static void main(String[] args)throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		driver.manage().window().maximize();
		String file=System.getProperty("user.dir")+"/testdata/data.xlsx";
		int rows=RowColUtility.getRowCount(file,"Sheet1");
		int cols=RowColUtility.getCellCount(file,"Sheet1",0);
		for(int i=1;i<=rows;i++) {
			String princ=RowColUtility.getCellData(file,"Sheet1",i,0);
			String roi=RowColUtility.getCellData(file,"Sheet1",i,1);
			String per1=RowColUtility.getCellData(file,"Sheet1",i,2);
			String per2=RowColUtility.getCellData(file,"Sheet1",i,3);
			String freq=RowColUtility.getCellData(file,"Sheet1",i,4);
			for(int j=0;j<cols;j++) {
				driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(princ);
				driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(roi);
				driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
				WebElement drop_year=driver.findElement(By.xpath("//*[@id=\"tenurePeriod\"]"));
				WebElement drop_freq=driver.findElement(By.xpath("//select[@id='frequency']"));
				Select p=new Select(drop_year);
				Select f=new Select(drop_freq);
				p.selectByVisibleText(per2);
				f.selectByVisibleText(freq);
				WebElement calc=driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]"));
				WebElement clear=driver.findElement(By.xpath(""));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();",calc);
		}

		}

	}

}
