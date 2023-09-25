package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;

import java.util.List;

public interface FacultyServiceInter {
    Faculty createFaculty(Faculty faculty);

    List<Faculty> getFacultyByColor(String color);

    Faculty findFaculty(Long id);

    Faculty editFaculty(Faculty faculty);

    Faculty deleteFaculty(Long id);
}
