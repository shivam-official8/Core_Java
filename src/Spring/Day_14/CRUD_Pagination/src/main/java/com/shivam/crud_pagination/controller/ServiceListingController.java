package com.shivam.crud_pagination.controller;

import com.shivam.crud_pagination.entity.ServiceListing;
import com.shivam.crud_pagination.service.ServiceListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceListingController {

    @Autowired
    ServiceListingService service;

    @PostMapping("/addservice")
    public void addService(@RequestBody ServiceListing serviceListing){
        service.addService(serviceListing);
    }

    @GetMapping("/allservice")
    public List<ServiceListing> allService(){
        return service.allService();
    }

    @GetMapping("/pagination")
    public Page<ServiceListing> getAllPage(@RequestParam int page, @RequestParam int size){
        return service.getAllPage(page, size);
    }

    @GetMapping("/sortcat")
    public Page<ServiceListing> sortCat(@RequestParam int page, @RequestParam int size){
        return service.sortCategories(page, size);
    }
}
