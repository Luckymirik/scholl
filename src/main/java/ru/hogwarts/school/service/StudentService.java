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
    private Object lock = new Object();



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
    public void namesUsingMultithreading(){
        List <Student> students = studentRepository.findAll();
        printStudent(students.get(0));
        printStudent(students.get(1));
        Thread thread1 = new Thread(()->{
            printStudent(students.get(2));
            printStudent(students.get(3));
        });
        thread1.start();
        Thread thread2 = new Thread(()->{
            printStudent(students.get(4));
            printStudent(students.get(5));
        });
        thread2.start();
        System.out.println();

    }
    @Override
    public void printStudentSync(){
        List<Student> students = studentRepository.findAll();
        printStudentSync(students.get(0));
        printStudentSync(students.get(1));
        Thread thread1 = new Thread(()->{
            printStudentSync(students.get(2));
            printStudentSync(students.get(3));
        });
        thread1.start();

        Thread thread2 = new Thread(()->{
            printStudentSync(students.get(4));
            printStudentSync(students.get(5));
        });
        thread2.start();

        System.out.println();
    }
    @Override
    public void printStudent(Student student){
        System.out.println(Thread.currentThread().getName() + " " + student.getName());
    }
    @Override
    public synchronized void printStudentSync(Student student){
        printStudent(student);
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
