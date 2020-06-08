Feature: CarWale TestCase

Scenario: Lowest Car in CarWale

Given Open the Chrome Browser
And Load the url 
And Maximize the Browser
And Apply wait
And Click on Used
And Select the city as Chennai
And Select Budjet min 8L and max 12L
And Click Search
And Select Cars with Photos under Only Show Cars With
And Select Manufacturer as Hyundai
And Select Car as Creta
And Select Fuel type as Petrol
And Select Best Match as KM:Low to High
And Validate the Cards are listed with KMs Low to High
And Add the least KM ran car to Wishlist
When Go to Wishlist and Click on More Details
Then Print all the details under overview in the same way as displayed in application
And Close the Browser