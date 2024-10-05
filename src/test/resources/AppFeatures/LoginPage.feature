@Login
Feature: Login page feature

@Smoke
Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "QKart"

@Smoke
Scenario: Register Now link
Given user is on login page
Then register now link should be displayed

@Regression @Skip
Scenario: Login with correct credentials
Given user is on login page
When user enters username "Bhushan"
And user enters password "Bhushan"
And user clicks on Login To Qkart button
Then user gets the title of the page
And page title should be "QKart"