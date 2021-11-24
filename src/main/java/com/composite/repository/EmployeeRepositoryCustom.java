package com.composite.repository;

import java.util.List;
import java.util.Set;

import com.composite.entity.Employee;

public interface EmployeeRepositoryCustom {
    List<Employee> findUserByEmails(Set<String> emails);
}