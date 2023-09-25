package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService implements StudentServiceInter{
    private final Map<Long, Student> students = new HashMap<>();
    private Long lastId = 0L;
    @Override

    public Student createStudent(Student student){
        student.setId(++lastId);
        students.put(lastId,student);
        return student;
    }
    @Override
    public List<Student> getStudentByAge(int age){
        return students.values().stream().filter(it-> it.getAge()==age)
                .collect(Collectors.toList());


    }
    @Override
    public Student findStudent(Long id){
        return students.get(id);
    }
    @Override
    public Student editStudent(Student student){
        if(students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }
    @Override

    public Student deleteStudent(Long id){
        return students.remove(id);

    }


}
