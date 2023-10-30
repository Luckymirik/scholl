package ru.hogwarts.school.service;


import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class StudentService implements StudentServiceInter{



    private final StudentRepository studentRepository;

    private final Logger logger = LoggerFactory.getLogger(StudentService.class);



    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override


    public Student createStudent(Student student){
        logger.debug("Student created = {}",student);
        return studentRepository.save(student);
    }

    @Override
    public Student findStudent(Long id){
        logger.debug("Found student by id");
        return studentRepository.findById(id).get();
    }
    @Override
    public List<Student> findByAge(int age){
        logger.debug("Found students by age");
        return studentRepository.getAllByAge(age);
    }
    @Override
    public List<Student> findByAgeBetween(int min,int max){
        logger.debug("Found students by age between");
        return  studentRepository.findAllByAgeBetween(min,max);
    }
    @Override
    public Faculty getFacultyByStudentId(Long id) {
        logger.debug("Faculty found by student id");
        return studentRepository.findById(id).get().getFaculty();
    }
    @Override
    public List<Student> getStudentsByName(String name){
        logger.debug("Found students by name");
        return studentRepository.getStudentsByName(name);
    }
    @Override
    public Collection<String> getStudentsNames(){
        return studentRepository.findAll().stream()
                .map(e->e.getName().toUpperCase())
                .filter(name->name.startsWith("А"))
                .sorted()
                .collect(Collectors.toList());

    }
    @Override
    public double getStudentsAverageAge(){
        return studentRepository.findAll().stream()
                .mapToDouble(Student::getAge)
                .average().orElse(0);

    }

    @Override
    public List<Student> getByFacultyId(Long facultyId) {
        logger.debug("Found students by faculty id");
        return studentRepository.findByFacultyId(facultyId);
    }
    @Override
    public Student editStudent(Student student){
        logger.debug("Changed student");
        return studentRepository.save(student);

    }
    @Override

    public void deleteStudent(Long id){
        logger.debug("Removed student");
        studentRepository.deleteById(id);

    }


    public int getAmountStudents() {
        logger.debug("Get number of all students");
        return studentRepository.amountStudents();
    }
    public int getAverageAge() {
        logger.debug("Get average age of all students");
        return studentRepository.averageAge();
    }

    public List<Student> getLastFiveStudents() {
        logger.debug("Get last five students");
        return studentRepository.lastFive();
    }

}
