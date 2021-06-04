package stepDefinition;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Pojo.AddPlaceReqPojo;
import Pojo.LocationPojo;
import Resources.APIResources;
import Resources.PayloadBuild;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.junit.Assert.*;

public class mapsStepDefinition extends Utils {
	
	RequestSpecification req1;	
	Response response;
	static String place_id;
	
	PayloadBuild pb=new PayloadBuild();
	
	@Given("AddPlace Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String address, String lang) throws IOException {
		 req1=given().spec(requestBuilder()).body(pb.addPlacePayloadBuild(name,address,lang));	
	}

	@When("user calls {string} with {string} request")
	public void user_calls_with_request(String resource, String httpMethod) {
		
		APIResources apir=APIResources.valueOf(resource);	
		
		if(httpMethod.equalsIgnoreCase("POST"))
		 response=req1.when().post(apir.getResource()).then().spec(responseBuilder()).extract().response();
		else if (httpMethod.equalsIgnoreCase("GET"))
			 response=req1.when().get(apir.getResource()).then().spec(responseBuilder()).extract().response();
		else if (httpMethod.equalsIgnoreCase("PUT"))
			 response=req1.when().put(apir.getResource()).then().spec(responseBuilder()).extract().response();
		else
			System.out.println("Invalid http method");
	  
	}
	
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer a) {
		
		//assertEquals(response.getStatusCode(),a);
		assertEquals(response.getStatusCode(),200);
	  
	}
	@Then("verify {string} from response is {string}")
	public void verify_from_response_is(String key, String value) {

		assertEquals(getJson(response, key),value);
   
	}
	
	@Then("verify {string} created maps to {string} using {string}")
	public void verify_created_maps_to_using(String key, String expName, String resource) throws IOException {
		
		 place_id=getJson(response, key);
		 req1=given().spec(requestBuilder()).queryParam(key, place_id);
		 user_calls_with_request(resource, "GET");
		 String actualName=getJson(response, "name");
		 assertEquals(actualName,expName);

	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
		req1=given().spec(requestBuilder()).body(pb.deletePlacePayloadBuild(place_id));	
	}





}
