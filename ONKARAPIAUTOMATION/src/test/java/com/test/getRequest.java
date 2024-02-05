package com.test;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class getRequest {

	    @Test
	    public void getRequest() {
	        Response response = given().get("http://localhost:3000/employees");
	        Headers header = response.headers();
	        for (Header allheaders : header) {
	            System.out.println(allheaders.getName() + ":" + allheaders.getValue());
	        }

	    }

	    @Test
	    public void getReq() {
	      String response= given().log().all()
	                .header("Content-Type", ContentType.JSON)
	                .pathParam("id", 5)
	                .get("http://localhost:3000/employees/{id}")
	                .then().statusCode(200).extract().response().asString();

	        System.out.println(response);
	    }
}
