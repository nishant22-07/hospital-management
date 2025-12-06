package com.codingSpring.hospitalManagement.repository;

import com.codingSpring.hospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}