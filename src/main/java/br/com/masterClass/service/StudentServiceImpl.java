package br.com.masterClass.service;

import br.com.masterClass.entity.Student;
import br.com.masterClass.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> listarPorNome(String firstName) {
        List<Student> students = studentRepository.findByFirstName(firstName);
        if(students.isEmpty()){
            throw new RuntimeException("Nao encontrado");
        }

        return students;
    }

    @Override
    public List<Student> containingNome(String nome) {
        List<Student> students = studentRepository.findByFirstNameContaining(nome);
        if(students.isEmpty()){
            throw new RuntimeException("Não encontrado");
        }
        return students;
    }

    @Override
    public List<Student> guardianName(String nome) {
        List<Student> students = studentRepository.findByGuardianName(nome);
        if (students.isEmpty()){
            throw new RuntimeException("Não encontrado");
        }
        return students;
    }

    @Override
    public Student FirstNameAndLastName(String firstName, String lastName) {
        Student student = studentRepository.findByFirstNameAndLastName(firstName,lastName);
        if(student == null){
            throw new RuntimeException("Não encontrado...");
        }
        return student;
    }


}
