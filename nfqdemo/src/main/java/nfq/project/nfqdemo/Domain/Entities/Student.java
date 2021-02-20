package nfq.project.nfqdemo.Domain.Entities;

public class Student {
    public Student(String name)
    {
        this.name = name;
    }

    private String name;
    private Integer group;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }
}
