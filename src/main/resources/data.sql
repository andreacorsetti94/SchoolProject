DROP TABLE IF EXISTS Student;
DROP TABLE IF EXISTS Course;
DROP TABLE IF EXISTS Professor;
DROP TABLE IF EXISTS Course_Student;


CREATE TABLE Student (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  birth_date DATE NOT NULL,
  sex VARCHAR(250) NOT NULL
);

CREATE TABLE Professor (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  birth_date DATE NOT NULL,
  sex VARCHAR(250) NOT NULL
);

CREATE TABLE Course (
  course_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  professor_id INT NOT NULL,
  FOREIGN KEY (professor_id) REFERENCES Professor(id)
);

CREATE TABLE Course_Student (
  course_id INT AUTO_INCREMENT,
  student_id INT AUTO_INCREMENT,
  FOREIGN KEY (course_id) REFERENCES Course(course_id),
  FOREIGN KEY (student_id) REFERENCES Student(id),
  PRIMARY KEY(course_id, student_id)
);

insert into Student
values(10001,'FirstName1', 'LastName1', parsedatetime('01-01-2001','dd-MM-yyyy'),'MALE');

insert into Student
values(10002,'FirstName2', 'LastName2', parsedatetime('01-01-2002','dd-MM-yyyy'),'FEMALE');

insert into Student
values(10003,'FirstName3', 'LastName3', parsedatetime('01-01-2003','dd-MM-yyyy'),'MALE');

insert into Student
values(10004,'FirstName4', 'LastName4', parsedatetime('01-01-2004','dd-MM-yyyy'),'OTHER');

insert into Professor
values(99901,'FirstName5', 'LastName5', parsedatetime('01-01-1995','dd-MM-yyyy'),'MALE');

insert into Professor
values(99902,'FirstName6', 'LastName6', parsedatetime('01-01-1996','dd-MM-yyyy'),'OTHER');

insert into Professor
values(99903,'FirstName4', 'LastName4', parsedatetime('01-01-1994','dd-MM-yyyy'),'FEMALE');

insert into Course
values(55501, 'Computer Science', 99901);

insert into Course
values(55502, 'Linfo', 99902);

insert into Course
values(55503, 'Spanish', 99903);

insert into Course_Student values(55501,10001);
insert into Course_Student values(55501,10002);
insert into Course_Student values(55502,10003);
insert into Course_Student values(55503,10001);
insert into Course_Student values(55503,10002);
insert into Course_Student values(55503,10003);
insert into Course_Student values(55503,10004);