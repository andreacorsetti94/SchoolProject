package com.it.demo.dto;

import java.util.List;

public class CourseDto {

    private Long courseId;
    private String courseName;
    private List<PersonDto> studentDtos;
    private PersonDto professorDto;

    public CourseDto() {
    }

    public CourseDto(Long courseId, String courseName, List<PersonDto> studentDtos, PersonDto professorDto) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.studentDtos = studentDtos;
        this.professorDto = professorDto;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<PersonDto> getStudentDtos() {
        return studentDtos;
    }

    public void setStudentDtos(List<PersonDto> studentDtos) {
        this.studentDtos = studentDtos;
    }

    public PersonDto getProfessorDto() {
        return professorDto;
    }

    public void setProfessorDto(PersonDto professorDto) {
        this.professorDto = professorDto;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", studentDtos=" + studentDtos +
                ", professorDto=" + professorDto +
                '}';
    }
}
