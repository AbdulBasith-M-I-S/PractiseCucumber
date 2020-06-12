Feature: Ajio TestCase

Scenario: TestCase to Buy a Dress in Positive Flow
Given Open the Chrome Browser
And Load the url for Ajio
And Maximize the Browser
And Apply wait
And Mouseover on Women, CATEGORIES and click on Kurtas
And Click on Brands and choose Ajio
And Check all the results are Ajio
And Set Sort by the result as Discount
And Select the Color and click ADD TO BAG
And Verify the error message Select your size to know your estimated delivery date
And Select size
And Click on Enter pin-code to know estimated delivery date
And Enter the pincode as 603103 and click Confirm pincode
And Click ADD TO BAG
When Print the message and click Go to Bag
Then Click on Proceed to Shipping and close the browser