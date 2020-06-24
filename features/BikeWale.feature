Feature: BikeWale TestCase

Scenario:

Given Open the Chrome Browser
And Load the url for BikeWale
And Maximize the Browser
And Apply wait
#Go to https://www.bikewale.com/
And Go to menu and click new bikes
And Click New Bikes Then compare bikes
And Add first bike as Royal Enfield and model as Thunderbird 350
And Add second bike Jawa, model as 42 and version Dual Channel ABS - BS VI
And Add bike brand Kawasaki model as Ninja 300
When Click compare
Then Find and print the maximum overall rating of all the bikes and find the max