package com.it.demo.controller;

import com.it.demo.entity.Course;
import com.it.demo.service.CourseService;
import com.it.demo.service.ProfessorService;
import com.it.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return this.courseService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable Long courseId){
        return this.courseService.getCourseById(courseId);
    }

    @PostMapping("/courses/{courseId}/{studentId}")
    public Course assignCourseToStudent(@PathVariable Long courseId, @PathVariable Long studentId){
        return this.courseService.assignCourseToStudent(studentId, courseId);
    }

    @DeleteMapping("/courses/{courseId}/{studentId}")
    public Course removeCourseToStudent(@PathVariable Long courseId, @PathVariable Long studentId){
        return this.courseService.removeStudentFromCourse(studentId, courseId);
    }

    @PostMapping("/courses/professor/{courseId}/{professorId}")
    public Course setCourseProfessor(@PathVariable Long courseId, @PathVariable Long professorId){
        return this.courseService.setCourseProfessor(courseId, professorId);
    }

    @PostMapping("/courses/{courseId}/students/{studentsIds}")
    public Course setCourseStudents(@PathVariable Long courseId, @PathVariable List<Long> studentsIds){
        return this.courseService.setCourseStudents(courseId, studentsIds);
    }


    @GetMapping("/courses/students/{studentId}")
    public List<Course> coursesByStudent(@PathVariable Long studentId){
        return this.courseService.getStudentCourses(studentId);
    }
}
