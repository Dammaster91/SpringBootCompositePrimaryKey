package com.composite.service.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.composite.entity.Employee;
import com.composite.repository.EmployeeRepository;
import com.composite.repository.EmployeeRepositoryCustom;
import com.composite.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeRepositoryCustom employeeRepositoryCustom;

	@Override
	public Employee saveEmp(Employee emp) {
		return employeeRepository.save(emp);

	}

	@Override
	public List<Employee> findByEmployeeIdentityCompanyId(String companyId) {
		return employeeRepository.findByEmployeeIdentityCompanyId(companyId);
	}

	@Override
	public List<Employee> findByEmailAddress(String email) {
		return employeeRepository.findByEmailAddress(email);
	}

	@Override
	public int updateUserSetNameForEmail(String name, String email) {
		return employeeRepository.updateUserSetNameForEmail(name, email);

	}

	@Override
	public List<Employee> findUserByEmails(Set<String> emails) {
		return employeeRepositoryCustom.findUserByEmails(emails);
	}

}