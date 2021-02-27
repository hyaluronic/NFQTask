package nfq.project.nfqdemo.Controllers;

import nfq.project.nfqdemo.Domain.Entities.Project;
import nfq.project.nfqdemo.Domain.Entities.Student;
import nfq.project.nfqdemo.Domain.Entities.Teacher;
import nfq.project.nfqdemo.Repository.ProjectRepository;
import nfq.project.nfqdemo.Repository.StudentRepository;
import nfq.project.nfqdemo.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ProjectRepository projectRepository;


    @PostMapping(path="/addStudent") // Map ONLY POST Requests
    public @ResponseBody String addNewStudent (@RequestParam String name
            , @RequestParam Integer group){

        Student n = new Student();
        n.setName(name);
        n.setGroup(group);
        studentRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/allStudents")
    public @ResponseBody Iterable<Student> getAllStudents() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }

    @PostMapping(path="/addTeacher")
    public @ResponseBody String addNewTeacher (@RequestParam String name
            , @RequestParam List<Project> projects){

        Teacher n = new Teacher();
        n.setName(name);
        n.setProjects(projects);
        teacherRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/allTeachers")
    public @ResponseBody Iterable<Teacher> getAllTeachers() {
        // This returns a JSON or XML with the users
        return teacherRepository.findAll();
    }

    @PostMapping(path="/addProject")
    public @ResponseBody String addNewProject (@RequestParam String name
            , @RequestParam Integer numberOfGroups, @RequestParam Integer studentsPerGroup, @RequestParam List<Student> students){

        Project n = new Project();
        n.setProjectName(name);
        n.setStudents(students);
        n.setNumberOfGroups(numberOfGroups);
        n.setStudentsPerGroup(studentsPerGroup);
        projectRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/allProjects")
    public @ResponseBody Iterable<Project> getAllProjects() {
        // This returns a JSON or XML with the users
        return projectRepository.findAll();
    }
}