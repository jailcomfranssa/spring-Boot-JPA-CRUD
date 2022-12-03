package br.com.masterClass.repository;

import br.com.masterClass.entity.Guardian;
import br.com.masterClass.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("ja@ja.com")
                .firstName("jailson")
                .lastName("Franca")
//                .guardianEmail("jj@.com")
//                .guardianName("jj")
//                .guardianMobile("1234-4569")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("jj@.com")
                .name("jj")
                .mobile("1234-4569")
                .build();

        Student student = Student.builder()
                .emailId("ja@ja.com")
                .firstName("jailson")
                .lastName("Franca")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("students: "+ studentList);

    }
    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("jailson");
        System.out.println("Student: " + students);
    }
    @Test
    public void printStudentFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("jai");
        System.out.println("Student: " + students);
    }

    @Test
    public void printStudentGuardianNome(){
        List<Student> students = studentRepository.findByGuardianName("jj");
        System.out.println("Guardian: " + students);
    }

    @Test
    public void getStudentsByEmailAddress(){
        Student student = studentRepository.getStudentsByEmailAddress("ja@j.com.br");
        System.out.println("Student = " + student);
    }

    public void printGetStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("ja@j.com.br");
    }

}