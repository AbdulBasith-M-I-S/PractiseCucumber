package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Trivago extends BaseClass{

	@Given("Load the url for trivago")
	public void loadTheUrlForTrivago() {
	    driver.get("https://www.trivago.in/");
	    
	}
	
	@Given("Type Agra in Destination and select Agra, Uttar Pradesh.")
	public void typeAgraInDestinationAndSelectAgraUttarPradesh() {
	    WebElement eleSelectPlace = driver.findElementByXPath("//input[@id = 'querytext' ]");
	    builder.sendKeys(eleSelectPlace, "Agra").pause(3000).sendKeys(Keys.TAB).perform();
	}

	@Given("Choose June 15 as check in and June 30 as check out")
	public void chooseJuneAsCheckInAndJuneAsCheckOut() throws InterruptedException {
	    //For CheckOut
	    
	    //ExpectedDate for check in
	    String expectedDateForCheckIn = "2020-06-15";
	    List<WebElement> eleAllRows = driver.findElementsByXPath("//table[@class = 'cal-month' ]//tbody/tr/td/time");
	    //AllCalendarDate
	    List<String> checkDate = new ArrayList<>();
	    for (int i = 0; i < eleAllRows.size(); i++) {
			WebElement eleEachRow = eleAllRows.get(i);
			checkDate.add(eleEachRow.getAttribute("datetime"));
		}
	    System.out.println(checkDate);
	    //Click the check in date
	    for (int i = 0; i < checkDate.size(); i++) {
			if(checkDate.get(i).equals(expectedDateForCheckIn)) {
				WebElement eleCheckInDate = driver.findElementByXPath("//time [@datetime ='"+expectedDateForCheckIn+"' and @class ='cal-day cal-is-selectable']");
				System.out.println(eleCheckInDate.getText());
			    wait.until(ExpectedConditions.visibilityOf(eleCheckInDate));
			    executor.executeScript("arguments[0].click();", eleCheckInDate);
			}
		}
	    
	    //ExpectedDate for check out
	    Thread.sleep(3000);
	    String expectedDateForCheckOut = "2020-06-30";
	    //Click the check out date
	    for (int i = 0; i < checkDate.size(); i++) {
			if(checkDate.get(i).equals(expectedDateForCheckOut)) {
				WebElement eleCheckOutDate = driver.findElementByXPath("//time [@datetime ='"+expectedDateForCheckOut+"' and @class ='cal-day cal-is-selectable']");
				System.out.println(eleCheckOutDate.getText());
			    wait.until(ExpectedConditions.visibilityOf(eleCheckOutDate));
			    executor.executeScript("arguments[0].click();", eleCheckOutDate);
			
			}
		}	
		
	}

	@Given("Select Room as Family Room")
	public void selectRoomAsFamilyRoom() {
	    WebElement eleFamilyRoom = driver.findElementByXPath("//span[text() = 'Family rooms']");
	    wait.until(ExpectedConditions.visibilityOf(eleFamilyRoom));
	    builder.pause(3000).moveToElement(eleFamilyRoom).click(eleFamilyRoom).perform();
	}

	@Given("Choose Number of Adults 2, Childern 1 and set Child's Age as 4")
	public void chooseNumberOfAdultsChildernAndSetChildSAgeAs() {
	    //No. of Children
		WebElement eleChooseNoOfChildren = driver.findElementByXPath("//select[@id = 'select-num-children-2' ]");
	    Select dd1 = new Select(eleChooseNoOfChildren);
	    dd1.selectByVisibleText("1");
	    
	    //Age of Children
	    WebElement eleAgeOfChild = driver.findElementById("select-ages-children-2-3");
	    Select dd2 = new Select(eleAgeOfChild);
	    dd2.selectByVisibleText("4");
	    
	}

	@Given("Click Confirm button and click Search")
	public void clickConfirmButtonAndClickSearch() {
	    WebElement eleConfirm = driver.findElementByXPath("//span [text() = 'Confirm' ]");
	    wait.until(ExpectedConditions.visibilityOf(eleConfirm));
	    builder.pause(3000).moveToElement(eleConfirm).click(eleConfirm).perform();
	}
	
	

	@Given("Select Accommodation type as Hotels only and choose 4 stars")
	public void selectAccommodationTypeAsHotelsOnlyAndChooseStars() {
	    WebElement eleAccType = driver.findElementByXPath("//span [text()='All types']");
		builder.moveToElement(eleAccType).click(eleAccType).perform();
		
		WebElement eleHotelOnly = driver.findElementByXPath("//input [@id = 'acc-type-filter-1' ]");
		builder.pause(3000).moveToElement(eleHotelOnly).click(eleHotelOnly).perform();
		
		WebElement ele4Star = driver.findElementByXPath("(//button[@title = '4-star hotels' ]/span)[1]");
		builder.pause(3000).moveToElement(ele4Star).click(ele4Star).pause(3000).perform();
		
	}

	@Given("Select Guest rating as Very Good")
	public void selectGuestRatingAsVeryGood() {
		WebElement eleGuestRating = driver.findElementByXPath("(//span [@class = 'filter-value' ] ) [2]");
	    wait.until(ExpectedConditions.visibilityOf(eleGuestRating));
		builder.pause(3000).moveToElement(eleGuestRating).click(eleGuestRating).perform();
	    
	    WebElement eleRating = driver.findElementByXPath("//span [@class = 'range__text' and text() = 'Very good' ]");
	    wait.until(ExpectedConditions.visibilityOf(eleRating));
	    builder.pause(3000).moveToElement(eleRating).click(eleRating).perform();
	    
	}

	@Given("Set Hotel Location as Agra Fort and click Done")
	public void setHotelLocationAsAgraFortAndClickDone() {
	    WebElement eleHotelLocation = driver.findElementByXPath("(//span [@class = 'filter-item__placeholder']/span)[6]");
	    wait.until(ExpectedConditions.visibilityOf(eleHotelLocation));
	    builder.pause(3000).moveToElement(eleHotelLocation).click(eleHotelLocation).perform();
	    
	    WebElement eleLocation = driver.findElementById("pois");
	    wait.until(ExpectedConditions.visibilityOf(eleLocation));
	    Select dd3 = new Select(eleLocation);
	    dd3.selectByVisibleText("Agra Fort");
	}

	@Given("In more Filters, select Air conditioning, Restaurant and WiFi and click Done")
	public void inMoreFiltersSelectAirConditioningRestaurantAndWiFiAndClickDone() {
	    WebElement eleMoreFilter = driver.findElementByXPath("//span [text() = 'Select']");
	    wait.until(ExpectedConditions.visibilityOf(eleMoreFilter));
	    builder.pause(3000).moveToElement(eleMoreFilter).click(eleMoreFilter).perform();
	    
	    WebElement eleAirCon = driver.findElementByXPath("(//input [@data-qa = 'filters-list-checkbox' ] )[3]");
	    wait.until(ExpectedConditions.visibilityOf(eleAirCon));
	    builder.pause(3000).moveToElement(eleAirCon).click(eleAirCon).pause(3000).perform();
	    
	    WebElement eleWifi = driver.findElementByXPath("(//input [@data-qa = 'filters-list-checkbox' ] )[4]");
	    wait.until(ExpectedConditions.visibilityOf(eleWifi));
	    builder.pause(3000).moveToElement(eleWifi).click(eleWifi).pause(3000).perform();
	    
	    WebElement eleShowFilter = driver.findElementByXPath("//input [@id = 'more-filters-search' ]");
	    wait.until(ExpectedConditions.visibilityOf(eleShowFilter));
	    builder.pause(3000).moveToElement(eleShowFilter).sendKeys(eleShowFilter, "Restaurant").pause(3000).perform();
	    
	    WebElement eleRestaurant = driver.findElementByXPath("(//input [@data-qa = 'filters-list-checkbox' ] ) [1]");
	    wait.until(ExpectedConditions.visibilityOf(eleRestaurant));
	    builder.pause(3000).moveToElement(eleRestaurant).click(eleRestaurant).perform();
	    
	    WebElement eleDone = driver.findElementById("filter-popover-done-button");
	    wait.until(ExpectedConditions.visibilityOf(eleDone));
	    builder.pause(3000).moveToElement(eleDone).click(eleDone).pause(3000).perform();
	}

	@Given("Sort the result as Rating & Recommended")
	public void sortTheResultAsRatingRecommended() {
		
		WebElement eleSortBy = driver.findElementById("mf-select-sortby");
		wait.until(ExpectedConditions.visibilityOf(eleSortBy));
		Select dd3 = new Select(eleSortBy);
	    dd3.selectByVisibleText("Rating & Recommended");
	    
	}

	@Given("Print the Hotel name, Rating, Number of Reviews and Click View Deal")
	public void printTheHotelNameRatingNumberOfReviewsAndClickViewDeal() {
	    WebElement eleHotelName = driver.findElementByXPath("(//span [ @class ='item-link name__copytext' and @data-qa = 'item-name' ] )[1]");
		System.out.println("Hotel Name =" +eleHotelName );
		
		WebElement eleRating = driver.findElementByXPath("(//strong [@class = 'item__rating-number']) [1]");
	    System.out.println("Rating = " +eleRating);
	    
	    WebElement eleViewDeal = driver.findElementByXPath("(//button [@data-qa = 'champion-deal' ]) [1]");
	    builder.pause(3000).moveToElement(eleViewDeal).click(eleViewDeal).perform();
	    
	}

	@Given("Print the URL of the Page")
	public void printTheURLOfThePage() {
	    Set<String> allWindows = driver.getWindowHandles();
	    List<String> allHandles = new ArrayList<>(allWindows);
	    for (String eachWindow : allHandles) {
			driver.switchTo().window(eachWindow);
			if(driver.getTitle().equals("Booking.com: Hotels in Agra. Book your hotel now!")) {
				break;
				
			}
		}
	    System.out.println(driver.getTitle());
	}

	@When("Print the Price of the Room and click Choose Your Room")
	public void printThePriceOfTheRoomAndClickChooseYourRoom() {
	    List<WebElement> eleRoomPrice = driver.findElementsByXPath("//div [@class = 'bui-price-display__value prco-text-nowrap-helper prco-inline-block-maker-helper']");
	    for (int i = 0; i < eleRoomPrice.size(); i++) {
			System.out.println(eleRoomPrice.get(i).getText());
		}
	    
	    WebElement eleChooseRoom = driver.findElementByXPath("(//span [@class = 'bui-button__text' ] )[1]");
	    builder.pause(3000).click(eleChooseRoom).perform();
	}

	@Then("Click Reserve and I'll Reserve")
	public void clickReserveAndILlReserve() {
	    
	    WebElement eleClickReserve = driver.findElementByXPath("(//td [@class = 'submitButton' ] //span)[1]");
	    builder.pause(3000).click(eleClickReserve).perform();
	    WebElement eleReserve = driver.findElementByXPath("//div [@class = 'hprt-reservation-cta' ]");
	    builder.pause(3000).click(eleReserve).perform();
	    
	}

	@Then("Close the browser")
	public void closeTheBrowser() {
	    driver.quit();
	    
	}	
	
}
