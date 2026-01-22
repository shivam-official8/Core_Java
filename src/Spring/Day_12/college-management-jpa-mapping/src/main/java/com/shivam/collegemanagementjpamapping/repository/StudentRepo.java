package com.shivam.collegemanagementjpamapping.repository;

import com.shivam.collegemanagementjpamapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
}
