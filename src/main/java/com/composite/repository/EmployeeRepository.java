package com.composite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.composite.entity.Employee;
import com.composite.entity.EmployeeIdentity;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeeIdentity> {

	public List<Employee> findByEmployeeIdentityCompanyId(String companyId);

	@Query("select u from Employee u where u.email = ?1")
	public List<Employee> findByEmailAddress(String email);

	@Query("select u from Employee u where u.name = :name")
	public List<Employee> findByEmployeeName(@Param("name") String name);

	@Modifying
	@Query("update Employee u set u.name = :name where u.email = :email")
	public int updateUserSetNameForEmail(@Param("name") String name, @Param("email") String email);

}