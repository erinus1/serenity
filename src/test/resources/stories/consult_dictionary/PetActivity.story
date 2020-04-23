Meta:

Nerrative:
I want to check API free sours Swagger pet store
As a server I sent requests
As a result, I expect special codes from Swagger's claimed documentation.

Scenario: check inventory of pet in Pet swager store
Given Get request to inventory pet_Status end point
When I sent request to the pet_Status end point
Then I get responce status code 200

Scenario: create a new order pet in Pet swager store
Given Prepare request for an order
When I sent a new order
Then I get the response body with data which has been sent before

Scenario: check created new order of pet Pet swager store
Given Get new order id of created new order
When I sent an order id
Then I get response of status code 200

Scenario: delete order of pet Pet swager store
Given I Sent delete response
When I sent the order id
Then I get status code 200