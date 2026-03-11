package net.javaguides.springboot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.client.RestClient;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import net.javaguides.springboot.config.RedisConfig;
import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.impl.EmployeeServiceCSV;


@SpringBootApplication
public class SpringBootTestingApplication {


	RedisConfig redisConfig;



	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootTestingApplication.class, args);
				

		Path path=Path.of("C:\\Users\\2119516\\Downloads\\data\\employees.csv").toAbsolutePath().normalize();
		
		FileSystemResource resource=new FileSystemResource(path);
		BufferedReader reader=new BufferedReader(new InputStreamReader(resource.getInputStream()));

		try(reader){
			CsvToBean<EmployeeDto> bean = new CsvToBeanBuilder<EmployeeDto>(reader)
							.withType(EmployeeDto.class)
							.withIgnoreLeadingWhiteSpace(true)
							.build();

			List<EmployeeDto> emps=bean.parse();

			for(EmployeeDto emp: emps){
				System.out.println(emp);
			}

			

		}


		
		// serviceCSV.saveUserFromCSV();
		// try {
		// 	EmployeeServiceCSV serviceCSV=new EmployeeServiceCSV();
		// 	 serviceCSV.saveUserFromCSV();

		// } catch (Exception e) {
		// 	e.printStackTrace();
		// }

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


	@Bean
	public RestClient getRestClient(){
		return RestClient.create();
	}

	

}
