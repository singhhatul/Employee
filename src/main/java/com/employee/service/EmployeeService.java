package com.employee.service;

import com.employee.domain.Employee;
import java.util.List;

public interface EmployeeService {

	public  List<Employee> getEmployee();
    
    public Employee saveEmployee(Employee employee);
    
    public Employee getEmployeeByID(int id);
    
    public String deleteEmployeeByID(int id);
    
}
