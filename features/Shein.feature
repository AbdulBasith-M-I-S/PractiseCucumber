Feature: Shein TestCase

Scenario: Buy a Jeans

Given Open the Chrome Browser
And Load the url for shein
And Maximize the Browser
And Apply wait
And Mouseover on Clothing and Click Jeans
And Choose Black under Jeans product count
And Check size as medium
And Click + in colorCheck whether the color is black
And Click first item to Add to Bag
And Click the size as M and click Submit
When Click View Bag
Then Check the size is Medium or not and Close the browser