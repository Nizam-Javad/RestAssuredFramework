package com.org.day6;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

public class SchemaValidator {

    @Test
    public void jsonSchemaValidator(){
        ValidatableResponse body = given()
                .when().get("http://localhost:3000/students")
                .then()
                .assertThat().body(matchesJsonSchema("{\n" +
                        "  \"type\": \"array\",\n" +
                        "  \"items\": {\n" +
                        "    \"type\": \"object\",\n" +
                        "    \"properties\": {\n" +
                        "      \"id\": {\n" +
                        "        \"type\": \"string\"\n" +
                        "      },\n" +
                        "      \"name\": {\n" +
                        "        \"type\": \"string\"\n" +
                        "      },\n" +
                        "      \"location\": {\n" +
                        "        \"type\": \"string\"\n" +
                        "      },\n" +
                        "      \"phone\": {\n" +
                        "        \"type\": \"string\"\n" +
                        "      },\n" +
                        "      \"course\": {\n" +
                        "        \"type\": \"array\",\n" +
                        "        \"items\": {\n" +
                        "          \"type\": \"string\"\n" +
                        "        }\n" +
                        "      }\n" +
                        "    },\n" +
                        "    \"required\": [\n" +
                        "      \"id\",\n" +
                        "      \"name\",\n" +
                        "      \"location\",\n" +
                        "      \"phone\",\n" +
                        "      \"course\"\n" +
                        "    ]\n" +
                        "  }\n" +
                        "}"));
        //.assertThat().body(matchesJsonSchemaInClasspath("C:\\Users\\DELL\\RestAssured Framework\\RestAssuredFramework\\MVNAPIFramework\\src\\test\\java\\com\\org\\day6\\JsonSchema.json"));
    }


}