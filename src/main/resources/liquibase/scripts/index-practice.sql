-- liquibase formatted sql

--changeset mtsadkin:1
CREATE INDEX student_name_index ON student(name);

--changeset mtsadkin:2
CREATE INDEX faculty_name_or_color ON faculty(name,color);