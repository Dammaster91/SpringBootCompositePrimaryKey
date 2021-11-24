package com.composite.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import com.composite.entity.Employee;

@Component
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Employee> findUserByEmails(Set<String> emails) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
		Root<Employee> Employee = query.from(Employee.class);

		Path<String> emailPath = Employee.get("email");

		List<Predicate> predicates = new ArrayList<>();
		for (String email : emails) {
			predicates.add(cb.like(emailPath, email));
		}
		query.select(Employee).where(cb.or(predicates.toArray(new Predicate[predicates.size()])));

		return entityManager.createQuery(query).getResultList();
	}
}