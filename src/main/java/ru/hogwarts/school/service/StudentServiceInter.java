package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentServiceInter {
    Student createStudent(Student student);

    List<Student> getStudentByAge(int age);

    Student findStudent(Long id);

    Student editStudent(Student student);

    Student deleteStudent(Long id);
}
