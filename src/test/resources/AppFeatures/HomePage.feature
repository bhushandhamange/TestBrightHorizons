@home
Feature: Home page feature

@search
Scenario: Verify search functionality
Given user is on home page
When user click on searchLoop icon
Then search field is visible on the page
And user type "Employee Education in 2018: Strategies to Watch" into search field
And user clicks on search button
Then first result matches with "Employee Education in 2018: Strategies to Watch"

