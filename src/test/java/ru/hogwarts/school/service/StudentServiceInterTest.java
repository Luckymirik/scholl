package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceInterTest {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService ;
    @Test
    void createStudent() {
        var expected =new Student(1L,"Гарри",15) ;
        var testStudent = new Student(1L,"Гарри",15) ;
        when(studentRepository.save(testStudent))
                .thenReturn(new Student(1L,"Гарри",15));
        var actual =studentService.createStudent(new Student(1L,"Гарри",15));
        Assertions.assertEquals(expected,actual);

    }

    @Test
    void getStudentByAge() {
        List<Student> expected = new ArrayList<>(List.of((new Student(2L,"Гермиона",15))));
        when(studentRepository.getAllByAge(15))
                .thenReturn(new ArrayList<>(List.of((new Student(2L,"Гермиона",15)))));
        studentService.createStudent(new Student(1L,"Гарри",14));
        studentService.createStudent(new Student(2L,"Гермиона",15));
        var actual = studentService.findByAge(15);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void findStudent() {
        var expected = Optional.of(new Student(2L,"Рон",15));
        var studentTest2 = new Student(2L,"Рон",15);
        when(studentRepository.findById(2L))
                .thenReturn(Optional.of(studentTest2));
        studentService.createStudent(new Student(2L,"Рон",15));
        var actual = studentService.findStudent(2L);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void editStudent() {
        var expected = new Student(1L,"Малфой",15);
        var studentTest = new Student(1L,"Малфой",15);
        when(studentRepository.save(studentTest))
                .thenReturn(studentTest);
        var actual = studentService.editStudent(new Student(1L,"Малфой",15));
        Assertions.assertEquals(expected,actual);
    }




    }
