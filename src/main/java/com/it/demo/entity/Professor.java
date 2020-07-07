package com.it.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Professor")
public class Professor extends Person {

    public Professor(Long id, String name, String lastname, LocalDate birthDate, Sex sex) {
        super(id, name, lastname, birthDate, sex);
    }

    public Professor(){
    }

    @Override
    public String toString() {
        return "Professor{" +
                "} " + super.toString();
    }
}
