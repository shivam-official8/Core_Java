package com.shivam.collegemanagementjpamapping.controller;

import com.shivam.collegemanagementjpamapping.dto.StudentSubjectReqDTO;
import com.shivam.collegemanagementjpamapping.entity.Subject;
import com.shivam.collegemanagementjpamapping.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/addsubject")
    public void addSubject(@RequestBody Subject subject) {
        subjectService.addSubject(subject);
    }

    @GetMapping("/allsubject")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }


}