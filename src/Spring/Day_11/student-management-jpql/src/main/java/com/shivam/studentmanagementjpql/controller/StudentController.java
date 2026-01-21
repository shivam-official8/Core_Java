package com.shivam.studentmanagementjpql.controller;

import com.shivam.studentmanagementjpql.dto.DivisionCountDTO;
import com.shivam.studentmanagementjpql.model.Student;
import com.shivam.studentmanagementjpql.repository.StudentRepo;
import com.shivam.studentmanagementjpql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/student/{sId}")
    public ResponseEntity<Student> getStudentById(@PathVariable int sId){
        return service.getStudentById(sId);
    }

    @PutMapping("/student")
    public ResponseEntity<String> editStudent(@RequestBody Student student){
        return service.editStudent(student);
    }

    @DeleteMapping("/student/{sId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int sId){
        return service.deleteStudent(sId);
    }

    @GetMapping("/studentByName")
    public ResponseEntity<Student> findStudentByName(@RequestParam String name){
        return service.findStudentByName(name);
    }

    @GetMapping("/studentByAge/{age}")
    public ResponseEntity<Student> findStudentByAge(@PathVariable int age){
        return service.findStudentByAge(age);
    }

    @GetMapping("/studentByRoll/{roll}")
    public ResponseEntity<Student> findStudentByRoll(@PathVariable int roll){
        return service.findByRoll(roll);
    }

    @GetMapping("/studentByEmail")
    public ResponseEntity<Student> findStudentByEmail(@RequestParam String email) {
        return service.findStudentByEmail(email);
    }

    @GetMapping("/studentByBirthDate")
    public ResponseEntity<Student> findStudentByBirthDate(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return service.findStudentByBirthDate(date);
    }

//    @GetMapping("/studentAgeBefore/{age}")
//    public ResponseEntity<List<Student>> findStudentByAgeBefore(@PathVariable int age) {
//        return service.findStudentByAgeBefore(age);
//    }
@GetMapping("/studentAgeBefore/{age}")
    public ResponseEntity<Page<Student>> findStudentByAgeBefore(@PathVariable int age) {
        return service.findStudentByAgeBefore(age);
    }

    @GetMapping("/studentAgeBetween")
    public ResponseEntity<List<Student>> findStudentByAgeBetween(@RequestParam int s, int e) {
        return service.findStudentByAgeBetween(s,e);
    }

    @GetMapping("/studentNameStartWith")
    public ResponseEntity<Student> findStudentByNameStartingWith(@RequestParam String prefix) {
        return service.findStudentByNameStartingWith(prefix);
    }

    @GetMapping("/findByAgeOrderByRollNo")
    public ResponseEntity<List<Student>> findByAgeOrderByRollNo(@RequestParam int age) {
        return service.findByAgeOrderByRollNo(age);
    }

    // jpql
    @GetMapping("/ageGTE/{age}")
    public ResponseEntity<List<Student>> ageGTE(@PathVariable int age) {
        return service.ageGTE(age);
    }

    @GetMapping("/findByBornAfterDate")
    public ResponseEntity<List<Student>> findByBornAfterDate(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return service.findByBornAfterDate(date);
    }
//    @GetMapping("/countEachDivisionStudents")
//    public ResponseEntity< List<Object[]>> countEachDivisionStudents(){
//        return service.countEachDivisionStudents();
//    }
    @GetMapping("/countEachDivisionStudents")
    public ResponseEntity< List<DivisionCountDTO>> countEachDivisionStudents(){
        return service.countEachDivisionStudents();
    }

    @GetMapping("/grpBy")
    public ResponseEntity< List<Object[]>> grpBy(@RequestParam String division){
        return service.grpBy(division);
    }

    @PostMapping("/update")
    public int updateNameWithId(@RequestBody String name, @RequestParam int id){
//        System.out.println(name);
        return service.updateNameWithId(name.trim(), id);
    }



}
