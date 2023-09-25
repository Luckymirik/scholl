package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceInterTest {
    private final StudentService studentService = new StudentService();
    @Test
    void createStudent() {


        var expected =new Student(1L,"Гарри",15) ;
        var actual = studentService.createStudent(new Student(1L,"Гарри",15));
        Assertions.assertEquals(expected,actual);

    }

    @Test
    void getStudentByAge() {
        List<Student> expected = new ArrayList<>(List.of((new Student(2L,"Гермиона",15))));
        studentService.createStudent(new Student(1L,"Гарри",14));
        studentService.createStudent(new Student(2L,"Гермиона",15));
        var actual = studentService.getStudentByAge(15);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void findStudent() {
        var expected = new Student(2L,"Рон",15);
        studentService.createStudent(new Student(1L,"Гарри",14));
        studentService.createStudent(new Student(2L,"Рон",15));
        var actual = studentService.findStudent(2L);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void editStudent() {
        var expected = new Student(1L,"Малфой",15);
        studentService.createStudent(new Student(1L,"Малфи",14));
        var actual = studentService.editStudent(new Student(1L,"Малфой",15));
        Assertions.assertEquals(expected,actual);
    }


//    @Test
//    void deleteStudent() {
//        List<Student> expected = new ArrayList<>(List.of((new Student(1L,"Гермиона",15))));
//        studentService.createStudent(new Student(1L,"Гермиона",15));
//        studentService.createStudent(new Student(2L,"Невилл",14));
//        var actual = studentService.deleteStudent(2L);
//        Assertions.assertEquals(expected,actual);
//
//    }
}