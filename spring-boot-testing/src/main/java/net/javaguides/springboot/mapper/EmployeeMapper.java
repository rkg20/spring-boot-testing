package net.javaguides.springboot.mapper;


import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.model.Employee;

public class EmployeeMapper {

    
    public static EmployeeDto  EmployeeToEmployeeDto(Employee ele){
        return new EmployeeDto(
            ele.getId(), 
            ele.getFirstName(), 
            ele.getLastName(), 
            ele.getEmail()
        );
    }
    public static Employee EmployeeDtoToEmployee(EmployeeDto employeeDto){
        return new Employee(
            employeeDto.getId(), 
            employeeDto.getFirstName(), 
            employeeDto.getLastName(), 
            employeeDto.getEmail()
        );

    }

}
