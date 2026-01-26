package com.org;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static org.hamcrest.Matchers.equalTo;


import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.given;

public class PostExternalfile{



    public PostExternalfile()  {


    }
    @Test
    public void ExternalJson() throws FileNotFoundException {
        File f1 = new File("C:\\Users\\DELL\\RestAssured Framework\\RestAssuredFramework\\MVNAPIFramework\\testdata\\body.json");
        FileReader fr= new FileReader(f1);
        JSONTokener jt= new JSONTokener(fr);
        JSONObject jo= new JSONObject(jt);

        given().contentType("application/json")
                .body(jo.toString())
                .when().post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name",equalTo("Helena"))
                .log().all();
    }
}