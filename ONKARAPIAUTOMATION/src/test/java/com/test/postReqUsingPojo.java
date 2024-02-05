package com.test;

import java.util.ArrayList;
import java.util.List;

import org.asynchttpclient.Response;
import org.testng.annotations.Test;

import com.pojo.EmployeeInfo;
import com.pojo.FavFoodInfo;

public class postReqUsingPojo {

	
	/*POJO Instructions
    {}-->Class file
    []-->List<Type> creation*/

    @Test
    public void pojoReq() {

        Marks marks = new Marks(80, 90);
        Marks marks1 = new Marks(90, 100);
        List<Marks> allMarks = new ArrayList<>();
        allMarks.add(marks);
        allMarks.add(marks1);

        List<String> dinner = new ArrayList<>();
        dinner.add("Dosa");
        dinner.add("Paneer");

        List<String> jobs = new ArrayList<>();
        jobs.add("Automation Tester");
        jobs.add("devops");

        FavFoodInfo favFood = new FavFoodInfo("Poori", "FriedRice", dinner);

        EmployeeInfo employee = new EmployeeInfo(40, "Praveen", "Xavier", "12345@gmail.com", favFood, jobs, allMarks);

        Response response = given().header("Content-Type", ContentType.JSON)
                .body(employee).post("http://localhost:3000/employees");

        response.prettyPrint();
    }
}
