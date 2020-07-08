package com.it.demo.service;

import com.it.demo.dto.CourseDto;
import com.it.demo.entity.Course;
import com.it.demo.entity.Professor;
import com.it.demo.entity.Student;
import com.it.demo.exceptions.ResourceAlreadyPresentException;
import com.it.demo.exceptions.ResourceNotFoundException;
import com.it.demo.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService extends AbstractService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProfessorService professorService;

    public List<Course> getCourses(){
        List<Course> courses = this.courseRepository.findAll();
        logger.info("Returning All Courses:"+courses.toString());
        return courses;
    }

    public Course getCourseById(Long courseId) throws ResourceNotFoundException {
        Optional<Course> optional = this.courseRepository.findById(courseId);
        if ( optional.isPresent() ) {
            Course course = optional.get();
            logger.info("Returning Course: " + course.toString());
            return optional.get();
        }
        String error = String.format("Course with id %s not found", courseId);
        logger.error(error);
        throw new ResourceNotFoundException(error);
    }

    public Course setCourseStudents(Long courseId, List<Long> studentsIds){
        Course course = getCourseById(courseId);
        List<Student> students = new ArrayList<>();
        for (Long sId : studentsIds){
            Student student = this.studentService.getStudente(sId);
            students.add(student);
        }
        course.setStudents(students);
        this.courseRepository.save(course);
        return course;
    }

    public Course setCourseProfessor(Long courseId, Long professorId){
        Course course = getCourseById(courseId);
        Professor professor = this.professorService.getProfessor(professorId);
        course.setProfessor(professor);
        this.courseRepository.save(course);
        return course;
    }

    public Course assignCourseToStudent(Long studentId, Long courseId) throws ResourceAlreadyPresentException {
        Course course = getCourseById(courseId);
        Student student = this.studentService.getStudente(studentId);
        if (course.getStudents().contains(student)){
            String error = String.format("Student %s has already been assigned to course %s", student.getId(), course.getCourse_id());
            logger.error(error);
            throw new ResourceAlreadyPresentException(error);
        }
        course.addStudent(student);
        this.courseRepository.save(course);
        return course;
    }

    public Course removeStudentFromCourse(Long studentId, Long courseId) throws ResourceNotFoundException{
        Student student = this.studentService.getStudente(studentId);
        Course course = getCourseById(courseId);
        if (! course.getStudents().contains(student)){
            String error = String.format("Student %s hasn't yet enrolled course %s", student.getId(), course.getCourse_id());
            logger.error(error);
            throw new ResourceNotFoundException(error);
        }
        course.removeStudent(student);
        this.courseRepository.save(course);
        return course;
    }

    public List<Student> getStudentsByCourse(Long courseId){
        if(!courseRepository.existsById(courseId)){
            String error = String.format("Course ID %s Not Found", courseId);
            logger.error(error);
            throw new ResourceNotFoundException(error);
        }
        Course course = this.getCourseById(courseId);
        List<Student> students = course.getStudents();
        logger.info("Returning All Students for course:"+course+"\n"+students.toString());
        return students;
    }

    public List<Course> getStudentCourses(Long studentId){
        Student student = this.studentService.getStudente(studentId);
        List<Course> courses = student.getCourses();
        logger.info("Returning All Courses for student:"+student+"\n"+courses.toString());
        return courses;
    }

    public List<Course> getCoursesTeachedByProfessor(Long professorId){
        if(!professorService.professorExists(professorId)){
            String error = String.format("Professor ID %s Not Found", professorId);
            logger.error(error);
            throw new ResourceNotFoundException(error);
        }
        List<Course> courses = this.courseRepository.findByProfessorId(professorId);
        logger.info("Returning All Courses for professor"+professorId+"\n"+courses.toString());
        return courses;
    }

    public CourseDto convertCourseEntityToDto(Course course){
        return super.getMapper().map(course, CourseDto.class);
    }

    public Course convertCourseDtoToEntity(CourseDto courseDto){
        return super.getMapper().map(courseDto, Course.class);
    }

    public List<CourseDto> convertCourseEntityListToDto(List<Course> courses){
        return super.getMapper().mapAsList(courses, CourseDto.class);
    }

    public List<Course> convertCourseDtoListToEntity(List<CourseDto> courses){
        return super.getMapper().mapAsList(courses, Course.class);
    }
}
