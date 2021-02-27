package nfq.project.nfqdemo.Domain.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Entity
@Table(name="Project")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String projectName;
    private Integer numberOfGroups;
    private Integer studentsPerGroup;
    private List<Student> students = Collections.emptyList();

    public Project() {

    }

    public Project(String projectName, Integer numberOfGroups, Integer studentsPerGroup) {
        this.projectName = projectName;
        this.numberOfGroups = numberOfGroups;
        this.studentsPerGroup = studentsPerGroup;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student... students) {
        this.students.addAll(Arrays.asList(students));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getNumberOfGroups() {
        return numberOfGroups;
    }

    public void setNumberOfGroups(Integer numberOfGroups) {
        this.numberOfGroups = numberOfGroups;
    }

    public Integer getStudentsPerGroup() {
        return studentsPerGroup;
    }

    public void setStudentsPerGroup(Integer studentsPerGroup) {
        this.studentsPerGroup = studentsPerGroup;
    }
}
