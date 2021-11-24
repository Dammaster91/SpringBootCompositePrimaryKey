package com.composite.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.composite.entity.Employee;
import com.composite.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@RequestMapping(value = "/saveEmp", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveBook(@RequestBody Employee emp) {

		ResponseEntity<?> resp = null;
		try {
			Employee bookResponse = empService.saveEmp(emp);
			resp = new ResponseEntity<Employee>(bookResponse, HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;

	}

	@RequestMapping(value = "/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> findByEmployeeIdentityCompanyId(@PathVariable String companyId) {
		List<Employee> bookResponse = empService.findByEmployeeIdentityCompanyId(companyId);

		return bookResponse;
	}

	@RequestMapping(value = "email/{email}", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> findByEmailAddress(@PathVariable String email) {
		List<Employee> bookResponse = empService.findByEmailAddress(email);

		return bookResponse;
	}

	@RequestMapping(value = "name/{name}/{email}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> updateUserSetNameForEmail(@PathVariable String name, @PathVariable String email) {

		ResponseEntity<String> resp = null;
		try {
			Integer id = empService.updateUserSetNameForEmail(name, email);
			resp = new ResponseEntity<String>("Employee '" + id + "' Updated", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	
		
	}
	
	@RequestMapping(value = "emails/{email}", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> findUserByEmails(@PathVariable String email) {
		Set<String> s=new HashSet<>();
		s.add(email);
		List<Employee> bookResponse = empService.findUserByEmails(s);

		return bookResponse;
	}
}