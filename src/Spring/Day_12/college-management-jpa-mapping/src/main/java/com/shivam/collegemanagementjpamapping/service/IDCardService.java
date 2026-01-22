package com.shivam.collegemanagementjpamapping.service;

import com.shivam.collegemanagementjpamapping.entity.IDCard;
import com.shivam.collegemanagementjpamapping.repository.IDCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDCardService {
    @Autowired
    IDCardRepo idCardRepo;

    public List<IDCard> getAll(){
        return idCardRepo.findAll();
    }
}
