package ua.artcode.testio.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student extends IdAutoGeneratedEntity {

    @Column(name = "student_name",nullable = false,length = 20, unique = true)
    private String name;

    @Column
    private double rank;

    @Enumerated(EnumType.STRING)
    private StudentType studentType;
    @Temporal(TemporalType.DATE)
    private Date birth;

    @Transient // no mapping
    private String tempAccess;

    public Student() {
    }

    public Student(String name, double rank,
                   StudentType studentType, Date birth, String tempAccess) {
        this.name = name;
        this.rank = rank;
        this.studentType = studentType;
        this.birth = birth;
        this.tempAccess = tempAccess;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getTempAccess() {
        return tempAccess;
    }

    public void setTempAccess(String tempAccess) {
        this.tempAccess = tempAccess;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                ", studentType=" + studentType +
                ", birth=" + birth +
                ", tempAccess='" + tempAccess + '\'' +
                '}';
    }


}
