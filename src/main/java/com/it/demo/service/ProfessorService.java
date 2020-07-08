package com.it.demo.service;

import com.it.demo.dto.ProfessorDto;
import com.it.demo.entity.Professor;
import com.it.demo.exceptions.ResourceNotFoundException;
import com.it.demo.repository.ProfessorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService extends AbstractService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> getProfessors(){
        List<Professor> professors = this.professorRepository.findAll();
        logger.info("Returning All Professors:"+professors.toString());
        return professors;
    }

    public Boolean professorExists(Long professorId){
        return this.professorRepository.existsById(professorId);
    }

    public Professor getProfessor(Long professorId)  throws ResourceNotFoundException{
        Optional<Professor> optional = this.professorRepository.findById(professorId);
        if ( optional.isPresent() ) {
            Professor professor = optional.get();
            logger.info("Returning Professor: " + professor.toString());
            return optional.get();
        }
        String error = String.format("Professor with id %s not found", professorId);
        logger.error(error);
        throw new ResourceNotFoundException(error);
    }

    public ProfessorDto convertProfessorEntityToDto(Professor professor){
        return super.getMapper().map(professor, ProfessorDto.class);
    }

    public Professor convertProfessorDtoToEntity(ProfessorDto professorDto){
        return super.getMapper().map(professorDto, Professor.class);
    }

    public List<ProfessorDto> convertProfessorEntityListToDto(List<Professor> professors){
        return super.getMapper().mapAsList(professors, ProfessorDto.class);
    }

    public List<Professor> convertProfessorDtoListToEntity(List<ProfessorDto> professorDtos){
        return super.getMapper().mapAsList(professorDtos, Professor.class);
    }
}
