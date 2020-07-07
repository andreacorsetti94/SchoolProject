package com.it.demo.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long course_id;

    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "Course_Student",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") })
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name="professor_id", nullable=false)
    private Professor professor;

    public Course(Long course_id, String name, List<Student> students) {
        this.course_id = course_id;
        this.name = name;
        this.students = students;
    }

    public Course(String name, List<Student> students){
        this.name = name;
        this.students = students;
    }

    public Course() {
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addStudent(Student student){
        this.getStudents().add(student);
    }

    public void removeStudent(Student student){
        this.getStudents().remove(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", name='" + name + '\'' +
                ", students=" + students +
                ", professor=" + professor.getId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(course_id, course.course_id) &&
                Objects.equals(name, course.name) &&
                Objects.equals(students, course.students) &&
                Objects.equals(professor, course.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course_id, name, students, professor);
    }
}
