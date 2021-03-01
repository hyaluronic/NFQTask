package com.project.nfq.crud.service;

import com.project.nfq.crud.entity.Student;

import java.util.List;

public class ValidationService {

    public static boolean isStudentNameValid(String studentName, List<Student> students) {
        students.removeIf(student -> !student.getName().equals(studentName));
        return students.isEmpty();
    }

    public static boolean isProjectInputValid(String projectName, Integer numberOfGroups, Integer studentsPerGroup) {
        return projectName != null && numberOfGroups != null && studentsPerGroup != null && numberOfGroups > 0 && studentsPerGroup > 0;
    }
}
