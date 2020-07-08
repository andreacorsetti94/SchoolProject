package com.it.demo.controller;

import com.it.demo.dto.ProfessorDto;
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
    public List<ProfessorDto> getProfessors(){
        List<Professor> professors = this.professorService.getProfessors();
        return this.professorService.convertProfessorEntityListToDto(professors);
    }

    @GetMapping("/professors/{professorId}")
    public ProfessorDto getProfessor(@PathVariable Long professorId){
        Professor professor = this.professorService.getProfessor(professorId);
        return this.professorService.convertProfessorEntityToDto(professor);
    }
}
