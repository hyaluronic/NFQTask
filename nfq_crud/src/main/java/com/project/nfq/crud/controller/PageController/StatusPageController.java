package com.project.nfq.crud.controller.PageController;

import com.project.nfq.crud.entity.Project;
import com.project.nfq.crud.entity.Student;
import com.project.nfq.crud.service.ProjectService;
import com.project.nfq.crud.service.StudentService;
import com.project.nfq.crud.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StatusPageController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private StudentService studentService;


    @GetMapping("/statusPage/{id}")
    public String statusPage(@PathVariable("id") int id, Model model) {
        Project project = projectService.getProjectById(id);
/*        students = studentService.getStudentsByProject(project.getId());
        project.setStudents(students);*/
        List<Student> studentsWithoutGroup = studentService.getStudentsByProjectId(id);
        studentsWithoutGroup.removeIf(student -> student.getGroup() != null);
        model.addAttribute("project", project);
        model.addAttribute("studentsWithoutGroup", studentsWithoutGroup);
        return "statusPage";
    }

    @PostMapping("/addStudent")
    public String addStudent(String studentName, Integer projectId) {
        List<Student> students = studentService.getStudentsByProjectId(projectId);
        if (!studentName.isBlank() && ValidationService.isStudentNameValid(studentName, students)){
            Project project = projectService.getProjectById(projectId);
            Student student = new Student();
            student.setName(studentName);
            student.setProject(project);
            studentService.saveStudent(student);
        }
        return "redirect:/statusPage/" + projectId;
    }

    @PostMapping("/deleteStudent")
    public String deleteStudent(Integer studentId, Integer projectId) {
        studentService.deleteStudent(studentId);
        return "redirect:/statusPage/" + projectId;
    }

    @PostMapping("/deleteFromGroup")
    public String deleteStudentFromGroup(Integer studentId, Integer projectId) {
        Student student = studentService.getStudentById(studentId);
        student.setGroup(null);
        studentService.updateStudent(student);
        return "redirect:/statusPage/" + projectId;
    }
}

