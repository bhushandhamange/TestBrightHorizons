@findACenter
Feature: Home page feature

@verifyComments
Scenario: Verify comments
Given user is on home page
When user click on Find a Center button
Then newly opened page contains locator "/child-care-locator" as a part of URL
And user type "New York" into search box and press enter
Then verify number of found centers is the same as a number of centers displayed on the below list
And user click on first center of the list
Then verify center name and address are the same on the list and on the popup

