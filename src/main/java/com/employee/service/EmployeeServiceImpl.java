package com.employee.service;

import com.employee.domain.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository repository;

    @Override
    public List<Employee> getEmployee() {
        return repository.findAll();
    }

	@Override
	public Employee saveEmployee(Employee employee) {
	employee=repository.save(employee);
	return employee;
		
	}
	
	@Override
	public Employee getEmployeeByID(int id) {
		 return repository.findById(id).get();
		
	}

	@Override
	public String deleteEmployeeByID(int id) {
		repository.deleteById(id);
		return "Employee Record Deleted with ID "+id;
		
	}
}
