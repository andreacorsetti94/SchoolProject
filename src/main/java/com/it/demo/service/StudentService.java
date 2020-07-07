package com.it.demo.service;

import com.it.demo.exceptions.ResourceNotFoundException;
import com.it.demo.repository.StudentRepository;
import com.it.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        List<Student> students = this.studentRepository.findAll();
        logger.info("Returning All Students:"+students.toString());
        return students;
    }

    public Student getStudente(Long idStudente) throws ResourceNotFoundException{
        Optional<Student> optional = this.studentRepository.findById(idStudente);
        if ( optional.isPresent() ) {
            Student student = optional.get();
            logger.info("Returning Student: " + student.toString());
            return optional.get();
        }
        String error = String.format("Student with id %s not found", idStudente);
        logger.error(error);
        throw new ResourceNotFoundException(error);
    }


}
