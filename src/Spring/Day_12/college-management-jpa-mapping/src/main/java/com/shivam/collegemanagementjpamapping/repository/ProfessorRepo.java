package com.shivam.collegemanagementjpamapping.repository;

import com.shivam.collegemanagementjpamapping.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor, Long> {
}
