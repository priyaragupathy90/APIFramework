package Pojo;

public class AddPlaceRespPojo {
	
//    "status": "OK",
//    "place_id": "928b51f64aed18713b0d164d9be8d67f",
//    "scope": "APP",
//    "reference": "736f3c9bec384af62a184a1936d42bb0736f3c9bec384af62a184a1936d42bb0",
//    "id": "736f3c9bec384af62a184a1936d42bb0"
	
	private String status;
	private String place_id;
	private String scope;
	private String reference;
	private String id;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	


}
