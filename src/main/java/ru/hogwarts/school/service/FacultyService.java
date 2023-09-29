package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacultyService implements FacultyServiceInter{

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override

    public Faculty createFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }
    @Override
    public List<Faculty>getFacultyByColor(String color){
        return facultyRepository.getAllByColor(color);

    }
    @Override
    public Optional<Faculty> findFaculty(Long id){
        return facultyRepository.findById(id);
    }
    @Override
    public Faculty editFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }
    @Override
    public void deleteFaculty(Long id){
         facultyRepository.deleteById(id);
    }


}
