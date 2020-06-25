package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Shein extends BaseClass{

	@Given("Load the url for shein")
	public void loadTheUrlForShein() {
	    driver.get("https://www.shein.in/");
	    
	}

	@Given("Mouseover on Clothing and Click Jeans")
	public void mouseoverOnClothingAndClickJeans() {
	    WebElement eleCloseSignIn = driver.findElementByXPath("//div[@class = 'c-coupon-box']/i");
	    builder.pause(2000).click(eleCloseSignIn).pause(2000).perform();
	    
	    WebElement eleClothing = driver.findElementByXPath("(//span[@class ='cate-sec-in j-cate-sec-in'] )[2]");
	    builder.pause(2000).moveToElement(eleClothing).pause(2000).perform();
	    
	    WebElement eleJeans = driver.findElementByXPath("(//div[@class ='j-nav2-fourth']/a[@title='Jeans'])[1]");
	    builder.pause(2000).click(eleJeans).pause(2000).perform();
	
	}

	@Given("Choose Black under Jeans product count")
	public void chooseBlackUnderJeansProductCount() {
	    WebElement eleBlack = driver.findElementByXPath("//a[text() ='Black']");
	    builder.pause(2000).click(eleBlack).pause(2000).perform();
	}

	@Given("Check size as medium")
	public void checkSizeAsMedium() {
	    WebElement eleSize = driver.findElementByXPath("//li[@class ='filter-title leftnav-first-title']/span[text()='Size']");
	    builder.pause(2000).click(eleSize).pause(2000).perform();
	    
	    WebElement eleMedium = driver.findElementByXPath("(//span[@class ='attr-check-box'])[9]");
	    builder.pause(2000).click(eleMedium).pause(2000).perform();
	    
	}

	@Given("Click + in colorCheck whether the color is black")
	public void clickInColorCheckWhetherTheColorIsBlack() {
	    WebElement eleColor = driver.findElementByXPath("(//span[text() ='Black']/following::i)[1]");
	    builder.pause(2000).click(eleColor).pause(2000).perform();
	}

	@Given("Click first item to Add to Bag")
	public void clickFirstItemToAddToBag() {
	    WebElement eleFirstItem = driver.findElementByXPath("(//div[@class='btm-price-ctn']/preceding-sibling::a)[1]");
	    builder.pause(2000).click(eleFirstItem).pause(2000).perform();
	    
	    Set<String> allWindows = driver.getWindowHandles();
	    List<String> allHandles = new ArrayList<>(allWindows);
	    
	    for (String eachWindow : allHandles) {
	    	driver.switchTo().window(eachWindow);
	    	if(driver.getTitle().equals("High Waist Cropped Skinny Jeans Without Belt | SHEIN IN")) {
				break;
			}
		}
	    
	    WebElement eleAddToBag = driver.findElementByXPath("(//button[@class='she-btn-black she-btn-xl'])[1]");
	    builder.pause(2000).click(eleAddToBag).pause(2000).perform();
	
	}

	@Given("Click the size as M and click Submit")
	public void clickTheSizeAsMAndClickSubmit() {
	    WebElement eleMSize = driver.findElementByXPath("(//div[@class ='product-intro__size-radio j-product-intro__size-radio']/span)[3]");
	    builder.pause(2000).click(eleMSize).pause(2000).perform();
	    
	    WebElement eleAddToBag = driver.findElementByXPath("(//button[@class='she-btn-black she-btn-xl'])[1]");
	    builder.pause(2000).click(eleAddToBag).pause(2000).perform();
	}

	@When("Click View Bag")
	public void clickViewBag() {
	    WebElement eleViewBagIcon = driver.findElementByXPath("//i[@class ='iconfont-critical icon-gouwudai']");
	    builder.pause(2000).moveToElement(eleViewBagIcon).pause(2000).perform();
	    WebElement eleViewBag = driver.findElementByXPath("//div[@class ='view-bag']/a");
	    builder.pause(2000).click(eleViewBag).pause(2000).perform();
	
	
	}

	@Then("Check the size is Medium or not and Close the browser")
	public void checkTheSizeIsMediumOrNotAndCloseTheBrowser() {
	    WebElement eleSize = driver.findElementByXPath("//span[@class ='gd-size']/em");
	    String size = eleSize.getText();
	    System.out.println(size);
	    if(size.equals("M")) {
	    	System.out.println("The product size is Medium");
	    }
	    
	    driver.quit();
	}
}
