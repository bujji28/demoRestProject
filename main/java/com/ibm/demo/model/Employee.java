package com.ibm.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name="Employee")
public class Employee {

	// Primary ID which increments
	// automatically when new entry
	// is added into the database
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	String name;

    String jobRole;

	public Employee()
	{
	}

	// Parameterized constructor
	public Employee(String name, String jobRole)
	{
		this.name = name;
		this.jobRole = jobRole;
	}

	// Getters and setters of
	// the variables
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getJobRole()
	{
		return jobRole;
	}
	
	public void setJobRole(String jobRole)
	{
		this.jobRole = jobRole;
	}
	

}
