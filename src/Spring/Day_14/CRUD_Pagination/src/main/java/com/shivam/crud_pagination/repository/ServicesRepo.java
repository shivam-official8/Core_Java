package com.shivam.crud_pagination.repository;

import com.shivam.crud_pagination.entity.ServiceListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepo extends JpaRepository<ServiceListing, Long> {
}
