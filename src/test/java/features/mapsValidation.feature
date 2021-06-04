Feature: Validating Maps API

@AddPlace @Regression @priya
Scenario Outline: To verify if a place is added
Given AddPlace Payload with "<name>" "<address>" "<lang>"
When user calls "addPlaceAPI" with "POST" request
Then the API call is success with status code 200
And verify "status" from response is "OK"
And verify "scope" from response is "APP"
And verify "place_id" created maps to "<name>" using "getPlaceAPI"

Examples:
|name|address|lang|
|dd|24 Ram Nagar|English|
#|pp|24 Ram Nagar|English|

@UpdatePlace @Regression @priya
Scenario: To verify if a place is updated with new address
Given UpdatePlace Payload 
When user calls "updatePlaceAPI" with "PUT" request
Then the API call is success with status code 200
And verify "msg" from response is "Address successfully updated"

@DeletePlace @Regression @priya
Scenario: To verify if a place is deleted
Given DeletePlace Payload 
When user calls "deletePlaceAPI" with "POST" request
Then the API call is success with status code 200
And verify "status" from response is "OK"