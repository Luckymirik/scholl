package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;

@Service
public class StudentService implements StudentServiceInter{

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findStudent(Long id){
        return studentRepository.findById(id);
    }
    @Override
    public List<Student> findByAge(int age){
        return studentRepository.getAllByAge(age);
    }
    @Override
    public Student editStudent(Student student){
        return studentRepository.save(student);
    }
    @Override

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);

    }


}
