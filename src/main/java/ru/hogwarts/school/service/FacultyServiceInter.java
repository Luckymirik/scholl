package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultyServiceInter {
    Faculty createFaculty(Faculty faculty);

    List<Faculty> getFacultyByColor(String color);

    Optional<Faculty> findFaculty(Long id);

    Faculty editFaculty(Faculty faculty);

    void deleteFaculty(Long id);
}
