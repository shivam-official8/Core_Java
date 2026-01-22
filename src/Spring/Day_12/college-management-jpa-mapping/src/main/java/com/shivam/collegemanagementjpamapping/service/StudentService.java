package com.shivam.collegemanagementjpamapping.service;

import com.shivam.collegemanagementjpamapping.dto.StudentReqDTO;
import com.shivam.collegemanagementjpamapping.dto.StudentSubjectReqDTO;
import com.shivam.collegemanagementjpamapping.entity.IDCard;
import com.shivam.collegemanagementjpamapping.entity.Student;
import com.shivam.collegemanagementjpamapping.entity.Subject;
import com.shivam.collegemanagementjpamapping.repository.StudentRepo;
import com.shivam.collegemanagementjpamapping.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    SubjectRepo subjectRepo;
    public void addStudent(StudentReqDTO req){
        IDCard idCard = new IDCard();
        idCard.setCardNumber(req.cardNumber);

        Student student = new Student();
        student.setName(req.name);

        student.setIdCard(idCard);
        idCard.setStudent(student);
        studentRepo.save(student);
    }

    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    public ResponseEntity<String> addSubjectsToStudent(Long studentId, StudentSubjectReqDTO studentSubjectReqDTO){
        Student student = studentRepo.findById(studentId).orElse(null);
        for(Long subId: studentSubjectReqDTO.subjectIDs){
            Subject subject = subjectRepo.findById(subId).orElse(null);
            student.getSubjects().add(subject);
            subject.getStudents().add(student);
        }
        studentRepo.save(student);
        return  ResponseEntity.ok("OK");
    }
}
