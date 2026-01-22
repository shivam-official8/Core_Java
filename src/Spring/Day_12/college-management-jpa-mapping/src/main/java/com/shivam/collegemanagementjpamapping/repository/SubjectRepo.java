package com.shivam.collegemanagementjpamapping.repository;

import com.shivam.collegemanagementjpamapping.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {
}
