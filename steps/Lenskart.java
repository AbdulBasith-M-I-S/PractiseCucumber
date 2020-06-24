package steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Lenskart extends BaseClass{

	@Given("Load the url for lenskart")
	public void loadTheUrlForLenskart() {
	    driver.get("https://www.lenskart.com/");
	    
	}

	@Given("Mouseover on Contact Lenses")
	public void mouseoverOnContactLenses() {
	    WebElement eleContactLensesTab = driver.findElementByXPath("//a[text() ='Contact Lenses']");
	    builder.pause(2000).moveToElement(eleContactLensesTab).pause(2000).perform();
	    
	}

	@Given("Click on Monthly under Explore By Disposability")
	public void clickOnMonthlyUnderExploreByDisposability() {
	    WebElement eleMonthlyDisposability = driver.findElementByXPath("//span[text() ='Monthly']");
	    builder.pause(2000).click(eleMonthlyDisposability).pause(2000).perform();
	}

	@Given("Select brand as Aqualens")
	public void selectBrandAsAqualens() {
	    WebElement eleAqualens = driver.findElementByXPath("(//input[@type = 'checkbox'])[1]");
	    builder.pause(2000).click(eleAqualens).pause(2000).perform();
	}

	@Given("Click on the first product")
	public void clickOnTheFirstProduct() {
	    WebElement eleFirstProduct = driver.findElementByXPath("(//div[@class ='col-md-12 no-padding']/div)[1]");
	    builder.pause(2000).click(eleFirstProduct).pause(2000).perform();
	}

	@Given("Click Buy Now")
	public void clickBuyNow() {
	    WebElement eleBuyNow = driver.findElementByXPath("//div[@class ='contact-lens-wrap btn-add-to-cart']/button");
	    builder.pause(2000).click(eleBuyNow).pause(2000).perform();
	}

	@Given("Select No of boxes as 2 and Power as -1 for both eyes")
	public void selectNoOfBoxesAsAndPowerAsForBothEyes() {
	    WebElement eleBox1 = driver.findElementByXPath("(//div[@class = 'select-style']/select)[1]");
	    Select dd1 = new Select(eleBox1);
	    dd1.selectByValue("2");
	    
	    WebElement eleBox2 = driver.findElementByXPath("(//div[@class = 'select-style']/select)[2]");
	    Select dd2 = new Select(eleBox2);
	    dd2.selectByValue("2");
	    
	    WebElement elePower1 = driver.findElementByXPath("(//span[@class = 'cl-dd'])[1]");
	    builder.pause(2000).click(elePower1).pause(2000).perform();
	    
	    WebElement eleSelectPower1 = driver.findElementByXPath("(//ul[@class ='negative-list list pull-left right-power']/li/div)[3]");
	    builder.pause(2000).click(eleSelectPower1).pause(2000).perform();
	    
	    WebElement elePower2 = driver.findElementByXPath("(//span[@class = 'cl-dd'])[2]");
	    builder.pause(2000).click(elePower2).pause(2000).perform();
	    
	    WebElement eleSelectPower2 = driver.findElementByXPath("(//ul[@class ='negative-list list pull-left left-power']/li/div)[3]");
	    builder.pause(2000).click(eleSelectPower2).pause(2000).perform();
	    
	}

	@Given("Type your name in User's name")
	public void typeYourNameInUserSName() {
	    
	    WebElement eleUserName = driver.findElementById("example-text-input");
	    builder.pause(2000).click(eleUserName).sendKeys(eleUserName, "Name").pause(2000).perform();
	
	}

	@When("Click Save and continue")
	public void clickSaveAndContinue() {
	    WebElement eleSave = driver.findElementByXPath("(//button[text() ='SAVE & CONTINUE'])[1]");
	    builder.pause(2000).click(eleSave).pause(2000).perform();
	}

	@Then("Print total amount and click Proceed to Checkout")
	public void printTotalAmountAndClickProceedToCheckout() {
	    WebElement eleTotalAmount = driver.findElementByXPath("//span[@class ='span6 color-yellow text-left']");
	    System.out.println("Total Amount is "+ eleTotalAmount.getText());
	    
	    
	    WebElement eleProceed = driver.findElementByXPath("//a[@class ='button-green']");
	    builder.pause(2000).click(eleProceed).pause(2000).perform();
	    
	    driver.quit();
	
	}
	
	
}
