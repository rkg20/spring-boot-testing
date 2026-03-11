package net.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class VehicleController {
 

    // 

//     {
//   "vehicles": [
//     {
//       "id": "V1",
//       "brand": "Honda",
//       "model": "City",
//       "year": 2021,
//       "features": ["sunroof", "automatic", "petrol"]
//     },
//     {
//       "id": "V2",
//       "brand": "Hyundai",
//       "model": "Verna",
//       "year": 2019,
//       "features": ["manual", "petrol"]
//     },
//     {
//       "id": "V3",
//       "brand": "Tata",
//       "model": "Nexon",
//       "year": 2023,
//       "features": ["sunroof", "diesel", "automatic"]
//     }
//   ]
// }


    @PostMapping("/vehicles")
    public void getVehicle(@RequestBody JsonNode jsonNode){

        JsonNode vehiclesNode = jsonNode.get("vehicles");
        if (vehiclesNode != null && vehiclesNode.isArray()) {
            for (JsonNode vehicleNode : vehiclesNode) {
                String id = vehicleNode.get("id").asText();
                String brand = vehicleNode.get("brand").asText();
                String model = vehicleNode.get("model").asText();
                int year = vehicleNode.get("year").asInt();

                System.out.println("ID: " + id + ", Brand: " + brand + ", Model: " + model + ", Year: " + year);

                List<String> featuresList = new ArrayList<>();
                JsonNode featuresNode = vehicleNode.get("features");
                if (featuresNode != null && featuresNode.isArray()) {
                    for (JsonNode featureNode : featuresNode) {
                        featuresList.add(featureNode.asText());
                    }
                }

                System.out.println("Features: " + String.join(", ", featuresList));
            }
        }

    }


//     [{
//     "name": "AAA",
//     "age": 30,
//     "isStudent": false,
//     "courses": [
//       "Math",
//       "Science"
//     ],
//     "address": {
//       "street": "123 Main St",
//       "city": "Anytown",
//       "zipcode": "12345"
//     }
//   },
//     {
//     "name": "BBB",
//   "age": 30,
//   "isStudent": false,
//   "courses": [
//     "Science",
//     "History"
//   ],
//   "address": {
//     "street": "123 Main St",
//     "city": "Anytown",
//     "zipcode": "12345"
//   }
//   },
// {
//   "name": "CCC",
//   "age": 30,
//   "isStudent": false,
//   "courses": [
//     "Math"
//   ],
//   "address": {
//     "street": "123 Main St",
//     "city": "Anytown",
//     "zipcode": "12345"
//   }
//   }]

    @PostMapping("/students")
    public void getStudents(@RequestBody JsonNode jsonNode){
        
        if (jsonNode != null && jsonNode.isArray()) {
            for (JsonNode studentNode : jsonNode) {
                String name = studentNode.get("name").asText();
                int age = studentNode.get("age").asInt();
                boolean isStudent = studentNode.get("isStudent").asBoolean();

                System.out.println("Name: " + name + ", Age: " + age + ", isStudent: " + isStudent);

                List<String> coursesList = new ArrayList<>();
                JsonNode coursesNode = studentNode.get("courses");
                if (coursesNode != null && coursesNode.isArray()) {
                    for (JsonNode courseNode : coursesNode) {
                        coursesList.add(courseNode.asText());
                    }
                }

                System.out.println("Courses: " + String.join(", ", coursesList));

                JsonNode addressNode = studentNode.get("address");
                if (addressNode != null) {
                    String street = addressNode.get("street").asText();
                    String city = addressNode.get("city").asText();
                    String zipcode = addressNode.get("zipcode").asText();

                    System.out.println("Address: " + street + ", " + city + ", " + zipcode);
                }
            }
        }
    }


    @PostMapping("/student/v2")
    public void getStudentsV2(@RequestBody JsonNode jsonNode){

        
        for(JsonNode studentNode : jsonNode){

            List<String> courses = new ArrayList<>();

            String studentName= studentNode.get("name").asText();
            int studentAge=studentNode.get("age").asInt();

            for(JsonNode courseNode: studentNode.get("courses")){
                courses.add(courseNode.asText());
            }
            System.out.println(studentName+" "+studentAge+" "+courses);

            JsonNode studentAddress= studentNode.get("address");
            String studentStreet=studentAddress.get("street").asText();
            String studentCity = studentAddress.get("city").asText();
            String studentZipcode = studentAddress.get("zipcode").asText();

            System.out.println(studentAddress+" "+studentStreet+" "+studentCity+" "+studentZipcode);

        }

    }

    @GetMapping("/student/v3")
    public void getStudentV3(@RequestBody JsonNode jsonNode){
        String name=jsonNode.get("name").asText();
        System.out.println(name);

    }


}