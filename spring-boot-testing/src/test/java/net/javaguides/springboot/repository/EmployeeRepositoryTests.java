package net.javaguides.springboot.repository;


import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import net.javaguides.springboot.model.Employee;

@DataJpaTest
public class EmployeeRepositoryTests{

    @Autowired
    private EmployeeRepository employeeRepository;

    // unit test for save employee operation
    @Test
    @DisplayName("Junit test for employee save method")
    public void givenEmployee_whenSave_then(){
        
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("rahul")
                .lastName("gupta")
                .email("rahul@gmail.com")
                .build();

        // when - action or the behaviour that we are going to test

        Employee savedEmployee=employeeRepository.save(employee);

        // then - verify the output
        Assertions.assertThat(savedEmployee).isNotNull();
        Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);
        
    } 


    // unit test for get all employees operation
    @Test
    public void givenEmployeeList_whenFindAll_thenEmployeeList(){
        
        // given - precondition or setup
        Employee employee1 = Employee.builder()
                .firstName("rahul")
                .lastName("gupta")
                .email("rahul@gmail.com")
                .build();

        Employee employee2 = Employee.builder()
                .firstName("abc")
                .lastName("ab")
                .email("abc@gmail.com")
                .build();

        List<Employee> employees=Arrays.asList(employee1, employee2);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        List<Employee> fetechEmployees=employeeRepository.findAll();


        // then - verify the output
        assertThat(fetechEmployees).isNotNull();
        assertThat(fetechEmployees.size()).isEqualTo(2);
        
    }

    // unit test for get employee by id operation
    @Test
    public void givenEmployee_whenFindById_thenEmployee(){
        
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("rahul")
                .lastName("gupta")
                .email("rahul@gmail.com").build();

        Employee savedEmployee=employeeRepository.save(employee);
        
        // when - action or the behaviour that we are going to test

        Employee fetechEmployee=employeeRepository.findById(savedEmployee.getId()).get();
        // then - verify the output
        assertThat(fetechEmployee).isNotNull();
        assertThat(fetechEmployee.getId()).isEqualTo(savedEmployee.getId());

    }

    @DisplayName("JUnit test for find employee by email")
    @Test
    public void givenEmployee_whenFindByEmail_thenEmployee(){
        
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("rahul")
                .lastName("gupta")
                .email("rahul@gmail,com").build();

        employeeRepository.save(employee);
        // when - action or the behaviour that we are going to test
        Employee fetechEmployee=employeeRepository.findByEmail(employee.getEmail()).get();
        // then - verify the output
        assertThat(fetechEmployee).isNotNull();
        assertThat(fetechEmployee.getEmail()).isEqualTo(employee.getEmail());

    }

    @DisplayName("JUnit test for update employee operation")
    @Test
    public void givenEmployee_whenUpdate_thenUpdateEmployee(){
        
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("rahul")
                .lastName("gupta")
                .email("rahul.gupta@gmail.com").build();

        Employee savedEmployee=employeeRepository.save(employee);
        // when - action or the behaviour that we are going to test
        savedEmployee.setEmail("rahul.gupta2@gmail.com");
        Employee updatedEmployee=employeeRepository.save(savedEmployee);    
        // then - verify the output
        assertThat(updatedEmployee.getEmail()).isEqualTo("rahul.gupta2@gmail.com");

    }

    @DisplayName("JUnit test for delete employee operation")
    @Test  
    public void givenEmployee_whenDelete_thenRemoveEmployee(){
        
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("rahul")
                .lastName("gupta")
                .email("rahul.gupta@gmail.com").build();
    
        Employee savedEmployee=employeeRepository.save(employee);
        // when - action or the behaviour that we are going to test     
        employeeRepository.deleteById(savedEmployee.getId());
        // then - verify the output
        assertThat(employeeRepository.findById(savedEmployee.getId())).isEmpty();
        
    }
    
}