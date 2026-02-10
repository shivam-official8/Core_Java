package com.example.redisdemo.controller;


import java.util.ArrayList;
import java.util.List;

import com.example.redisdemo.model.CrudModel;
import com.example.redisdemo.service.RedisStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class RedisStringController {

    @Autowired
    private RedisStringService service;

    @PostMapping
    public CrudModel addCustomer(@RequestBody CrudModel customer){

        return service.addCustomer(customer);
    }

//    @PostMapping("/ttl")
//    public CrudModel addwithttl(@RequestBody CrudModel customer){
//
//        return service.saveWithTTL(customer);
//    }

    @GetMapping
    public List<CrudModel> getListOfCustomers(){

        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CrudModel getCustomer(@PathVariable long id){

        return service.getCustomerById(id);
    }

    @PutMapping("/{id}")
    public CrudModel
    updateCustomer(@PathVariable long id,
                   @RequestBody CrudModel newCustomer){

        return service.updateCustomerById(id, newCustomer);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable long id){

        service.deleteCustomerById(id);
        return "Customer Deleted Successfully";
    }
}