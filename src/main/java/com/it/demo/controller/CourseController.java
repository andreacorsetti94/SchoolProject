package com.it.demo.controller;

import com.it.demo.dto.CourseDto;
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
    public List<CourseDto> getAllCourses(){
        List<Course> courses = this.courseService.getCourses();
        return this.courseService.convertCourseEntityListToDto(courses);
    }

    @GetMapping("/courses/{courseId}")
    public CourseDto getCourseById(@PathVariable Long courseId){
        Course course = this.courseService.getCourseById(courseId);
        return this.courseService.convertCourseEntityToDto(course);
    }

    @PostMapping("/courses/{courseId}/{studentId}")
    public CourseDto assignCourseToStudent(@PathVariable Long courseId, @PathVariable Long studentId){
        Course course =  this.courseService.assignCourseToStudent(studentId, courseId);
        return this.courseService.convertCourseEntityToDto(course);
    }

    @DeleteMapping("/courses/{courseId}/{studentId}")
    public CourseDto removeCourseToStudent(@PathVariable Long courseId, @PathVariable Long studentId){
        Course course =  this.courseService.removeStudentFromCourse(studentId, courseId);
        return this.courseService.convertCourseEntityToDto(course);
    }

    @PostMapping("/courses/professor/{courseId}/{professorId}")
    public CourseDto setCourseProfessor(@PathVariable Long courseId, @PathVariable Long professorId){
        Course course =  this.courseService.setCourseProfessor(courseId, professorId);
        return this.courseService.convertCourseEntityToDto(course);
    }

    @PostMapping("/courses/{courseId}/students/{studentsIds}")
    public CourseDto setCourseStudents(@PathVariable Long courseId, @PathVariable List<Long> studentsIds){
        Course course =  this.courseService.setCourseStudents(courseId, studentsIds);
        return this.courseService.convertCourseEntityToDto(course);
    }

    @GetMapping("/courses/students/{studentId}")
    public List<CourseDto> coursesByStudent(@PathVariable Long studentId){
        List<Course> courses = this.courseService.getStudentCourses(studentId);
        return this.courseService.convertCourseEntityListToDto(courses);
    }

    @GetMapping("/courses/professor/{professorId}")
    public List<CourseDto> coursesByProfessor(@PathVariable Long professorId){
        List<Course> courses = this.courseService.getCoursesTeachedByProfessor(professorId);
        return this.courseService.convertCourseEntityListToDto(courses);
    }
}
