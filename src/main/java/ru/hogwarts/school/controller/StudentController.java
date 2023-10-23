package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id){
        Student student= studentService.findStudent(id);

        return ResponseEntity.ok(student);
    }
    @GetMapping
    public ResponseEntity <List<Student>> getStudentByAgeInfo(@RequestParam("age") int age){
        return ResponseEntity.ok(studentService.findByAge(age));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity <List<Student>> getStudentsByName(@PathVariable("name") String name){
        List<Student> students = studentService.getStudentsByName(name);
        return ResponseEntity.ok(students);
    }
    @GetMapping("/age-between")
    public ResponseEntity<List<Student>> getStudentByAgeBetween(@RequestParam("min") int min,
                                                                @RequestParam("max") int max){
        return ResponseEntity.ok(studentService.findByAgeBetween(min,max));
    }
    @GetMapping("/faculty-by-student-id")
    public ResponseEntity<Faculty> getFacultyByStudentId(@RequestParam("id")Long id){
        return ResponseEntity.ok(studentService.getFacultyByStudentId(id));
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student){
        Student foundStudent = studentService.editStudent(student);
        if(foundStudent == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudent);
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent (@PathVariable Long id){
         studentService.deleteStudent(id);
         return ResponseEntity.ok().build();
    }
    @GetMapping("/amount")
    public  int getAmountStudent(){
        return studentService.getAmountStudents();
    }
    @GetMapping("/average-age")
    public  int getAverageAge(){
        return studentService.getAverageAge();
    }
    @GetMapping("/last-five")
    public ResponseEntity <List<Student>> getLastFiveStudents(){
        return ResponseEntity.ok(studentService.getLastFiveStudents());
    }
}
