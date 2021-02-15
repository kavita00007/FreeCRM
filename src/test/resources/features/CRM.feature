Feature: Free CRM Create Contacts

Scenario Outline: Free CRM Create a new contact scenario

Given user is already on Login Page
When title of login page is Free CRM
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user is on home page
Then user moves to new contact page
Then user enters contact details "<firstname>" and "<lastname>" and "<position>"
Then Close the browser

Examples:
	| username                   | password   | firstname | lastname | position |
	| kavipatil271992@gmail.com  | Kavita@123 | kavita 	  | patil    | Manager  |
