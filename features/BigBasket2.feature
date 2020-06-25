Feature: BigBasket2 TestCase

Scenario: Buy a Juice Item

Given Open the Chrome Browser
And Load the url for BigBasket
And Maximize the Browser
And Apply wait
And Mouse over on Shop by Category
And Go to Beverages and Fruit juices & Drinks
And Click on JUICES
And Click Tropicana and Real under Brand
And Check count of the products from each Brands and total count
And Check whether the products is availabe with Add button
And Add the First listed available product 
And Click Address
And Select Chennai as City, Alandur-600016,Chennai as Area and click Continue
And Mouse over on My Basket print the product name, count and price
When Click View Basket and Checkout
Then Click the close button and close the browser