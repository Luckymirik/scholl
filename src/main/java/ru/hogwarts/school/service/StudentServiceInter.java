package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServiceInter {
    Student createStudent(Student student);



    Optional<Student> findStudent(Long id);

    List<Student> findByAge(int age);

    Student editStudent(Student student);

    void deleteStudent(Long id);
}
