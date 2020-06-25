Feature: BigBasket TestCase

Scenario: Book a grocery item

Given Open the Chrome Browser
And Load the url for BigBasket
And Maximize the Browser
And Apply wait
And Mouse over on Shop by Category
And Go to FOODGRAINS, OIL & MASALA and RICE & RICE PRODUCTS
And Click on BOILED & STEAM RICE
And Get the URL of the page and check with site navigation link(HOME > FOODGRAINS, OIL & MASALA> RICE & RICE PRODUCTS> BOILED & STEAM RICE)
And Choose the Brand as bb Royal
And Go to Ponni Boiled Rice and select 25kg bag from Dropdown
And Click Add button
And Go to search box and type Dal
And Add Toor or Arhar Dal 2kg and set Qty 2 from the list
And Click Address
And Select Chennai as City, Alandur-600016,Chennai as Area and click Continue
And Mouse over on My Basket take a screen shot
When Click View Basket and Checkout
Then Click the close button and close the browser