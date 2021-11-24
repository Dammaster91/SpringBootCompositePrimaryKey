package com.composite.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.composite.entity.Employee;

@Component
public interface EmployeeService {
	public Employee saveEmp(Employee emp);

	public List<Employee> findByEmployeeIdentityCompanyId(String companyId);

	public List<Employee> findByEmailAddress(String email);

	public int updateUserSetNameForEmail(String name, String email);
	
	public List<Employee> findUserByEmails(Set<String> emails);
}