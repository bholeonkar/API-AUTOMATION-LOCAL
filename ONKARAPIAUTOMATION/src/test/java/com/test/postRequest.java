package com.test;

public class postRequest {

	
	@Test
    //passing json value as String -->Not recommended
    public void postReq() {
       /* String Jsonbody="{\n" +
                "  \"id\": 18,\n" +
                "  \"first_name\": \"Tilak\",\n" +
                "  \"last_name\": \"Varma\",\n" +
                "  \"email\": \"tk@gmail.com\"\n" +
                "}";
        Response response=given()
                .header("Content-Type","application/json")
                .body(Jsonbody).log().all()
                .post("http://localhost:3000/employees");
        response.prettyPrint();
        System.out.println(response.getStatusCode());*/
    }

    @Test
    //use it only for static data(when there is no need to change values in payload)
    public void postReqFile() throws IOException {
        Response response = given().header("Content-Type", "application/json")
                .log().all()
                .body(new File(System.getProperty("user.dir") + "/NewEmployee.json"))
                .post("http://localhost:3000/employees");
        response.prettyPrint();

        Files.write(Paths.get(System.getProperty("user.dir")+"/response.json"),response.asByteArray());

    }

    @Test
    //Can be used when need to change values in payload during runtime
    public void PostReqThirdMethod() throws IOException {
        String reqBody = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/NewEmployee.json")));
        String replace = reqBody.replace("id", String.valueOf(new Faker().number().numberBetween(10, 100)))
                .replace("fname", String.valueOf(new Faker().name().firstName()));

        Response response = given().header("Content-Type", "application/json")
                .body(replace)
                .post("http://localhost:3000/employees");

        response.prettyPrint();
    }

    @Test
    public void PostRequestbyMap() {
        Map<String, Object> payload = new LinkedHashMap<>(); //linkedHashMap is used to maintain order
        payload.put("id", String.valueOf(new Faker().number().numberBetween(10, 100)));
        payload.put("firstName", String.valueOf(new Faker().name().firstName()));
        payload.put("lastName", String.valueOf(new Faker().name().lastName()));
        payload.put("email", "abc@gmail.com");

        Response response = given().header("Content-Type", "application/json")
                .body(payload).post("http://localhost:3000/employees");

        response.prettyPrint();
    }

    @Test
    public void PostReComplexPayload() {

        //{}-->Map has to be created
        //[]-->List has to be created
        Map<String, Object> payload = new LinkedHashMap<>(); //linkedHashMap is used to maintain order
        payload.put("id", String.valueOf(new Faker().number().numberBetween(10, 100)));
        payload.put("firstName", String.valueOf(new Faker().name().firstName()));
        payload.put("lastName", String.valueOf(new Faker().name().lastName()));
        payload.put("email", "India@gmail.com");

        List<String> values = new ArrayList<>();
        values.add("testing");
        values.add("devops");

        payload.put("jobs", values);
        Map<String, Object> foodList = new HashMap<>();
        foodList.put("breakfast", "poori");
        foodList.put("lunch", "rice");

        List<String> dinner = new ArrayList<>();
        dinner.add("chapathi");
        dinner.add("paneer");

        foodList.put("dinner", dinner);

        payload.put("favfoods", foodList);

        Response response = given().header("Content-Type", "application/json")
                .body(payload).post("http://localhost:3000/employees");

        response.prettyPrint();
    }
}
