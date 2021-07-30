package com.employee.controller;

import com.employee.domain.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;
    
    @Autowired
    private Environment env; // This is one way of calling property from application.property file

    @Value("${spring.key}") //  This is another way of calling property from application.property file
    String username;
    
//    @ConfigurationProperties(prefix="spring.demo")
//    @Configuration
//    public class DemoProperties {
//      private String username;
//      private String password;
//      private String email;
//  This is another way of calling property from application.property file   
    
    
    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return service.getEmployee();
    }
    
    /*		This method is created to test and check the value 
     *		from application.properties 	
     * 
     */
    @GetMapping("env")
    public String envDetails(){
    	return env.getProperty("spring.key")+username;
    }
    
    @GetMapping("employee/{empId}")
    public Employee getEmployeeById(@PathVariable("empId") int id) {
    	return service.getEmployeeByID(id);
    }
    
    @PostMapping("employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
    	return service.saveEmployee(employee);
    }
    
    @DeleteMapping("employee/{empId}")
    public String deleteEmployeeByID(@PathVariable("empId") int id) {
    	return service.deleteEmployeeByID(id);
    }
    
}
