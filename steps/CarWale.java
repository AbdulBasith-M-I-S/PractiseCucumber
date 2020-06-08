package steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CarWale{
	
	public static RemoteWebDriver driver;
	public static ChromeOptions options;
	public static WebDriverWait wait ;
	public static Actions builder;
	public static JavascriptExecutor executor;

	
	@Given("Open the Chrome Browser")
	public void openTheChromeBrowser() {
		//Set driver path
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//To use chrome options
		options = new ChromeOptions();
		//To disable notification
		options.addArguments("--disable-notifications");
		//To run in incognito mode
		options.addArguments("--incognito");
	
		//To disable unwanted (non model alert)
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		options.merge(cap);
		
		//To open Chrome Browser
		driver = new ChromeDriver(options);
		//WebDriverWait
		wait= new WebDriverWait(driver,20);
		//Action Class
		builder = new Actions(driver);
		//JavaScripExector
		executor = (JavascriptExecutor)driver;
	}
	
	@Given("Load the url")
	public void loadTheUrl() {
		driver.get("https://www.carwale.com/");
	}
	
	@Given("Maximize the Browser")
	public void maximizeTheBrowser() {
		driver.manage().window().maximize();
		
	}

	@Given("Apply wait")
	public void applyWait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Given("Click on Used")
	public void clickOnUsed() {
	    driver.findElementByXPath("//ul [@class = 'welcome-box__search-option' ]/li[2]").click();
	}

	@Given("Select the city as Chennai")
	public void selectTheCityAsChennai() {
		WebElement eleSelectCity = driver.findElementByXPath("//div[@class = 'used-cars-search' ] /input");
		wait.until(ExpectedConditions.elementToBeClickable(eleSelectCity)).click();
		builder.sendKeys(eleSelectCity,"Chennai").pause(6000).sendKeys(eleSelectCity, Keys.TAB).pause(3000).perform();
	}

	@Given("Select Budjet min 8L and max 12L")
	public void selectBudjetMinLAndMaxL() {
	    driver.findElementById("minInput").sendKeys("8",Keys.TAB);
	    driver.findElementById("maxInput").sendKeys("12",Keys.TAB);
	}

	@Given("Click Search")
	public void clickSearch() {
	    driver.findElementByXPath("//button[@id = 'btnFindCar' ]").click();
	}

	
	@Given("Select Cars with Photos under Only Show Cars With")
	public void selectCarsWithPhotosUnderOnlyShowCarsWith() throws InterruptedException {
		WebElement eleSelectCarsWithPhoto = driver.findElementByName("CarsWithPhotos");
		wait.until(ExpectedConditions.attributeToBe(eleSelectCarsWithPhoto, "name", "CarsWithPhotos"));
		builder.click(eleSelectCarsWithPhoto).pause(3000).perform();
		Thread.sleep(3000);
	}

	@Given("Select Manufacturer as Hyundai")
	public void selectManufacturerAsHyundai(){
	    WebElement eleSelectManufacturer = driver.findElementByXPath("//li [@class = 'us-sprite makeLi' and @data-manufacture-en ='Hyundai']");
	    wait.until(ExpectedConditions.visibilityOf(eleSelectManufacturer));
	    //Use JavaScript Executor 
	    executor.executeScript("arguments[0].click();", eleSelectManufacturer);
	}

	@Given("Select Car as Creta")
	public void selectCarAsCreta(){
	    WebElement eleSelectCarAsCreta = driver.findElementByXPath("//div [@class = 'list-points-models' ]//li [1]");
	    wait.until(ExpectedConditions.visibilityOf(eleSelectCarAsCreta));
	    //Use JavaScript Executor
	    executor.executeScript("arguments[0].click();", eleSelectCarAsCreta);
	}

	@Given("Select Fuel type as Petrol")
	public void selectFuelTypeAsPetrol() {
	    WebElement eleSelectFuelType = driver.findElementByXPath("(//h3 [@class = 'sub-values' ] ) [6]");
	    executor.executeScript("window.scrollBy(0,1000)");
	    wait.until(ExpectedConditions.visibilityOf(eleSelectFuelType));
	    String text = eleSelectFuelType.getText();
	    System.out.println(text);
	    eleSelectFuelType.click();
	    
	    WebElement elePetrol = driver.findElementByXPath("//li[@class = 'us-sprite' and @name = 'Petrol']");
	    wait.until(ExpectedConditions.visibilityOf(elePetrol));
	    String text2 = elePetrol.getText();
	    System.out.println(text2);
	    elePetrol.click();
	
	}
	
	@Given("Select Best Match as KM:Low to High")
	public void selectBestMatchAsKMLowToHigh() {
	    WebElement eleSort = driver.findElementByXPath("//select [@id = 'sort' ]");
	    Select dd = new Select(eleSort);
	    dd.selectByVisibleText("KM: Low to High");
	}

	@Given("Validate the Cards are listed with KMs Low to High")
	public void validateTheCardsAreListedWithKMsLowToHigh() {
	    List<WebElement> eleLowKMRanCar1 = driver.findElementsByXPath("//span [@class = 'slkms vehicle-data__item' ]");
	    List<String> originalOrder = new ArrayList<>();
	  
	    for (int i = 0; i < eleLowKMRanCar1.size(); i++) {
		WebElement eleList = eleLowKMRanCar1.get(i);
		originalOrder.add(eleList.getText());
		}
	    
	    List<WebElement> eleLowKMRanCar2 = driver.findElementsByXPath("//span [@class = 'slkms vehicle-data__item' ]");
	    List<String> sortedOrder = new ArrayList<>();
	    
	    for (int i = 0; i < eleLowKMRanCar2.size(); i++) {
			WebElement eleList = eleLowKMRanCar2.get(i);
			sortedOrder.add(eleList.getText());
			}
	    Collections.sort(sortedOrder);
	    if(originalOrder.equals(sortedOrder)) {
	    	System.out.println("Hence, it listed with KMs Low to High");
	    }
	    
	}

	@Given("Add the least KM ran car to Wishlist")
	public void addTheLeastKMRanCarToWishlist() {
	
	 List<WebElement> eleKMRanCar = driver.findElementsByXPath("//span [@class = 'slkms vehicle-data__item' ]"); 
	 List<String> kmRanCar = new ArrayList<>();   
	 for (int i = 0; i < eleKMRanCar.size(); i++) {
			WebElement eleEachKMRanCar = eleKMRanCar.get(i);
			String eachKMRanCar = eleEachKMRanCar.getText();
			kmRanCar.add(eachKMRanCar);
		}
	    Collections.sort(kmRanCar);
	    String min = Collections.min(kmRanCar);
	    WebElement eleMinKM = driver.findElementByXPath("//span[text() = '"+min+"' ]");
	    String minKM = eleMinKM.getText();
	    WebElement eleMinKMFirstResult = driver.findElementByXPath("(//span [@class = 'slkms vehicle-data__item' ])[1]");
	    String minKMFirstResult = eleMinKMFirstResult.getText();
	    System.out.println(eleMinKMFirstResult);
	    
	    if(minKM.equals(minKMFirstResult)) {
	    driver.findElementByXPath("(//a [@class = 'nomoreTips cur-pointer' ] )[1]").click();
	    WebElement eleClickWishList = driver.findElementByXPath("(//span [@class ='shortlist-icon--inactive shortlist'] ) [1]");	
	    wait.until(ExpectedConditions.visibilityOf(eleClickWishList));
	    System.out.println(eleClickWishList.getText());
	    eleClickWishList.click();
	    }
	    
	}

	@When("Go to Wishlist and Click on More Details")
	public void goToWishlistAndClickOnMoreDetails() {
	    WebElement eleWishList = driver.findElementByXPath("//li [@class = 'action-box shortlistBtn' ]");
	    wait.until(ExpectedConditions.visibilityOf(eleWishList));
	    System.out.println(eleWishList.getText());
	    eleWishList.click();
	    
	    WebElement eleMoreDetails = driver.findElementByXPath("//p[@class = 'font12 margin-top5 slpid' ] /a");
	    wait.until(ExpectedConditions.visibilityOf(eleMoreDetails));
	    System.out.println(eleMoreDetails);
	    eleMoreDetails.click();
	}

	@Then("Print all the details under overview in the same way as displayed in application")
	public void printAllTheDetailsUnderOverviewInTheSameWayAsDisplayedInApplication() {
	    Set<String> allWindows = driver.getWindowHandles();
	    List<String> allHandles = new ArrayList<>(allWindows);
	    for (String eachWindow : allHandles) {
			driver.switchTo().window(eachWindow);
			if(driver.getTitle().equals("Used 2018 Hyundai Creta [2018-2019] SX 1.6 (O) Petrol (D2137306) for sale in Chennai - CarWale")) {
				break;
			}
		}
	    List<WebElement> eleOverview = driver.findElementsByXPath("//div [@id = 'overview']//li/div[@class= 'equal-width text-light-grey']");
	    List<String> overview = new ArrayList<>();
	    for (int i = 0; i < eleOverview.size(); i++) {
	    	WebElement eleOverviewData = eleOverview.get(i);
	    	String overViewData = eleOverviewData.getText();
	    	overview.add(overViewData);
	    }
	    System.out.println(overview);
	    
	}

	@Then("Close the Browser")
	public void closeTheBrowser() {
	    driver.quit();
	    
	}
	
}
