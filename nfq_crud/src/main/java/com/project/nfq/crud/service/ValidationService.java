package com.project.nfq.crud.service;

import com.project.nfq.crud.entity.Project;
import com.project.nfq.crud.entity.Student;

import java.util.List;

public class ValidationService {

    public static Boolean isStudentNameValid(String studentName, List<Student> students) {
        students.removeIf(student -> !student.getName().equals(studentName));
        return students.isEmpty();
    }

    public static boolean areGroupsValid(Project project) {

        return true;
    }
}
