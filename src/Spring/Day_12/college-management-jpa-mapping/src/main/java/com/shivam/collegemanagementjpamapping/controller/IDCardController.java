package com.shivam.collegemanagementjpamapping.controller;

import com.shivam.collegemanagementjpamapping.entity.IDCard;
import com.shivam.collegemanagementjpamapping.repository.IDCardRepo;
import com.shivam.collegemanagementjpamapping.service.IDCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IDCardController {
    @Autowired
    IDCardService idCardService;

    @GetMapping("/allidcard")
    public List<IDCard> getAllIdCards(){
        return idCardService.getAll();
    }
}
