package com.it.demo.controller;

import com.it.demo.entity.Professor;
import com.it.demo.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;


    @GetMapping("/professors")
    public List<Professor> getProfessors(){
        return this.professorService.getProfessors();
    }

    @GetMapping("/professors/{professorId}")
    public Professor getProfessor(@PathVariable Long professorId){
        return this.professorService.getProfessor(professorId);
    }
}
