package restAPI;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.*;


public class GetRequestWithParam {
	
	@Test
	public void test1()
	{
	RestAssured.baseURI= "http://localhost:3000/employees";
	RequestSpecification request =RestAssured.given();
    Response response=		request.get("/1");
    String body = response.getBody().asString();
    
    System.out.println("Reponse body is "+body);
    Assert.assertTrue(body.contains("Pankaj"));
    JsonPath json = response.jsonPath();
	String name = json.get("name");
	Assert.assertEquals(name, "Pankaj");
    
    
    
	}

}
