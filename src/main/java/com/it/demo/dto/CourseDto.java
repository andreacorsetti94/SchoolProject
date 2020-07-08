package com.it.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CourseDto {

    private Long courseId;
    private String courseName;
    private List<StudentDto> studentDtos;
    private ProfessorDto professorDto;

    public CourseDto() {
    }

    public CourseDto(Long courseId, String courseName, List<StudentDto> studentDtos, ProfessorDto professorDto) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.studentDtos = studentDtos;
        this.professorDto = professorDto;
    }

    @JsonProperty("id-corso")
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @JsonProperty("nomeCorso")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @JsonProperty("studenti")
    public List<StudentDto> getStudentDtos() {
        return studentDtos;
    }

    public void setStudentDtos(List<StudentDto> studentDtos) {
        this.studentDtos = studentDtos;
    }

    @JsonProperty("professore")
    public ProfessorDto getProfessorDto() {
        return professorDto;
    }

    public void setProfessorDto(ProfessorDto professorDto) {
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
