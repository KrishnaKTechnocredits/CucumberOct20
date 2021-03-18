Feature: E2E flow 

Background: user able to login into application 
	Given user is on home page 
	When user click on sign in button on home page 
	And user enter "automation101@gmail.com" in email address on authentication page 
	And user enter "automation101" in password area on authentication page 
	And user click on "sign in" button on authentication page 
	And user full name display as "harsh patel1"
	
	
@Demo11
Scenario: Verify user able to login and can able to buy product 
	And user click on "women" section 
	And user verify product list is displayed on product category page 
	And user select the first available product on page product category page 
	And user select size as "M" on product details page 
	And user select Quantity as "10" on product details page 
	And user select color is "blue" on product details page 
	Then user verify product details on product details page 
	And user click on add to cart button on product details page 
	And user click on process and checkout on product details page 
	And user verify product details on checkout address page 
	
@Demo1 
Scenario: Verify user able to login and can able to buy product 
	And user click on "women" section 
	And user verify product list is displayed on product category page 
	And user select the first available product on page product category page 
	And user select size as "M" on product details page 
	And user select Quantity as "10" on product details page 
	And user select color is "blue" on product details page 
	Then user verify product details on product details page 
	And user click on add to cart button on product details page 
	And user click on process and checkout on product details page 
	And user verify product details on checkout address page 