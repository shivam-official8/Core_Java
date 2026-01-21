package com.shivam.studentmanagementjpql.service;

import com.shivam.studentmanagementjpql.dto.DivisionCountDTO;
import com.shivam.studentmanagementjpql.model.Student;
import com.shivam.studentmanagementjpql.repository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    public ResponseEntity<String> addStudent(Student student) {
        try{
            repo.save(student);
            return new ResponseEntity<>("Student Added.", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Student Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Student>> getAllStudents() {
        try{
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Student> getStudentById(int id) {
        return new ResponseEntity<>(repo.findById(id).orElse(null), HttpStatus.OK);
    }

    public ResponseEntity<String> editStudent(Student student){
        repo.save(student);
        return new ResponseEntity<>("Student Edited Successfully.", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteStudent(int sId) {
        repo.deleteById(sId);
        return new ResponseEntity<>("Student Deleted.", HttpStatus.OK);
    }


    public ResponseEntity<Student> findStudentByName(String name){
        return new ResponseEntity<>(repo.findStudentByName(name), HttpStatus.OK);
    }

    public ResponseEntity<Student> findStudentByAge(int age){
        return new ResponseEntity<>(repo.findStudentByAge(age), HttpStatus.OK);
    }

    public ResponseEntity<Student> findByRoll(int roll) {
        return new ResponseEntity<>(repo.findStudentByRollNo(roll), HttpStatus.OK);
    }

    public ResponseEntity<Student> findStudentByEmail(String email) {
        return new ResponseEntity<>(repo.findStudentByEmail(email), HttpStatus.OK);
    }

    public ResponseEntity<Student> findStudentByBirthDate(LocalDate date) {
        return new ResponseEntity<>(repo.findStudentByBirthDate(date), HttpStatus.OK);
    }

//    public ResponseEntity<List<Student>> findStudentByAgeBefore(int age) {
//        return new ResponseEntity<>(repo.findStudentByAgeBefore(age), HttpStatus.OK);
//    }
    // pagination
//    public ResponseEntity<Page<Student>> findStudentByAgeBefore(int age) {
//        return new ResponseEntity<>(repo.findStudentByAgeBefore(age, PageRequest.of(0, 1)), HttpStatus.OK);
//    }
    public ResponseEntity<Page<Student>> findStudentByAgeBefore(int age) {
        return new ResponseEntity<>(repo.findStudentByAgeBefore(age, PageRequest.of(1, 1, Sort.by("name"))), HttpStatus.OK);
    }

    public ResponseEntity<List<Student>> findStudentByAgeBetween(int s, int e) {
        return new ResponseEntity<>(repo.findStudentByAgeBetween(s,e), HttpStatus.OK);
    }

    public ResponseEntity<Student> findStudentByNameStartingWith(String prefix) {
        return new ResponseEntity<>(repo.findStudentByNameStartingWith(prefix), HttpStatus.OK);
    }
    public ResponseEntity<List<Student>> findByAgeOrderByRollNo(int age){
        return new ResponseEntity<>(repo.findByAgeOrderByRollNo(age), HttpStatus.OK);
    }
    // JPQL
    public ResponseEntity<List<Student>> ageGTE(int age){
        return new ResponseEntity<>(repo.ageGTE(age), HttpStatus.OK);
    }

    public ResponseEntity<List<Student>> findByBornAfterDate(LocalDate date){
        return new ResponseEntity<>(repo.findByBornAfterDate(date), HttpStatus.OK);
    }

//    public ResponseEntity< List<Object[]>> countEachDivisionStudents(){
//        return new ResponseEntity<>(repo.countEachDivisionStudents(), HttpStatus.OK);
//    }
    public ResponseEntity< List<DivisionCountDTO>> countEachDivisionStudents(){
        return new ResponseEntity<>(repo.countEachDivisionStudents(), HttpStatus.OK);
    }

    public ResponseEntity< List<Object[]>> grpBy(String division){
        return new ResponseEntity<>(repo.grpBy(division), HttpStatus.OK);
    }


    @Transactional
    public int updateNameWithId(String name, int id){
        return repo.updateNameWithId(name, id);
    }


}
