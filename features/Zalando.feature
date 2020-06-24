Feature: Zalando Testcase

Scenario: Buy a product in Zalando 

Given Open the Chrome Browser
And Load the url for zalando
And Maximize the Browser
And Apply wait
And Get the Alert text and print it
And Close the Alert box and click on Zalando.uk
And Mouse over on FREE DELIVERY & RETURNS* get the text and print it
And Mouse over on Clothing and click Coat under WOMEN
And Choose Material as cotton and Length as thigh-length
And Click the first result choose the color and size if available
And Get the page title and match with the product brand, name, color and the page url
And Click Add to Bag and click on FREE DELIVERY & RETURNS* on the top of the page
And Click on Start chat in the Start chat and go to the new window
When Enter you first name and a dummy email and click Start Chat
Then Type Hi, click Send and print thr reply message and close the chat window