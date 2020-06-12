package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Ajio extends BaseClass{
	
	@Given("Load the url for Ajio")
	public void loadTheUrlForAjio() {
	   driver.get("https://www.ajio.com/");
	    
	}

	@Given("Mouseover on Women, CATEGORIES and click on Kurtas")
	public void mouseoverOnWomenCATEGORIESAndClickOnKurtas() {
		
	    WebElement eleShopWomen = driver.findElementByXPath("(//a [@data-ga-event-category = 'firstCategorySelection' ] ) [1]");
	    builder.pause(3000).click(eleShopWomen).pause(3000).perform();
	    /*WebElement eleCloseTheLocationAccess = driver.findElementByXPath("(//div [@class = 'ic-close-quickview' ])[1]");
	    builder.pause(3000).click(eleCloseTheLocationAccess).pause(3000).perform();*/
	    
	    WebElement eleWomen = driver.findElementByClassName("selected-category-header");
	    builder.pause(3000).moveToElement(eleWomen).pause(3000).perform();
	    
	    /*WebElement eleCategories = driver.findElementByXPath("/a [text() = 'CATEGORIES' ]");
	    builder.pause(3000).moveToElement(eleCategories).pause(3000).perform();*/
	
	    WebElement eleKurtas = driver.findElementByXPath("(//a[@title = 'Kurtas'] )[2]");
	    builder.pause(3000).moveToElement(eleKurtas).click(eleKurtas).pause(3000).perform();
	    
	}

	@Given("Click on Brands and choose Ajio")
	public void clickOnBrandsAndChooseAjio() {
	    
	    WebElement eleBrands = driver.findElementByXPath("//span[@class='facet-left-pane-label' and text() = 'brands']");
	    builder.pause(3000).moveToElement(eleBrands).click(eleBrands).pause(3000).perform();
	    
	    WebElement eleAjio = driver.findElementByXPath("(//input[@id = 'AJIO' ]) /following::label [1]");
	    builder.pause(3000).moveToElement(eleAjio).click(eleAjio).pause(3000).perform();
	}

	@Given("Check all the results are Ajio")
	public void checkAllTheResultsAreAjio() {
	    
		List<WebElement> eleAjioDress = driver.findElementsByXPath("(//div [@class = 'contentHolder' ] /div )[1]");
	    for (int i = 0; i < eleAjioDress.size(); i++) {
			String brandName = eleAjioDress.get(i).getText();
			if(brandName.equals("AJIO")) {
				System.out.println("Hence, all the kurtas are AJIO brand only");
			}
			
		}
	}

	@Given("Set Sort by the result as Discount")
	public void setSortByTheResultAsDiscount() {
	    
	    WebElement eleSort = driver.findElementByXPath("//div[@class = 'filter-dropdown' ] /select");
	    wait.until(ExpectedConditions.visibilityOf(eleSort));
	    Select dd = new Select(eleSort);
	    dd.selectByVisibleText("Discount");
	   
	}

	@Given("Select the Color and click ADD TO BAG")
	public void selectTheColorAndClickADDTOBAG() {
		WebElement eleFirstResultDress = driver.findElementByXPath("(//div [@class = 'contentHolder' ] /div )[1]");
		builder.pause(3000).moveToElement(eleFirstResultDress).click(eleFirstResultDress).pause(3000).perform();
		
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allHandles = new ArrayList<>(allWindows);
		for (String eachWindow : allHandles) {
			driver.switchTo().window(eachWindow);
			if(driver.getTitle().equals("Buy Blue Kurtas for Women by AJIO Online | Ajio.com")) {
				break;
			}
		}
		
		WebElement eleColor = driver.findElementByXPath("//img [@class = 'swatch-image swatch-image-notselected' ]");
		builder.pause(3000).moveToElement(eleColor).click(eleColor).pause(3000).perform();
		
		WebElement eleAddToBag = driver.findElementByXPath("//div [@class = 'btn-gold' ]/span[2]");
		builder.pause(3000).moveToElement(eleAddToBag).click(eleAddToBag).pause(3000).perform();
	
	
	}

	@Given("Verify the error message Select your size to know your estimated delivery date")
	public void verifyTheErrorMessageSelectYourSizeToKnowYourEstimatedDeliveryDate() {
	    WebElement eleErrorMsg = driver.findElementByXPath("//span[@class = 'ic-info-error' ]/following::span[1]");
	    String errorMsg = eleErrorMsg.getText();
	    if(errorMsg.equals("Please select a size")) {
	    	System.out.println("Error message is displays as 'Please select a size'");
	    }
	    
	}

	@Given("Select size")
	public void selectSizeAndClickADDTOBAG() {
		WebElement eleXLSize = driver.findElementByXPath("//div [@class = 'size-variant-block' ]/div[2]/div"); 
		builder.pause(3000).moveToElement(eleXLSize).click(eleXLSize).pause(3000).perform();
	}
	

	@Given("Click on Enter pin-code to know estimated delivery date")
	public void clickOnEnterPinCodeToKnowEstimatedDeliveryDate() {
		WebElement eleClickEnterPincode = driver.findElementByXPath("//span [@class = 'edd-pincode-msg-details edd-pincode-msg-details-pointer edd-pincode-msg-details-text-color' ]");
		builder.pause(3000).moveToElement(eleClickEnterPincode).click(eleClickEnterPincode).pause(3000).perform();
		
		
	}

	@Given("Enter the pincode as 603103 and click Confirm pincode")
	public void enterThePincodeAsAndClickConfirmPincode() {

		WebElement eleEnterPinCode = driver.findElementByXPath("//input [@class = 'edd-pincode-modal-text']");
	    builder.pause(3000).sendKeys(eleEnterPinCode,"600103").pause(3000).perform();
	    
	    WebElement eleSubmit = driver.findElementByXPath("//button[@class='edd-pincode-modal-submit-btn']");
	    builder.pause(3000).moveToElement(eleSubmit).click(eleSubmit).pause(3000).perform();
	    
	}
	
	@Given("Click ADD TO BAG")
	public void clickAddToBag() {
		WebElement eleAddToBag = driver.findElementByXPath("//div [@class = 'btn-gold' ]/span[2]");
		builder.pause(3000).moveToElement(eleAddToBag).click(eleAddToBag).pause(3000).perform();
		
	}
	
	@When("Print the message and click Go to Bag")
	public void printTheMessageAndClickGoToBag() {
	    List<WebElement> eleMessage = driver.findElementsByXPath("//ul[@class = 'edd-message-success-details']/li");
	    for (int i = 0; i < eleMessage.size(); i++) {
			String text = eleMessage.get(i).getText();
			System.out.println(text);
		}
	 
	    WebElement eleGoToBag = driver.findElementByXPath("//div [@class = 'btn-cart' ]/span[2]");
		builder.pause(3000).moveToElement(eleGoToBag).click(eleGoToBag).pause(3000).perform();
	}

	@Then("Click on Proceed to Shipping and close the browser")
	public void clickOnProceedToShippingAndCloseTheBrowser() {
	    WebElement eleProceed = driver.findElementByXPath("//div[@class = 'button-wrapper cart-fixed-button']/button");
	    builder.pause(3000).moveToElement(eleProceed).click(eleProceed).pause(3000).perform();
	    
	    driver.quit();
	}

}
