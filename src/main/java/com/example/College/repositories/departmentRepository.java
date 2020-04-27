package com.example.College.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.College.model.Department;

@Repository
public interface departmentRepository extends JpaRepository<Department, Long>{

}
