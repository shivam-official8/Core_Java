package com.shivam.collegemanagementjpamapping.controller;

import com.shivam.collegemanagementjpamapping.dto.StudentReqDTO;
import com.shivam.collegemanagementjpamapping.dto.StudentSubjectReqDTO;
import com.shivam.collegemanagementjpamapping.entity.Student;
import com.shivam.collegemanagementjpamapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentservice;

    @PostMapping("/addstudent")
    public void addStudent(@RequestBody StudentReqDTO student){
        studentservice.addStudent(student);
    }

    @GetMapping("/allstudent")
    public List<Student> getAllStudents(){
       return studentservice.getStudents();
    }

    @PostMapping("/addstudentsubjects/{studentId}")
    public void addSubjectsToStudent(@PathVariable Long studentId, @RequestBody StudentSubjectReqDTO studentSubjectReqDTO){
        studentservice.addSubjectsToStudent(studentId, studentSubjectReqDTO);
    }

}
