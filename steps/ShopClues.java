package steps;



import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShopClues extends BaseClass{
	
	@Given("Load the url for ShopClues")
	public void loadTheUrlForShopClues() {
	    driver.get("https://www.shopclues.com/");
	    
	}

	@Given("Mouseover on women and click Casual Shoes")
	public void mouseoverOnWomenAndClickCasualShoes() {
	    WebElement eleDenyNotification = driver.findElementByXPath("(//div [@class = 'moe-button-wrapper']/button)[1]");
	    wait.until(ExpectedConditions.visibilityOf(eleDenyNotification));
	    builder.pause(2000).click(eleDenyNotification).pause(2000).perform();
	    
	    WebElement eleWomenTab = driver.findElementByXPath("//li [@id = 'nav_42']/a");
	    wait.until(ExpectedConditions.visibilityOf(eleWomenTab));
	    builder.click(eleWomenTab).perform();
	    
	    WebElement eleCasualShoe = driver.findElementByXPath("(//a[text() = 'Casual Shoes'] )[1]");
	    wait.until(ExpectedConditions.visibilityOf(eleCasualShoe));
	    builder.click(eleCasualShoe).pause(2000).perform();
	}

	@Given("Select Color as Black")
	public void selectColorAsBlack() {
	    Set<String> allWindows = driver.getWindowHandles();
	    List<String> allHandles = new ArrayList<>(allWindows);
	    for (String eachWindow : allHandles) {
			driver.switchTo().window(eachWindow);
			if(driver.getCurrentUrl().equals("Women Casual Shoes - Buy Casual Shoes for Women Online at Low Prices in India")) {
				break;
			}
		}
	    
	    WebElement eleBlack = driver.findElementByXPath("(//input[@id = 'Black']/following::label)[1]");
	    wait.until(ExpectedConditions.visibilityOf(eleBlack));
	    executor.executeScript("window.scrollBy(0,3000)");
	    eleBlack.getText();
	    executor.executeScript("arguments[0].click();", eleBlack);
	    //eleBlack.getText();
	    //eleBlack.click();
	    //builder.pause(2000).click(eleBlack).pause(2000).perform();
	    
	    
	    
	}

	@Given("Check whether the product name contains the word black")
	public void checkWhetherTheProductNameContainsTheWordBlack() {
	    WebElement eleFilterBlack = driver.findElementByXPath("//div [@class = 'add_fliters_list']//li/span");
	    System.out.println("The Filter color is "+ eleFilterBlack.getText());
	    List<String> list1 = new ArrayList<>();
	    List<WebElement> eleShoeDescription = driver.findElementsByXPath("//span[@class = 'prod_name ']");
	    for (int i = 0; i < eleShoeDescription.size(); i++) {
			WebElement eleEachShoeDescription = eleShoeDescription.get(i);
			String eachShoeDescription = eleEachShoeDescription.getText();
			list1.add(eachShoeDescription);
		}
	    if(list1.contains("Black")) {
	    	System.out.println("Hence, The product contains the word black");
	    }
	    
	}

	@Given("If so, add the product name and price in to Map")
	public void ifSoAddTheProductNameAndPriceInToMap() {
	    
	    List<WebElement> eleShoeBrandName = driver.findElementsByXPath("//span[@class = 'prod_name ']");
	   
	    
	    List<WebElement> eleShoePrice = driver.findElementsByXPath("//span [@class = 'p_price']");
	    
	    Map<String, String> map1 =new LinkedHashMap<>();
	    for(int i=1;i<=eleShoeBrandName.size();i++) {
	    	String namexpath = "(//span[@class = 'prod_name '])[" +i+  "]";
	    	String name = driver.findElementByXPath(namexpath).getText();
	    	if(name.toLowerCase().contains("black")){
	    		String pricexpath = namexpath + "/following-sibling::div[1]/div[1]/span[1]";
	    		String price = driver.findElementByXPath(pricexpath).getText();
	    		String  priceamt = price.replaceAll("[^0-9]", "");
	    		map1.put(name,priceamt);
	    	}
	    }

	    System.out.println(map1);
	    
	    
	    
	}

	@Given("Check Display the count of shoes which are more than 500 rupees")
	public void checkDisplayTheCountOfShoesWhichAreMoreThanRupees() {
	    
		List<WebElement> eleShoePrice = driver.findElementsByXPath("//span [@class = 'p_price']");
		int price =0;
		
		for (int i = 0; i < eleShoePrice.size(); i++) {
			String shoePrice = eleShoePrice.get(i).getText();
			int priceNum = Integer.parseInt(shoePrice.replaceAll("\\D", ""));
			if(priceNum>500) {
				price = price+1;
			}
		}
		
		/*for (WebElement eachShoePrice : eleShoePrice) {
			String shoePrice = eachShoePrice.getText();
			int priceNum = Integer.parseInt(shoePrice.replaceAll("\\D", ""));
			if(priceNum>500) {
				price=price+1;
			}
		}*/
		
		System.out.println("The count of shoes which are more than 500 rupees are: " + price );
	}


	@Given("Click the highest price of the shoe")
	public void clickTheHighestPriceOfTheShoe() {
		List<WebElement> eleShoePrice = driver.findElementsByXPath("//span [@class = 'p_price']");
		Set<Integer> allShoePrices = new LinkedHashSet<>(); 
		for (int i = 0; i < eleShoePrice.size(); i++) {
			String eachShoePrice = eleShoePrice.get(i).getText();
			int priceNum = Integer.parseInt(eachShoePrice.replaceAll("\\D", ""));
			allShoePrices.add(priceNum);
			
		}
		System.out.println(allShoePrices);
		Collections.max(allShoePrices);
	    
		WebElement eleHighestShoePrice = driver.findElementByXPath("//span[@class = 'p_price' and text() ='Rs."+Collections.max(allShoePrices)+"']");
		builder.pause(3000).click(eleHighestShoePrice).perform();
	}

	@Given("Get the current page URL and check with the product ID")
	public void getTheCurrentPageURLAndCheckWithTheProductID() {
		Set<String> allWindows = driver.getWindowHandles();
	    List<String> allHandles = new ArrayList<>(allWindows);
	    for (String eachWindow : allHandles) {
			driver.switchTo().window(eachWindow);
			if(driver.getCurrentUrl().equals(" Buy Bapu Beta Women's Leather Loafers Comfort Slip on Flats Shoes Online - Get  50% Off ")) {
				break;
			}
		}
		
		List<String> list1 = new ArrayList<>();
		
		String currentUrl = driver.getCurrentUrl();
	    System.out.println(currentUrl);
	    WebElement eleProductId = driver.findElementByXPath("//span[@class = 'pID' ]/a");
	    String productId = eleProductId.getText();
	    System.out.println(productId);
	    //https://www.shopclues.com/bapu-beta-womens-leather-loafers-comfort-slip-on-flats-shoes-141405783.html
	    list1.add(currentUrl);
	    if(list1.contains(productId)) {
	    	System.out.println("The current page URL contains current product ID");
	    }
	    
	}

	@Given("Copy the offercode")
	public void copyTheOffercode() {
	    WebElement eleOfferCode = driver.findElementByXPath("(//div[@class = 'coupons_code']/span )[1]");
	    String offerCode = eleOfferCode.getText();
	    System.out.println("The offer code is "+ offerCode);
	}

	@Given("Select size, color and click ADD TO CART")
	public void selectSizeColorAndClickADDTOCART() {
	    WebElement eleColor = driver.findElementByXPath("//span [@tooltip = 'Black']");
	    builder.pause(3000).click(eleColor).perform();
	    WebElement eleSize = driver.findElementByXPath("//a[@id = 'getSC']/preceding-sibling::span");
	    builder.pause(3000).click(eleSize).perform();
	    WebElement eleAddToCart = driver.findElementById("add_cart");
	    builder.pause(3000).click(eleAddToCart).perform();
	}

	@When("Mouse over on Shopping cart and click View Cart")
	public void mouseOverOnShoppingCartAndClickViewCart() {
	    WebElement eleCart = driver.findElementByXPath("//li [@class = 'qCart']/a");
	    builder.pause(3000).moveToElement(eleCart).perform();
	    WebElement eleViewCart = driver.findElementByXPath("//div [@class ='buttonContainer']/a [1]");
	    builder.pause(3000).click(eleViewCart).perform();
	}

	@Then("Type Pincode as {int} click Submit and Place Order and Close the Browser")
	public void typePincodeAsClickSubmitAndPlaceOrderAndCloseTheBrowser(Integer int1) {
	    WebElement elePincode = driver.findElementByXPath("//span [@class = 'pincode_input'] /input");
	    builder.pause(3000).sendKeys(elePincode, "600016").perform();
	    
	    WebElement elePlaceOrder = driver.findElementByXPath("//div [@class = 'btn orange']");
	    builder.pause(3000).click(elePlaceOrder).perform();
	}
	

}
