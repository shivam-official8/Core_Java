package com.shivam.collegemanagementjpamapping.repository;

import com.shivam.collegemanagementjpamapping.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
