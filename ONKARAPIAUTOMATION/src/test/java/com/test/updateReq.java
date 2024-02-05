package com.test;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class updateReq {
	
	@Test
    public void updateReq() {

        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("id", String.valueOf(new Faker().number().numberBetween(50, 60)));
        payload.put("firstName", String.valueOf(new Faker().name().firstName()));
        payload.put("lastName", String.valueOf(new Faker().name().lastName()));
        payload.put("email", String.valueOf(new Faker().internet().emailAddress()));

        Response response = given()
                .header("Content-Type", ContentType.JSON)
                .pathParam("id", 28)
                .body(payload)
                .put("http://localhost:3000/employees/{id}");

        response.prettyPrint();
    }

}

