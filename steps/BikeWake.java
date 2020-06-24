package steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BikeWake extends BaseClass{

	@Given("Load the url for BikeWale")
	public void loadTheUrlForBikeWale() {
	    driver.get("https://www.bikewale.com/");
	    
	}

	@Given("Go to menu and click new bikes")
	public void goToMenuAndClickNewBikes() {
	    WebElement eleMenu = driver.findElementByXPath("//span [@class = 'navbarBtn nav-icon']");
	    builder.pause(2000).click(eleMenu).pause(2000).perform();
	    
	    WebElement eleNewBike = driver.findElementByXPath("//span [@class = 'navbarTitle' and text() = 'New Bikes']");
	    builder.pause(2000).click(eleNewBike).pause(2000).perform();
	
	}

	@Given("Click New Bikes Then compare bikes")
	public void clickNewBikesThenCompareBikes() {
	    WebElement eleCompareBike = driver.findElementByXPath("//a[@title ='Compare Bikes']");
	    
	    builder.pause(2000).click(eleCompareBike).pause(2000).perform();
	    
	    
	    
	}

	@Given("Add first bike as Royal Enfield and model as Thunderbird 350")
	public void addFirstBikeAsRoyalEnfieldAndModelAsThunderbird() {
	    
	    WebElement eleAddBike1 = driver.findElementByXPath("(//span [@class = 'add-icon'] )[1]");
	    builder.pause(2000).click(eleAddBike1).pause(2000).perform();
	    
	    WebElement eleBrand = driver.findElementByXPath("//div[@class ='chosen-container chosen-container-single']");
	    builder.pause(2000).click(eleBrand).pause(2000).perform();
	
	    WebElement eleRoyalEnfield = driver.findElementByXPath("(//li[@class ='active-result' or text()='Royal Enfield' ] )[1]");
	    builder.pause(2000).click(eleRoyalEnfield).pause(2000).perform();
	    
	    WebElement eleModel = driver.findElementByXPath("//p[@class = 'select-label' and text() = 'model']");
	    builder.pause(2000).click(eleModel).pause(2000).perform();
	    
	    WebElement eleTypeBrand = driver.findElementByXPath("(//div[@class ='chosen-search'] )[2]");
	    builder.pause(2000).click(eleTypeBrand).sendKeys(eleTypeBrand, "Thunderbird",Keys.TAB).pause(2000).perform();
	    
	
	}

	@Given("Add second bike Jawa, model as 42 and version Dual Channel ABS - BS VI")
	public void addSecondBikeJawaModelAsAndVersionDualChannelABSBSVI() {
		
		
	    WebElement eleAddBike2 = driver.findElementByXPath("(//span[@class ='add-icon'] )[2]");
	    builder.pause(2000).click(eleAddBike2).pause(2000).perform();
	    
	    WebElement eleBrand2 = driver.findElementByXPath("(//div[@class = 'chosen-container chosen-container-single'])[4]");
	    builder.pause(2000).click(eleBrand2).pause(2000).perform();
	    
	    WebElement eleJawa = driver.findElementByXPath("(//li[@class ='active-result' and text()='Jawa' ] )[2]");
	    builder.pause(2000).click(eleJawa).pause(2000).perform();
	  
	    WebElement eleModel2 = driver.findElementByXPath("(//p[@class = 'select-label' and text() = 'model'])[2]");
	    builder.pause(2000).click(eleModel2).pause(2000).perform();
	    
	    WebElement eleTypeBrand = driver.findElementByXPath("(//div[@class ='chosen-search'] )[5]");
	    builder.pause(2000).click(eleTypeBrand).sendKeys(eleTypeBrand, "42",Keys.TAB).pause(2000).perform();
	    
	    
	    WebElement eleVersion = driver.findElementByXPath("(//p[@class = 'select-label' and text() = 'version'])[2]");
	    builder.pause(2000).click(eleVersion).pause(2000).perform();
	    
	    WebElement eleTypeJawaVersion = driver.findElementByXPath("(//div[@class ='chosen-search'] )[6]");
	    builder.pause(2000).click(eleTypeJawaVersion).sendKeys(eleTypeJawaVersion, "Dual Channel ABS - BS VI",Keys.TAB).pause(2000).perform();
	    
	}

	@Given("Add bike brand Kawasaki model as Ninja 300")
	public void addBikeBrandKawasakiModelAsNinja() {
		WebElement eleAddBike3 = driver.findElementByXPath("(//span[@class ='add-icon'] )[3]");
	    builder.pause(2000).click(eleAddBike3).pause(2000).perform();
	    
	    WebElement eleBrand3 = driver.findElementByXPath("(//div[@class = 'chosen-container chosen-container-single'])[7]");
	    builder.pause(2000).click(eleBrand3).pause(2000).perform();
	    
	    WebElement eleKawasaki = driver.findElementByXPath("(//li[@class ='active-result' and text()='Kawasaki' ] )[3]");
	    builder.pause(2000).click(eleKawasaki).pause(2000).perform();
	  
	    WebElement eleModel3 = driver.findElementByXPath("(//p[@class = 'select-label' and text() = 'model'])[3]");
	    builder.pause(2000).click(eleModel3).pause(2000).perform();
	    
	    WebElement eleTypeBrand = driver.findElementByXPath("(//div[@class ='chosen-search'] )[8]");
	    builder.pause(2000).click(eleTypeBrand).sendKeys(eleTypeBrand, "Ninja 300",Keys.TAB).pause(2000).perform();
	    
	    
	}

	@When("Click compare")
	public void clickCompare() {
	    WebElement eleCompare = driver.findElementByXPath("//button [@id = 'btnCompare']");
	    builder.pause(2000).click(eleCompare).pause(2000).perform();
	    
	    
	}

	@Then("Find and print the maximum overall rating of all the bikes and find the max")
	public void findAndPrintTheMaximumOverallRatingOfAllTheBikesAndFindTheMax() {
	    List<WebElement> eleOverallRating = driver.findElementsByXPath("//span[@class ='font20 font-bold']");
	    List<String> list = new ArrayList<>();
	    for (int i = 0; i < eleOverallRating.size(); i++) {
			String rating = eleOverallRating.get(i).getText();
			System.out.println(rating);
			list.add(rating);
		}
	    System.out.println("The maximum rating is "+ Collections.max(list));
	    
	    driver.quit();
	    
	}
	
}
