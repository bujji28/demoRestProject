package com.ibm.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ibm.demo.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	List<Employee> findAll();
	Employee findById(int id);
	Employee save(Employee employee);
	void deleteById(int id);

}
