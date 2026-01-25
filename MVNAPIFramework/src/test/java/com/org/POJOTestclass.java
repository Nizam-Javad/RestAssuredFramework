package com.org;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class POJOTestclass{

@Test
public void Post(){
    POJOClass pc = new POJOClass();
    pc.setName("Mariya");
    pc.setLocation("Bouston");
    pc.setPhone("3672893");
    String [] cr={"PLC","Scada"};
    pc.setCourse(cr);

    given()
            .contentType("application/json")
            .body(pc)
            .when().post("http://localhost:3000/students")
            .then()
            .statusCode(201)
            .body("name",equalTo(pc.getName()))



            .log().all();
}

}