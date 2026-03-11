package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.exception.EmailAlreadyExistException;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.mapper.EmployeeMapper;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        
        Optional<Employee> employee=employeeRepository.findByEmail(employeeDto.getEmail());
        if(employee.isPresent()){
            throw new EmailAlreadyExistException("Email Already Exist ",HttpStatus.CONFLICT);
        }
        Employee savedEmployee=employeeRepository.save(EmployeeMapper.EmployeeDtoToEmployee(employeeDto));

        return EmployeeMapper.EmployeeToEmployeeDto(savedEmployee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees(Integer pageNumber) {
        PageRequest pageable=PageRequest.of(pageNumber, 10);

        List<Employee> employees= employeeRepository.findAll(pageable).toList();
        return employees.stream().map( employee -> EmployeeMapper.EmployeeToEmployeeDto(employee)).collect(Collectors.toList());
    }   

    @Override
    public EmployeeDto getEmployeeById(long employeeId) {
        
        Optional<Employee> employee= employeeRepository.findById(employeeId);
        System.out.println("Checking the Employee Data "+employee.isEmpty());
        if(employee.isEmpty()){
            throw new ResourceNotFoundException("Id "+employeeId+" Not Found",HttpStatus.NOT_FOUND);
        }
        
        CompletableFuture<EmployeeDto> future =CompletableFuture.supplyAsync( () -> employeeRepository.findById(employeeId).get())
        .thenApply( (employee1)-> EmployeeMapper.EmployeeToEmployeeDto(employee1));
        
        return null;
        
    }

    @Override
    public EmployeeDto updatEmployee(Long employeeId, EmployeeDto employeeDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatEmployee'");
    }

    @Override
    public void deleteEmployeeById(long employeeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEmployeeById'");
    }

    @Override
    public List<EmployeeDto> getEmployeeByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployeeByEmail'");
    }
    
}




// 1. Atomic class 
// 2. parallel Stream vs concurrency 