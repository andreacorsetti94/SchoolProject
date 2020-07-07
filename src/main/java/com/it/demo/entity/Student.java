package com.it.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Student extends Person {

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Course_Student",
			joinColumns = { @JoinColumn(name = "student_id") },
			inverseJoinColumns = { @JoinColumn(name = "course_id") })
	@JsonIgnore
	private List<Course> courses;

	public Student(Long id, String name, String lastname, LocalDate birthDate, Sex sex) {
		super(id, name, lastname, birthDate, sex);
	}

	public Student(){
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student{" +
				"} " + super.toString();
	}

}
