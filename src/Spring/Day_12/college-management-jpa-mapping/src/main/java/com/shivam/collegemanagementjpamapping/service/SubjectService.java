package com.shivam.collegemanagementjpamapping.service;

import com.shivam.collegemanagementjpamapping.dto.StudentSubjectReqDTO;
import com.shivam.collegemanagementjpamapping.entity.Subject;
import com.shivam.collegemanagementjpamapping.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;

    public void addSubject(Subject subject){
        subjectRepo.save(subject);
    }

    public List<Subject> getAllSubjects(){
        return subjectRepo.findAll();
    }


}
