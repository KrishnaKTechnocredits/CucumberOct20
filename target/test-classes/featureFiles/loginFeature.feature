Feature: Feature descrition 

#@Testing 
#Scenario: verify login test 
#	Given user is on home page 
#	When user click on sign in button on home page 
#	And user enter username in email address on authentication page 
#	And user enter password in password area on authentication page 
#	And user click on sign in button on authentication page 
#	Then user verify my profile page is displayed 


@Scenario1 @12345678 
Scenario: verify login with user 
	Given user is on home page 
	When user click on sign in button on home page 
	And user enter "automation07@gmail.com" in email address on authentication page 
	And user enter "auto_123" in password area on authentication page 
	And user click on "sign in" button on authentication page 
	Then user verify my profile page is displayed 
	
@Scenario2 
Scenario Outline: verify login function for every user 
	Given user is on home page 
	When user click on sign in button on home page 
	And user enter "<email>" in email address on authentication page 
	And user enter "<pwd>" in password area on authentication page 
	And user click on "<buttonname>" button on authentication page 
	Then user verify my profile page is displayed 
	
	Examples: 
		|email                     |pwd			|buttonname|
		|  automation07@gmail.com  | auto_123   |  sign in |
		|  automation07@gmail.com  | auto_123   |  sign in |
		|  automation07@gmail.com  | auto_123   |  sign in |
		
		@Scenario3 
		Scenario: Veriry userdetails 
			Given user is on application page 
			When user added items on home page 
				|nike shoes|
				|laptop|
				|mobile|
				|sun glass|
				|ABC|
			And user click on login button on home page 
			Then verify user land on profile page 
			
			
	