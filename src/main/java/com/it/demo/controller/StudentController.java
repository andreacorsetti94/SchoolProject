package com.it.demo.controller;

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
    public List<Student> getAllStudents(){
        return this.studentService.getAllStudents();
    }

    @GetMapping("/students/{idStudent}")
    public Student getStudentById(@PathVariable Long idStudent){
        return this.studentService.getStudente(idStudent);
    }

    @GetMapping("/students/course/{courseId}")
    public List<Student> studentsByCourse(@PathVariable Long courseId){
        return this.courseService.getStudentsByCourse(courseId);
    }

}
