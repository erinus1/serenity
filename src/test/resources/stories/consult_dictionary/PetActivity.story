Meta:

Nerrative:


Scenario: Check inventory of pet in Pet swager store
Given Get request to inventory 'pet_Status' end point
When I sent request to the 'pet_Status' end point
Then I get 'status code 200'

Scenario: Create a new order pet
Given Prepare request for an order
When I sent a new order
Then I get the response body with data which has been sent before