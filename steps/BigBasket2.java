package steps;



import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class BigBasket2 extends BaseClass{

	@Given("Go to Beverages and Fruit juices & Drinks")
	public void goToBeveragesAndFruitJuicesDrinks() {
	    WebElement eleBeverages = driver.findElementByXPath("(//li[@data-submenu-id ='beverages']/a)[2]");
	    builder.pause(2000).moveToElement(eleBeverages).pause(2000).perform();
	    
	    WebElement eleFreshJuice = driver.findElementByXPath("(//a[text() ='Fruit Juices & Drinks'])[2]");
	    builder.pause(2000).moveToElement(eleFreshJuice).pause(2000).perform();
	
	}

	@Given("Click on JUICES")
	public void clickOnJUICES() {
	    WebElement eleJuice = driver.findElementByXPath("(//a[text() ='Juices'])[2]");
	    builder.pause(2000).click(eleJuice).pause(2000).perform();
	    
	    
	}

	@Given("Click Tropicana and Real under Brand")
	public void clickTropicanaAndRealUnderBrand() {
	    WebElement eleReal = driver.findElementByXPath("(//span[@ng-bind = 'brand.display_name' and text() = 'Real']/preceding-sibling::span/i)[1]");
	    builder.pause(2000).click(eleReal).pause(2000).perform();
	    
	    WebElement eleTropicana = driver.findElementByXPath("(//span[@ng-bind = 'brand.display_name' and text() = 'Tropicana']/preceding-sibling::span/i)[1]");
	    builder.pause(2000).click(eleTropicana).pause(2000).perform();
	    
	}

	@Given("Check count of the products from each Brands and total count")
	public void checkCountOfTheProductsFromEachBrandsAndTotalCount() {
	    List<WebElement> eleTropicana = driver.findElementsByXPath("//h6[@ng-bind ='vm.selectedProduct.p_brand' and text() ='Tropicana']");
	    int count =0;
	    for (int i = 0; i < eleTropicana.size(); i++) {
		String Tropicana = eleTropicana.get(i).getText();
		if (Tropicana.equals("Tropicana")) {
			count++;
		}
	    }
	    System.out.println("Tropicana brand count is "+count);
	    
	    
	    List<WebElement> eleReal = driver.findElementsByXPath("//h6[@ng-bind ='vm.selectedProduct.p_brand' and text() ='Real']");
	    int count2 =0;
	    for (int i = 0; i < eleReal.size(); i++) {
		String Real = eleReal.get(i).getText();
		if (Real.equals("Real")) {
			count2++;
		}
	    }
	    System.out.println("Real brand count is "+count2);
	
	}

	@Given("Check whether the products is availabe with Add button")
	public void checkWhetherTheProductsIsAvailabeWithAddButton() {
	    List<WebElement> eleNotify = driver.findElementsByXPath("//button [@qa ='NM']");
	    try {
			System.out.println("Number of Product without Add button = "+ eleNotify.size());
		} catch (Exception e) {
			System.out.println("All the product has Add Button");
			e.printStackTrace();
		}
	}

	@Given("Add the First listed available product")
	public void addTheFirstListedAvailableProduct() {
	    WebElement eleAddButton = driver.findElementByXPath("(//button [@qa ='add'] )[1]");
	    builder.pause(2000).click(eleAddButton).pause(2000).perform();
	}


	@Given("Mouse over on My Basket print the product name, count and price")
	public void mouseOverOnMyBasketPrintTheProductNameCountAndPrice() {
	    WebElement eleViewBasketIcon = driver.findElementByXPath("//span[@class ='basket-content']");
	    builder.pause(2000).moveToElement(eleViewBasketIcon).pause(2000).perform();
	    
	    WebElement eleProductName = driver.findElementByXPath("//div[@class ='product-name']");
	    System.out.println(eleProductName.getText());
	    
	    WebElement eleCountOfProduct = driver.findElementByXPath("//div[@class ='btn-counter row']/input");
	    System.out.println(eleCountOfProduct.getText());
	    
	    WebElement elePriceOfProduct = driver.findElementByXPath("//span[@qa ='priceMB']");
	    System.out.println(elePriceOfProduct.getText());
	    
	    
	}

	
	
}
