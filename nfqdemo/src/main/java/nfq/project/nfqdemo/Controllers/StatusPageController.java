package nfq.project.nfqdemo.Controllers;

import nfq.project.nfqdemo.Domain.Entities.Project;
import nfq.project.nfqdemo.Domain.Entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class StatusPageController {

    public Project project;

    @GetMapping("/statusPage")
    public String statusPage(@RequestParam(name = "projectId", required = false) Integer projectId, Model model) {

        project = getProject(projectId);

        Student student1 = new Student("Andrius");
        student1.setGroup(2);
        project.addStudent(student1);
        Student student2 = new Student("Lukas");
        project.addStudent(student2);
        model.addAttribute("project", project);
        return "statusPage";
    }

    private Project getProject(Integer id) {
        //get project from db by id
        return new Project("Pirmas", 5, 2);
    }


}
