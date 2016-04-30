package ua.artcode.testio.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends IdAutoGeneratedEntity {


    @OneToMany(mappedBy = "owner",cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();

    private String name;
    private int level;

    public Teacher() {
    }

    public Teacher(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}