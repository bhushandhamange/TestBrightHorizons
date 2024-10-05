Feature: Account Page Feature

Background: 
Given User has already logged in to application
|Username | Password|
|Bhushan	| Bhushan |

@account
Scenario: Verify Logout button
Given User in on Account Page
Then Logout button should be displayed

@account
Scenario: Verify Product Labels and Product Count
Given User in on Account Page
Then User is able to see following products
| Stylecon 9 Seater RHS Sofa Set 		|
| Thinking, Fast and Slow 			 		|
| YONEX Smash Badminton Racquet  		|
| Roadster Mens Running Shoes		 		|
| Nike Mens Running Shoes				 		|
| Tan Leatherette Weekender Duffle 	|
| Yarine Floor Lamp									|
| Xtend Smart Watch									|
| Plastic Balls											|
| Kindle														|
| Connector													|
| Jenga															|
And Account section count should be 12


