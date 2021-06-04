package stepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeDeletePalce() throws IOException {
		
		mapsStepDefinition m=new mapsStepDefinition();
		if(mapsStepDefinition.place_id==null) {
			m.add_place_payload_with("aa", "9, Nehru Street", "English");
			m.user_calls_with_request("addPlaceAPI", "POST");
			m.verify_created_maps_to_using("place_id", "aa", "getPlaceAPI");
		}
		
	}

}
