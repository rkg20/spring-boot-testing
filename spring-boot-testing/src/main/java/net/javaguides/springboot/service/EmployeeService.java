package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import net.javaguides.springboot.model.Employee;

public interface EmployeeService {
    
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(long employeeId);
    Employee updatEmployee(Employee employee);
    void deleteEmployeeById(long employeeId);


}
