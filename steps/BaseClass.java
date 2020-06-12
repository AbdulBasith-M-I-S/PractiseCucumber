package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public static RemoteWebDriver driver;
	public static ChromeOptions options;
	public static WebDriverWait wait ;
	public static Actions builder;
	public static JavascriptExecutor executor;

}
