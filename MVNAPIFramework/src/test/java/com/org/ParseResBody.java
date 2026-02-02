package com.org;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

public class ParseResBody{

 @Test
 public void getStudentsData(){
     POJOClass pojo= new POJOClass();;
     Response res= given().contentType("application/json")
             .when().get("http://localhost:3000/students");

     JSONArray ja= new JSONArray(res.asString());
     for(int i=0;i<ja.length();i++){
         System.out.println(ja.getJSONObject(i).get("name").toString());
     }
 }

    @Test
    public void getBooksData(){
        Response res= given()
                        .when().get("http://localhost:3000/books");
        JSONArray ja= new JSONArray(res.asString());

        for(int i=0;i<ja.length();i++) {
            System.out.println(ja.getJSONObject(i).get("title").toString());
            System.out.println("Adding a new line");

        }
    }

}