package com.ibm.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibm.demo.model.Employee;
import com.ibm.demo.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JPAUnitTests {

  @Autowired
  EmployeeRepository repository;

  @Test
  public void should_store_an_employee() { 
	  Employee emp = repository.save(new Employee("James", "QA Manager"));
	  
	  assertThat(emp).hasFieldOrPropertyWithValue("name", "James");
	  assertThat(emp).hasFieldOrPropertyWithValue("jobRole", "QA Manager");
  }

  @Test
  public void should_find_all_employees() {
	  Employee emp1 = repository.save(new Employee("Jack", "Validation Engineer"));
	  Employee emp2 = repository.save(new Employee("Martin", "Firmware Engineer"));
	  
	  List<Employee> emps = repository.findAll();
	  
	  assertThat(emps).contains(emp1, emp2);

  }

  @Test
  public void should_find_employee_by_id() { 
	  Employee emp1 = repository.save(new Employee("Quinn", "Automation Engineer"));
	  
	  Employee emp = repository.findById(emp1.getId());
	  //assertThat(emp).hasFieldOrPropertyWithValue("name", "Quinn");
	  //assertThat(emp).hasFieldOrPropertyWithValue("jobRole", "Automation Engineer");
	  assertThat(emp1).isEqualTo(emp);

  }

  @Test
  public void should_update_employee_by_id() { 
	  Employee emp1 = repository.save(new Employee("Quinn", "Automation Engineer"));

	  Employee emp = repository.findById(emp1.getId());
	  emp.setName("Katrisha");
	  emp.setJobRole("Product Owner");
	  
	  Employee newEmp = repository.save(emp);
	  
	  assertThat(newEmp).isEqualTo(emp);
  }

  @Test
  public void should_delete_employee_by_id() { 
	  Employee emp1 = repository.save(new Employee("Quinn", "Automation Engineer"));
	  
	  repository.deleteById(emp1.getId());
	  
	  Employee emp = repository.findById(emp1.getId());
	 
  }

}
