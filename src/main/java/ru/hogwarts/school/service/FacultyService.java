package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.*;

@Service
public class FacultyService implements FacultyServiceInter{

    private final FacultyRepository facultyRepository;
    private final StudentService studentService;
    private final Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public FacultyService(FacultyRepository facultyRepository, StudentService studentService) {
        this.facultyRepository = facultyRepository;
        this.studentService = studentService;
    }

    @Override

    public Faculty createFaculty(Faculty faculty){
        logger.debug("Faculty created");
        return facultyRepository.save(faculty);
    }
    @Override
    public List<Faculty>getFacultyByColor(String color){
        logger.debug("Faculty found by color");

        return facultyRepository.getAllByColor(color);

    }
    @Override
    public Set<Faculty>getFacultyByColorOrByName(String param){
        logger.debug("Found faculty by color or name");
        Set<Faculty> result = new HashSet<>();
        result.addAll(facultyRepository.getAllByColorIgnoreCase(param));
        result.addAll(facultyRepository.getAllByNameIgnoreCase(param));
        return result;


    }
    @Override
    public List<Student> getStudentByFacultyId(Long id){
        return studentService.getByFacultyId(id);

    }
    @Override
    public String getLongestFacultyName(){
        return facultyRepository.findAll()
                .stream().map(Faculty::getName)
                .max(Comparator.comparing(String::length))
                .get();
    }
    @Override
    public Optional<Faculty> findFaculty(Long id){
        logger.debug("Found faculty by id");

        return facultyRepository.findById(id);
    }
    @Override
    public Faculty editFaculty(Faculty faculty){
        logger.debug("Change faculty");
        return facultyRepository.save(faculty);
    }
    @Override
    public void deleteFaculty(Long id){
        logger.debug("Removed faculty");
         facultyRepository.deleteById(id);
    }


}
