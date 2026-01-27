package com.shivam.crud_pagination.service;

import com.shivam.crud_pagination.entity.ServiceListing;
import com.shivam.crud_pagination.repository.ServicesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceListingService {

    @Autowired
    ServicesRepo servicesRepo;

    public void addService(ServiceListing listing){
        servicesRepo.save(listing);
    }

    public List<ServiceListing> allService(){
        return servicesRepo.findAll();
    }

    public Page<ServiceListing> getAllPage(int page, int size){
        Pageable pageable =PageRequest.of(page, size);
        return servicesRepo.findAll(pageable);

    }

    public Page<ServiceListing> sortCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("category").ascending());
        return servicesRepo.findAll(pageable);
    }
}
