package nfq.project.nfqdemo.Domain.Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Project {

    public Project(String projectName, Integer numberOfGroups, Integer studentsPerGroup)
    {
        this.projectName = projectName;
        this.numberOfGroups= numberOfGroups;
        this.studentsPerGroup= studentsPerGroup;
    }
    private Integer _id;
    private String projectName;
    private Integer numberOfGroups;
    private Integer studentsPerGroup;
    private List<Student> students = new ArrayList<Student>();

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent (Student... students)
    {
        this.students.addAll(Arrays.asList(students));
    }

    public Integer get_id() {
        return _id;
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

    public Integer getStudentsPerGroup() {
        return studentsPerGroup;
    }

    public void setNumberOfGroups(Integer numberOfGroups) {
        this.numberOfGroups = numberOfGroups;
    }

    public void setStudentsPerGroup(Integer studentsPerGroup) {
        this.studentsPerGroup = studentsPerGroup;
    }
}
