package com.example.redisdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.redisdemo.model.CrudModel;
import com.example.redisdemo.repository.CrudRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisStringService {

    @Autowired
    private CrudRepo repo;

    public CrudModel addCustomer(CrudModel customer){

        return repo.save(customer);
    }

    public List<CrudModel> getAllCustomers(){

        List<CrudModel> allCustomer = new ArrayList<>();
        repo.findAll().forEach(allCustomer::add);
        return allCustomer;
    }

    public CrudModel getCustomerById(long id){

        Optional<CrudModel> optionalCustomer
                = repo.findById( id);
        return optionalCustomer.orElse(null);
    }

    public CrudModel updateCustomerById(long id,
                                       CrudModel newCustomer){

        Optional<CrudModel> existingCustomer
                = repo.findById(id);

        if (existingCustomer.isPresent()) {
            CrudModel updatedCustomer
                    = existingCustomer.get();

            updatedCustomer.setName(newCustomer.getName());
            updatedCustomer.setPhone(newCustomer.getPhone());
            updatedCustomer.setEmail(newCustomer.getEmail());

            repo.deleteById(id);
            return repo.save(updatedCustomer);
        }

        return null;
    }

    public void deleteCustomerById(long id){
        repo.deleteById(id);
    }

    public CrudModel saveWithTTL(CrudModel user){
//        user.setTtl(seconds);
       return repo.save(user);

    }
}