package waits;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicit {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get(null);
		//declaring explicit wait
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}

}
