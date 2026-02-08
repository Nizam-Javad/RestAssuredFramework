package com.org.day6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.POJOClass;
import org.testng.annotations.Test;

public  class SerializationDeserialization {


     @Test(priority =1)
     //serialization
     public void Object2Json() throws JsonProcessingException {
          POJOClass pojo = new POJOClass();
          pojo.setName("Serial1");
          pojo.setPhone("62728192");
          pojo.setLocation("India");
          String courses []={"QA","SDET"};
          pojo.setCourse(courses);

         ObjectMapper om= new ObjectMapper();
         String json=om.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
         System.out.println(json);


     }

     @Test(priority = 2)
     //De-serialization
    public void Json2Object() throws JsonProcessingException {
         String json="{\n" +
                 "  \"name\" : \"Serial1\",\n" +
                 "  \"phone\" : \"62728192\",\n" +
                 "  \"location\" : \"India\",\n" +
                 "  \"course\" : [ \"QA\", \"SDET\" ]\n" +
                 "}";
         ObjectMapper om= new ObjectMapper();
               POJOClass data=  om.readValue(json,POJOClass.class);
               System.out.println("Name is : "+data.getName());
         System.out.println("hone Number is : "+data.getPhone());
         System.out.println("Courses are : "+data.getCourse()[0]);
         System.out.println("Location is : "+data.getLocation());
     }

}
