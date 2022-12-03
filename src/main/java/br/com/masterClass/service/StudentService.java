package br.com.masterClass.service;

import br.com.masterClass.entity.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> listAll();

    public List<Student> listarPorNome(String firstName);

    public  List<Student> containingNome(String nome);

    public List<Student> guardianName(String nome);

    public Student FirstNameAndLastName(String firstName, String lastName);
}
