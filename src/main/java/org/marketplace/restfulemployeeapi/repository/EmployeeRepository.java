package org.marketplace.restfulemployeeapi.repository;

import org.marketplace.restfulemployeeapi.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    boolean existsByEmail(String email);

    List<Employee> findAllByNameContainingIgnoreCase(String name);

}
