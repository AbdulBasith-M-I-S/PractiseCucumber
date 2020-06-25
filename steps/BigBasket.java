package steps;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BigBasket extends BaseClass{
	
	@Given("Load the url for BigBasket")
	public void loadTheUrlForBigBasket() {
	    driver.get("https://www.bigbasket.com/");
	    
	    
	
	}

	@Given("Mouse over on Shop by Category")
	public void mouseOverOnShopByCategory() {
		
		WebElement eleLocation = driver.findElementByXPath("//span[@class = 'hvc' ]/span[1]");
	    builder.pause(2000).click(eleLocation).pause(2000).perform();
	    
	    WebElement eleCity = driver.findElementByXPath("(//span[@class = 'btn btn-default form-control ui-select-toggle'])[1]");
	    builder.pause(2000).click(eleCity).pause(2000).perform();
	    
	    WebElement eleEnterCity = driver.findElementByXPath("(//input [@type = 'search'] )[1]");
	    builder.pause(2000).sendKeys(eleEnterCity,"Chennai").sendKeys(Keys.TAB).pause(2000).perform();
	    
	    WebElement eleContinue = driver.findElementByXPath("(//button [@name = 'skipandexplore' ] ) [1]");
	    builder.pause(2000).click(eleContinue).pause(2000).perform();
		
		
		
		
		//Category
		
	    WebElement eleCategory = driver.findElementByXPath("//li[@class = 'dropdown full-wid hvr-drop']/a");
	    builder.pause(3000).moveToElement(eleCategory).pause(3000).perform();
	}

	@Given("Go to FOODGRAINS, OIL & MASALA and RICE & RICE PRODUCTS")
	public void goToFOODGRAINSOILMASALAAndRICERICEPRODUCTS() {
	    //driver.findElementByXPath("");
		WebElement eleFoodOilMasala = driver.findElementByXPath("//ul [@id = 'navBarMegaNav' ] /li [2]/a");
		builder.pause(2000).moveToElement(eleFoodOilMasala).pause(1000).perform();
		
		WebElement eleRiceProduct = driver.findElementByXPath("(//a[text() = 'Rice & Rice Products'])[2]");
		builder.pause(2000).moveToElement(eleRiceProduct).pause(1000).perform();
	}

	@Given("Click on BOILED & STEAM RICE")
	public void clickOnBOILEDSTEAMRICE() {
		WebElement eleBoiledSteamRice = driver.findElementByXPath("(//a[text() = 'Boiled & Steam Rice'])[2]");
		builder.pause(2000).moveToElement(eleBoiledSteamRice).click(eleBoiledSteamRice).pause(1000).perform();
	}

	@Given("Get the URL of the page and check with site navigation link\\(HOME > FOODGRAINS, OIL & MASALA> RICE & RICE PRODUCTS> BOILED & STEAM RICE)")
	public void getTheURLOfThePageAndCheckWithSiteNavigationLinkHOMEFOODGRAINSOILMASALARICERICEPRODUCTSBOILEDSTEAMRICE() {
	    System.out.println(driver.getCurrentUrl());
	    List<WebElement> eleNavigationLink1 = driver.findElementsByClassName("breadcrumb-item");
	    for (int i = 0; i < eleNavigationLink1.size(); i++) {
			String text1 = eleNavigationLink1.get(i).getText();
			System.out.println(text1);
		}
	    WebElement eleNavigationLink2 = driver.findElementByXPath("//div [@itemprop = 'child' ] [2]//span");
	    System.out.println(eleNavigationLink2.getText());
	}

	@Given("Choose the Brand as bb Royal")
	public void chooseTheBrandAsBbRoyal() {
		WebElement eleBBRoyal = driver.findElementByXPath("(//span[@class='cr']//i)[3]");
	    builder.pause(3000).moveToElement(eleBBRoyal).click(eleBBRoyal).pause(3000).perform();
	}

	@Given("Go to Ponni Boiled Rice and select 25kg bag from Dropdown")
	public void goToPonniBoiledRiceAndSelectKgBagFromDropdown() {
		boolean result = false;
		int attempts = 0;
	    while(attempts < 5) {
	        try {
	        	WebElement eleSelectKG = driver.findElementByXPath("(//span[text()='(12 - 17 Months Old)'])[1]");
	        	eleSelectKG.getText();
	    	    eleSelectKG.click();
	    	    
	            result = true;
	            break;
	        } catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    
	    while(attempts < 5) {
	        try {
	    	    WebElement eleSelect25KG = driver.findElementByXPath("(//span[text()='(12 - 17 Months Old)'])[4]");
	    	    //wait.until(ExpectedConditions.visibilityOf(eleSelect25KG));
	    	    eleSelect25KG.click();
	    	    
	            result = true;
	            break;
	        } catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    
	    
	}

	@Given("Click Add button")
	public void clickAddButton() {
	    WebElement eleAddButton = driver.findElementByXPath("(//div [@class = 'col-sm-5 col-xs-5 pad-0' ]/button )[2]");
	    builder.pause(3000).moveToElement(eleAddButton).click(eleAddButton).perform();
	    
	    /*WebElement eleContinue = driver.findElementByXPath("(//a[text() = 'Continue' ] )[1]");
	    builder.pause(3000).moveToElement(eleContinue).click(eleContinue).perform();*/
	}

	@Given("Go to search box and type Dal")
	public void goToSearchBoxAndTypeDal() throws InterruptedException {
		Thread.sleep(3000);
		WebElement eleSearchBox = driver.findElementByXPath("//input [@qa = 'searchBar']");
		executor.executeScript("window.scrollBy(0,-500)");
		builder.pause(3000).click(eleSearchBox).sendKeys(eleSearchBox, "Arhar Dal").pause(4000).perform();
		
	}

	@Given("Add Toor or Arhar Dal 2kg and set Qty 2 from the list")
	public void addToorArharDalKgAndSetQtyFromTheList() {
	    WebElement eleQuantity = driver.findElementByXPath("//span[@id = 'basic-addon1'] /following::input[2]");
	    wait.until(ExpectedConditions.visibilityOf(eleQuantity)).click();
	    eleQuantity.clear();
	    builder.pause(3000).sendKeys(eleQuantity, "2").pause(3000).perform();
	    
	    WebElement eleAddButton = driver.findElementByXPath("(//button [@class = 'btn btn-default yellow-btn']) [4]");
	    builder.pause(3000).click(eleAddButton).pause(3000).perform();
	    
	}

	@Given("Click Address")
	public void clickAddress() {
		executor.executeScript("window.scrollBy(0,-500)");
	    WebElement eleAddress = driver.findElementByXPath("//span [ @ng-bind = 'vm.user.currentAddress.city_name']");
	    builder.pause(3000).click(eleAddress).pause(3000).perform();
	    
	    
	    
	}

	@Given("Select Chennai as City, Alandur-600016,Chennai as Area and click Continue")
	public void selectChennaiAsCityAlandurChennaiAsAreaAndClickContinue() {
	    WebElement eleArea = driver.findElementByXPath("(//input [@qa = 'areaInput'] )[1]");
	    builder.pause(3000).click(eleArea).sendKeys(eleArea,"Alandur").pause(3000).sendKeys(eleArea,Keys.TAB).pause(3000).perform();
	    
	    /*WebElement eleClickArea = driver.findElementByXPath("//li[@class = 'ng-scope active']");
	    builder.pause(3000).click(eleClickArea).pause(3000).perform();*/
	    
	    WebElement eleContinue = driver.findElementByXPath("(//button[text() = 'Continue' ] )[1]");
	    builder.pause(3000).moveToElement(eleContinue).click(eleContinue).perform();
	    
	}

	@Given("Mouse over on My Basket take a screen shot")
	public void mouseOverOnMyBasketTakeAScreenShot() {
	    WebElement eleBasket = driver.findElementByXPath("//span[@class = 'basket-content']");
	    builder.pause(3000).moveToElement(eleBasket).perform();
	    
	}

	@When("Click View Basket and Checkout")
	public void clickViewBasketAndCheckout() {
	    WebElement eleViewBasket = driver.findElementByXPath("//button[@qa='viewBasketMB']");
	    builder.pause(3000).click(eleViewBasket).perform();
	}

	@Then("Click the close button and close the browser")
	public void clickTheCloseButtonAndCloseTheBrowser() {
	    WebElement eleClose = driver.findElementByXPath("//span[@class ='login-icon login-icon-close']");
	    builder.pause(3000).click(eleClose).perform();
	    
	    driver.quit();
	}
}
