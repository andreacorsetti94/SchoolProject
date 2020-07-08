package com.it.demo.controller;

import com.it.demo.dto.StudentDto;
import com.it.demo.service.CourseService;
import com.it.demo.service.StudentService;
import com.it.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/students")
    public List<StudentDto> getAllStudents(){
        List<Student> students = this.studentService.getAllStudents();
        return this.studentService.convertStudentEntityListToDto(students);
    }

    @GetMapping("/students/{idStudent}")
    public StudentDto getStudentById(@PathVariable Long idStudent){
        Student student = this.studentService.getStudente(idStudent);
        return this.studentService.convertStudentEntityToDto(student);
    }

    @GetMapping("/students/course/{courseId}")
    public List<StudentDto> studentsByCourse(@PathVariable Long courseId){
        List<Student> students = this.courseService.getStudentsByCourse(courseId);
        return this.studentService.convertStudentEntityListToDto(students);
    }

}
