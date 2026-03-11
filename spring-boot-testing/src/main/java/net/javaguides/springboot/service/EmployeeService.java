package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import net.javaguides.springboot.dto.EmployeeDto;

public interface EmployeeService {
    
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees(Integer pageNumber);
    EmployeeDto getEmployeeById(long employeeId);
    EmployeeDto updatEmployee(Long employeeId,EmployeeDto employeeDto);
    void deleteEmployeeById(long employeeId);
    List<EmployeeDto> getEmployeeByEmail(String email);

}
