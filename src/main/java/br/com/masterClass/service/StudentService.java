package br.com.masterClass.service;

import br.com.masterClass.entity.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> listAll();
}
