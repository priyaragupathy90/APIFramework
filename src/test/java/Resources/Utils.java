package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	public static RequestSpecification req;
	ResponseSpecification res;
	
	public RequestSpecification requestBuilder() throws IOException
	{
		if (req==null) {
		PrintStream ps=new PrintStream(new FileOutputStream("log.txt"));
		req=new RequestSpecBuilder().setBaseUri(getGlobalParam("baseUri")).addHeader("Content-Type","application/json")
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(ps))
				.addFilter(ResponseLoggingFilter.logResponseTo(ps))
				.setContentType(ContentType.JSON).build();
		return req;
		}
		return req;
	}

	public ResponseSpecification responseBuilder()
	{
		res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return res;
	}
	
	public String getGlobalParam(String key) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Priya Ragupathy\\restapi-new\\APIFramework\\src\\test\\java\\Resources\\globalParam.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public static String getJson(Response response, String key)
	{
		String resp=response.asString();
		JsonPath js= new JsonPath(resp);
		String value = js.get(key).toString();
		return value;
		
	}
}
