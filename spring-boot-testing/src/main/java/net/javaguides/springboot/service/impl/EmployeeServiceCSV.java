package net.javaguides.springboot.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.PublicKey;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import jakarta.transaction.Transactional;
import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.mapper.EmployeeMapper;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceCSV {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    // public EmployeeServiceCSV(){

    // }
    // public EmployeeServiceCSV(EmployeeRepository employeeRepository){
    //     this.employeeRepository=employeeRepository;
    // }

    // @Transactional
    // public void saveUserFromCSV() throws Exception{
        
    //     ClassPathResource resource=new ClassPathResource("employees.csv");
    //     BufferedReader reader=new BufferedReader(new InputStreamReader(resource.getInputStream()));

    //     try(reader){
    //         CsvToBean<EmployeeDto> csvToBean=new CsvToBeanBuilder<EmployeeDto>(reader)
    //             .withType(EmployeeDto.class)
    //             .withIgnoreLeadingWhiteSpace(true)
    //             .build();
    //         List<EmployeeDto> employeeDtos=csvToBean.parse();
    //         List<Employee> employees=employeeDtos.stream().map(ele -> EmployeeMapper.EmployeeDtoToEmployee(ele)).collect(Collectors.toList());

    //         System.out.println(employees.size());
    //         for(Employee employee: employees){
    //             employeeRepository.save(employee);
    //         }
    //         System.out.println("Employee save to DB successfully");
    //     }

    
    // }


    // public void saveTODB2() throws IOException{

    //     ClassPathResource resource=new ClassPathResource("employees.csv");

    //     BufferedReader reader=new BufferedReader(new InputStreamReader(resource.getInputStream()));
    //     try(reader){
    //         CsvToBean<EmployeeDto> bean= new CsvToBeanBuilder<EmployeeDto>(reader)
    //         .withType(EmployeeDto.class)    
    //         .withIgnoreLeadingWhiteSpace(true).build();

    //         List<EmployeeDto> list=bean.parse();
    //         for(EmployeeDto emp: list){
    //             System.out.println(emp);
    //         }
    //         System.out.println("List Printed");

    //     }
    //     catch(Exception e){
    //         e.printStackTrace();
    //     }


    // }
    


}
