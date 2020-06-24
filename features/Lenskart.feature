Feature: Lenskart TestCase

Scenario: Buy a lens in Lenskart

Given Open the Chrome Browser
And Load the url for lenskart
And Maximize the Browser
And Apply wait
And Mouseover on Contact Lenses
And Click on Monthly under Explore By Disposability
And Select brand as Aqualens
And Click on the first product
And Click Buy Now
And Select No of boxes as 2 and Power as -1 for both eyes
And Type your name in User's name
When Click Save and continue
Then Print total amount and click Proceed to Checkout
