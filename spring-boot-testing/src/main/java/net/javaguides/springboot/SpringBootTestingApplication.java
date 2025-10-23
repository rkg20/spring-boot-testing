package net.javaguides.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestingApplication.class, args);

		Student student = new Student(1L, "John Doe", "jphn@gmail.com");
		System.out.println("Student Name: " + student.getName());
	}

}
