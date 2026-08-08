Feature: Testing Flipkart Application

Background:

Given User launch the flipkart application
When close the popup
Then It should navigate to the home page

Scenario: To validate the search functionality

Given User enter the text in the search box
When Click the search button
Then It should navigate to the search result page and display the relevant details

