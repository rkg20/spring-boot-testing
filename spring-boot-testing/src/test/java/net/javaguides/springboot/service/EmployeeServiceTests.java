package net.javaguides.springboot.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {
    
    // private EmployeeRepository employeeRepository;
    // private EmployeeService employeeService;


    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;


    Employee employee;

    @BeforeEach
    public void setup(){
        // employeeRepository=Mockito.mock(EmployeeRepository.class);
        // employeeService=new EmployeeServiceImpl(employeeRepository);

        employee=Employee.builder()
                                .id(1L)
                                .firstName("Rahul")
                                .lastName("Gupta")
                                .email("rahul@gmail.com")
                                .build();


    }


    @Test
    @DisplayName("Junit for saved Employee Method")
    public void givenEmployeeObject_whenSavedObject_thenReturnEmployeeObject(){

        // given - precondition or setup
        
        System.out.println(BDDMockito.given(employeeRepository.findByEmail(employee.getEmail()))
                .willReturn(Optional.empty()));
        
        BDDMockito.given(employeeRepository.save(employee)).willReturn(employee);

        // when - action or behaviour that we are going test
        
        Employee savedEmployee= employeeService.saveEmployee(employee);


        // then - verify the output

        Assertions.assertThat(savedEmployee).isNotNull();

    }


    // 

    @Test
    @DisplayName("Junit for saved Employee Method which throw exception")
    public void givenEmployeeObject_whenSavedObject_thenThrowsException(){

        BDDMockito.given(employeeRepository.findByEmail(employee.getEmail()))
                .willReturn(Optional.of(employee));

        // When

        assertThrows(ResourceNotFoundException.class, ()-> {
            employeeService.saveEmployee(employee);
        });
        
        // then 
        verify(employeeRepository,never()).save(any(Employee.class));

    }


    @Test
    @DisplayName("Junit for get All Employee Method")
    public void givenEmployeeList_whenGetAllEmployee_thenReturnEmployeeList(){

        Employee employee2 = Employee.builder()
                .id(1L)
                .firstName("Rahul")
                .lastName("Gupta")
                .email("rahul@gmail.com")
                .build();
        

        // Given - precondition or setup
        BDDMockito.given(employeeRepository.findAll()).willReturn(List.of(employee,employee2));

        // when 
        
        List<Employee> employeeList=employeeService.getAllEmployees();

        // then

        Assertions.assertThat(employeeList).isNotNull();
        Assertions.assertThat(employeeList.size()).isEqualTo(2);

    }

    @Test
    @DisplayName("Junit for get All Employee Method Negative scenerio")
    public void givenEmptyEmployeeList_whenGetAllEmployees_thenReturnEmptyEmployeesList(){

        // given
        BDDMockito.given(employeeRepository.findAll()).willReturn(Collections.emptyList());

        // when

        List<Employee> employees=employeeService.getAllEmployees();

        // then
    
        Assertions.assertThat(employees).isEmpty();
        Assertions.assertThat(employees.size()).isEqualTo(0);
    
    }


    @Test
    @DisplayName("")
    public void givenEmployeeId_whenGetEmployeeById_thenReturnEmployeeObject(){

        // given
        BDDMockito.given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));
        // when

        Employee fetchedEmployee=employeeService.getEmployeeById(1).get();
        // then

        Assertions.assertThat(fetchedEmployee).isNotNull();

    }


    // Update the Employee Object
    @Test
    @DisplayName("")
    public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee(){

        // given

        BDDMockito.given(employeeRepository.save(employee)).willReturn(employee);

        employee.setEmail("ayush@gmail.com");
        employee.setFirstName("Ayush");
        // /when

        Employee savedemployee=employeeService.saveEmployee(employee);

        // /then

        Assertions.assertThat(employee.getEmail()).isEqualTo("ayush@gmail.com");
        Assertions.assertThat(employee.getFirstName()).isEqualTo("Ayush");

    }

    @Test
    public void givenEmployeeId_whenDeleteEmployee_thenNothing(){

        // before
        long employeeId=1L;
        BDDMockito.willDoNothing().given(employeeRepository).deleteById(employeeId);

        // when

        employeeService.deleteEmployeeById(employeeId);


        // then

        verify(employeeRepository,times(1)).deleteById(employeeId);;

    }


}
