package com.shivam.studentmanagementjpql.repository;

import com.shivam.studentmanagementjpql.dto.DivisionCountDTO;
import com.shivam.studentmanagementjpql.model.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
//    JPA query methods
    Student findStudentByName(String name);
    Student findStudentByEmail(String email);
    Student findStudentByAge(int age);
    Student findStudentByRollNo(int roll);
    Student findStudentByBirthDate(LocalDate birthDate);
//    age before after and between always returns a list
//    List<Student> findStudentByAgeBefore(int age);
    // pagination
    Page<Student> findStudentByAgeBefore(int age, Pageable pageable);
//    >=s && <=e
    List<Student> findStudentByAgeBetween(int startAge, int endAge);
    Student findStudentByNameStartingWith(String prefix);

    List<Student> findByAgeOrderByRollNo(int age);

//    JPQL Jakarta persistent query language

    @Query("select s from Student s where s.age >= ?1")
    List<Student> ageGTE(@Param("age") int age);

    @Query("select s from Student s where s.birthDate>:birthDate")
    List<Student> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    // here we will have 2d data structure cause we are getting 2 things division and count of them
//    @Query("select s.division, count(s) from Student s group by s.division")
    // using projection (DTO)
    // this will only work with jpql not with native query
    @Query("select new com.shivam.studentmanagementjpql.dto.DivisionCountDTO(s.division, count(s))" +
            " from Student s group by s.division")
    List<DivisionCountDTO> countEachDivisionStudents();

    @Query("select count(s), s.city from Student s where s.division=?1 group by s.city ")
    List<Object[]> grpBy(@Param("division") String division);

    // to use update query we have to use modifying annotation to let db know we are updating so do transaction
    // management according to that
    @Modifying
    @Query("UPDATE Student p SET p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") int id);

    // Native query
    @Query(value = "select * from student", nativeQuery = true)
    List<Student> getAllStudent();

}
