package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.val;
import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController{

    @Autowired
    private EmployeeService employeeService;



    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    //     @GetMapping("/save")
    // public String saveData(@RequestParam String key, @RequestParam String value){
    //     valkeyService.saveData(key, value);
    //     return "Data Saved";
    // }

    // @GetMapping("/get")
    // public String getData(@RequestParam String key){
    //     return valkeyService.getData(key);
    // }


    @PostMapping("/employee")
    public ResponseEntity<EmployeeDto>  createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto=employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<EmployeeDto>(savedEmployeeDto, HttpStatus.CREATED);
    }
    
    // Get Employee By Id  
    @GetMapping("/employee/{Id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("Id") long Id){
        EmployeeDto employeeDto=employeeService.getEmployeeById(Id);
        return ResponseEntity.ok(employeeDto);
    }

    // Get All Employees 
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(@RequestParam(required = false, name = "page") Integer pageNumber ){
        if(pageNumber==null){
            pageNumber=0;
        }
        List<EmployeeDto> employeeDtos=employeeService.getAllEmployees(pageNumber);
        return new ResponseEntity<List<EmployeeDto>>(employeeDtos,HttpStatus.OK);
    }

    @PutMapping("/employee/{Id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("Id") long employeeId, @RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedEmployeeDto=employeeService.updatEmployee(employeeId, employeeDto);
        return ResponseEntity.ok(updatedEmployeeDto);
    }

    @GetMapping("employee")
    public ResponseEntity<?> getEmployeeByEmail(@RequestParam("email") String email){
        // Optional<List<EmployeeDto>> employeeDto =employeeService.getEmployeeByEmail(email);
        //  if(employeeDto.isEmpty() ){
        //     return ResponseEntity.ok("No Email is Found ");
        //  }
        //  return ResponseEntity.ok(employeeDto.get());
        return null;
    }




    @DeleteMapping("/employee/{Id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("Id") long employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully");
    }

    

}