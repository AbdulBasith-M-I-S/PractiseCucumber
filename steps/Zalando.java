package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Zalando extends BaseClass{
	
	@Given("Load the url for zalando")
	public void loadTheUrlForZalando() {
	  driver.get("https://www.zalando.com/");  
	    
	}

	@Given("Get the Alert text and print it")
	public void getTheAlertTextAndPrintIt() {
	    /*Alert alert = driver.switchTo().alert();
	    String alert1 = alert.getText();
	    System.out.println(alert1);*/
	    
	}

	@Given("Close the Alert box and click on Zalando.uk")
	public void closeTheAlertBoxAndClickOnZalandoUk() {
		/*Alert alert = driver.switchTo().alert();
		alert.accept();*/
		
		WebElement eleZalandoUk = driver.findElementByXPath("//a [@class = 'nav_link nav_link-gb']");
		wait.until(ExpectedConditions.visibilityOf(eleZalandoUk));
	    eleZalandoUk.click();
	    
	}

	@Given("Mouse over on FREE DELIVERY & RETURNS* get the text and print it")
	public void mouseOverOnFREEDELIVERYRETURNSGetTheTextAndPrintIt() throws InterruptedException {
	    
		Thread.sleep(3000);
	    WebElement eleFreeDelivery = driver.findElementByXPath("(//a [@name = '“headbanner.about.us\"'] )[1]");
	    String freeDelivery = eleFreeDelivery.getText();
	    System.out.println(freeDelivery);
	    eleFreeDelivery.click();
	    
	    /*WebElement eleSweetAlert = driver.findElementByXPath("(//div[@class ='uc-btn-footer-container']//button )[1]");
	    Thread.sleep(5000);
	    //wait.until(ExpectedConditions.visibilityOf(eleSweetAlert));
	    
	    //executor.executeScript("arguments[0].click();", eleSweetAlert);	
	    builder.pause(3000).click(eleSweetAlert).perform();
	    
	    //eleSweetAlert.click();	*/
	    
	}

	@Given("Mouse over on Clothing and click Coat under WOMEN")
	public void mouseOverOnClothingAndClickCoatUnderWOMEN() {
	    WebElement eleWomenTab = driver.findElementByXPath("//span [text() = 'Women']");
	    eleWomenTab.click();
	    
	    WebElement eleClothing = driver.findElementByXPath("//span [text() = 'Clothing']");
	    builder.pause(2000).moveToElement(eleClothing).perform();
	    
	    WebElement eleCoats = driver.findElementByXPath("//span [text() = 'Coats']");
	    builder.click(eleCoats).perform();
	    
	    
	
	
	}

	@Given("Choose Material as cotton and Length as thigh-length")
	public void chooseMaterialAsCottonAndLengthAsThighLength() {
	    
		//Material
		WebElement eleMaterial = driver.findElementByXPath("//button [ @aria-label ='filter by Material']");
	    builder.pause(3000).click(eleMaterial).pause(3000).perform();
		//eleMaterial.click();
	    WebElement eleCotton = driver.findElementByXPath("//span[text() ='Cotton']");
	    builder.pause(3000).click(eleCotton).pause(3000).perform();
	    //eleCotton.click();
	    WebElement eleSaveMaterial = driver.findElementByXPath("//button[text() ='Save']");
	    builder.pause(3000).click(eleSaveMaterial).pause(3000).perform();
	    //eleSaveMaterial.click();
	    
	    //Length
	    WebElement eleLength = driver.findElementByXPath("//span[text() ='Length']");
	    builder.pause(3000).click(eleLength).pause(3000).perform();
	    //eleLength.click();
	    WebElement eleThighLength = driver.findElementByXPath("//span[text() ='thigh-length']");
	    builder.pause(3000).click(eleThighLength).pause(3000).perform();
	    //eleThighLength.click();
	    WebElement eleSaveLength = driver.findElementByXPath("//button[text() ='Save']");
	    builder.pause(3000).click(eleSaveLength).pause(3000).perform();
	    //eleSaveLength.click();
	    
	    
	}

	@Given("Click the first result choose the color and size if available")
	public void clickTheFirstResultChooseTheColorAndSizeIfAvailable() {
	    WebElement eleFirstResult = driver.findElementByXPath("(//div [@class = 'cat_brandName-2XZRz cat_ellipsis-MujnT'] )[1]");
	    executor.executeScript("window.scrollBy(0,1000)");
	    builder.pause(3000).moveToElement(eleFirstResult).click(eleFirstResult).pause(3000).perform();
	    //eleFirstResult.click();
	    
	    /*WebElement eleFirstColor = driver.findElementByXPath("(//img [@alt ='dark grey melange'] )[1]");
	    eleFirstColor.click();*/
	    
	    WebElement eleChooseSize = driver.findElementByXPath("//span [text() ='Choose your size']");
	    builder.pause(3000).click(eleChooseSize).pause(3000).perform();
	    //eleChooseSize.click();
	    
	    WebElement eleSizeL = driver.findElementByXPath("(//ul[@role = 'listbox']/li/div)[1]");
	    builder.pause(3000).click(eleSizeL).pause(3000).perform();
	    //eleSizeL.click();
	    
	
	}

	@Given("Get the page title and match with the product brand, name, color and the page url")
	public void getThePageTitleAndMatchWithTheProductBrandNameColorAndThePageUrl() {
	    String titlePage = driver.getTitle();
	    System.out.println(titlePage);
	    if(titlePage.contains("JDYBESTY ZIP JACKET - Short coat")) {
	    	System.out.println("It matches the brand");
	    }
	    if (titlePage.contains("JDYBESTY ZIP JACKET - Short coat")) {
			System.out.println("It matches the color");
		}
	    if (titlePage.contains(driver.getCurrentUrl())) {
			System.out.println("It matches the current url");
		}
	    
	}

	@Given("Click Add to Bag and click on FREE DELIVERY & RETURNS* on the top of the page")
	public void clickAddToBagAndClickOnFREEDELIVERYRETURNSOnTheTopOfThePage() {
	    WebElement eleAddToBag = driver.findElementByXPath("//span [text() ='Add to bag']");
	    builder.pause(3000).click(eleAddToBag).pause(3000).perform();
	    
	    
	    WebElement eleFreeDelivery = driver.findElementByXPath("//a [text() ='Free delivery & returns*']");
	    builder.pause(3000).click(eleFreeDelivery).pause(3000).perform();
	
	
	}

	@Given("Click on Start chat in the Start chat and go to the new window")
	public void clickOnStartChatInTheStartChatAndGoToTheNewWindow() {
	    WebElement eleStartChat = driver.findElementByXPath("(//button[@class = 'faq-dx-button'] )[1]");
	    executor.executeScript("window.scrollBy(0,800)");
	    builder.pause(3000).click(eleStartChat).pause(3000).perform();
	    
	    Set<String> allWindows = driver.getWindowHandles();
	    List<String> allHandles = new ArrayList<String>(allWindows);
	    driver.switchTo().window(allHandles.get(1));
	    
	}

	@When("Enter you first name and a dummy email and click Start Chat")
	public void enterYouFirstNameAndADummyEmailAndClickStartChat() {
	    WebElement eleFirstName = driver.findElementById("prechat_customer_name_id");
	    builder.pause(3000).click(eleFirstName).sendKeys(eleFirstName, "Name").pause(3000).perform();
	    
	    WebElement eleEnterEmail = driver.findElementById("prechat_customer_email_id");
	    builder.pause(3000).click(eleEnterEmail).sendKeys(eleEnterEmail, "testemail@test.com").pause(3000).perform();
	    
	    WebElement eleStartChat = driver.findElementByXPath("//span[text() ='Start Chat']");
	    builder.pause(3000).click(eleStartChat).pause(3000).perform();
	}

	@Then("Type Hi, click Send and print thr reply message and close the chat window")
	public void typeHiClickSendAndPrintThrReplyMessageAndCloseTheChatWindow() {
	    WebElement eleChat = driver.findElementById("liveAgentChatTextArea");
	    builder.pause(3000).click(eleChat).sendKeys(eleChat, "hi").pause(3000).perform();
	    WebElement eleSendChat = driver.findElementByXPath("//div[@id ='bottomelements']/span[2]/button");
	    builder.pause(3000).click(eleSendChat).pause(3000).perform();
	    
	    driver.quit();
	    
	}

	

}
