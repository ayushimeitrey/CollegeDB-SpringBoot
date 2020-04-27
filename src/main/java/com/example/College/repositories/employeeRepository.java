package com.example.College.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.College.model.Department;
import com.example.College.model.Employee;

@Repository
public interface employeeRepository extends JpaRepository<Employee,Long>{

	public List<Employee> findByDep(Department dep);

}