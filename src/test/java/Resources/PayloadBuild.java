package Resources;

import java.util.ArrayList;

import Pojo.AddPlaceReqPojo;
import Pojo.LocationPojo;

public class PayloadBuild {
	
	public AddPlaceReqPojo addPlacePayloadBuild(String name, String address, String lang)
	{
		AddPlaceReqPojo ap= new AddPlaceReqPojo();
		LocationPojo l= new LocationPojo();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		ap.setAccuracy(75);
		ap.setName(name);
		ap.setPhone_number("+91) 983 303 4532");
		ap.setAddress(address);
		ArrayList<String> al=new ArrayList<String>();
		al.add("shoe park");
		al.add("shop");
		ap.setTypes(al);
		ap.setWebsite("http://google.com");
		ap.setLanguage(lang);
		return ap;

	}
	
	public String deletePlacePayloadBuild(String place)
	{
		return "{\r\n"
				+ "    \"place_id\":\""+place+"\"\r\n"
				+ "}\r\n"
				+ "";
	}

}
