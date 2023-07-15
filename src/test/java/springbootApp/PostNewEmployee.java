package springbootApp;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostNewEmployee {
	
	
	@Test
	public void test1() {
		
		JSONObject jobj = new JSONObject();
		
		jobj.put("firstName", "King");
		jobj.put("lastName", "George");
		jobj.put("salary", "10000");
		jobj.put("email", "kgf101@gmail.com");
		
		RestAssured.baseURI = "http://localhost:8088/employees";
		
		RequestSpecification request = RestAssured.given();


		
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(jobj.toString()).post("/create");
		
String body = response.getBody().asString();
		
		System.out.println("Response body is " + body);
		System.out.println("Response code is " + response.statusCode());
		
		
	}
	
	
	

}
