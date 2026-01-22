package com.shivam.collegemanagementjpamapping.repository;

import com.shivam.collegemanagementjpamapping.entity.IDCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDCardRepo extends JpaRepository<IDCard, Long> {
}
