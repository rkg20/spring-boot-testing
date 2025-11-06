package net.javaguides.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.springboot.model.Employee;

@SpringBootApplication
public class SpringBootTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestingApplication.class, args);

		// Student student = new Student(1L, "John Doe", "jphn@gmail.com");
		// System.out.println("Student Name: " + student.getName());

		// Employee employee=Employee.builder()
        //                         .id(1L)
        //                         .firstName("Rahul")
        //                         .lastName("Gupta")
        //                         .email("rahul@gmail.com")
        //                         .build();

		// System.out.println(Optional.of(employee));
	}


}
