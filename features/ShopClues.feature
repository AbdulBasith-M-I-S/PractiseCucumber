Feature: ShopClues TestCase

Scenario: TestCase to Buy a Shoe

Given Open the Chrome Browser
And Load the url for ShopClues
And Maximize the Browser
And Apply wait
And Mouseover on women and click Casual Shoes
And Select Color as Black
And Check whether the product name contains the word black
And If so, add the product name and price in to Map
And Check Display the count of shoes which are more than 500 rupees
And Click the highest price of the shoe
And Get the current page URL and check with the product ID
And Copy the offercode
And Select size, color and click ADD TO CART
When Mouse over on Shopping cart and click View Cart
Then Type Pincode as 600016 click Submit and Place Order and Close the Browser
