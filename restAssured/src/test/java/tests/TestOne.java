package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.http.ContentType;
import  io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

public class TestOne {
	@Test
	public void test1() {
		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println(response.asPrettyString());
	}

	@Test
	public void test2() {
		baseURI = "https://reqres.in";
		given()
		.get("/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data[1].id", equalTo(8))
		.body("data[]",hasItem("first_name")).log();
	}
	@Test
	public void postTest() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "soumik");
//		map.put("name", "monir");
		JSONObject data = new JSONObject();
		data.put("name", "soumik");
		data.put("job", "webdev");
		baseURI = "https://reqres.in/api";
		given()
		.header("Content-Type","application/json")
		 .body(data.toJSONString())
		 .when()
		  .post("/users")
		  .then()
		  .statusCode(201)
		  .log()
		  .all();
		
		
	}
	@Test
	public void putTest() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "soumik");
//		map.put("name", "monir");
		JSONObject data = new JSONObject();
		data.put("first_name", "soumik");
		data.put("last_name", "monir");
		baseURI = "https://reqres.in/api";
		given()
		.header("Content-Type","application/json")
		 .body(data.toJSONString())
		 .when()
		  .put("/users/2")
		  .then()
		  .statusCode(200)
		  .log()
		  .all();
		
		
	}
	@Test
	public void deleteTest() {

		baseURI = "https://reqres.in/api";

		 when()
		  .delete("/users/2")
		  .then()
		  .statusCode(204)
		  .log()
		  .all();
		
		
	}	@Test
	public void postsTest() {
baseURI="http://localhost:8000";
JSONObject obj = new JSONObject();
obj.put("firstname", "soumik");
obj.put("lastname", "monir");
System.out.println(obj.toJSONString());
given()
.header("Content-Type","application/json")
.contentType(ContentType.JSON)
.accept(ContentType.JSON)
.body("hello")
.when()
.post("/posts")
.then()
.statusCode(201)
.log().all();

	
		
	}
	
}
