package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacultyService implements FacultyServiceInter{
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private Long lastId = 0L;
    @Override

    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++lastId);
        faculties.put(lastId,faculty);
        return faculty;
    }
    @Override
    public List<Faculty>getFacultyByColor(String color){
        return faculties.values().stream().filter(it->it.getColor().equals(color))
                .collect(Collectors.toList());

    }
    @Override
    public Faculty findFaculty(Long id){
        return faculties.get(id);
    }
    @Override
    public Faculty editFaculty(Faculty faculty){
        if (faculties.containsKey(faculty.getId())) {
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }
    @Override
    public Faculty deleteFaculty(Long id){
        return faculties.remove(id);
    }


}
