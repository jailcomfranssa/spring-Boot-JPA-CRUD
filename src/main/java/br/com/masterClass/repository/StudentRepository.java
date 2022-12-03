package br.com.masterClass.repository;

import br.com.masterClass.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long>{

    public List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    //List<Student> findByLastNameNot();
    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select s from  Student s where s.emailId = ?1")
    Student getStudentsByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);


}
