package com.it.demo.configuration;

import com.it.demo.dto.CourseDto;
import com.it.demo.dto.ProfessorDto;
import com.it.demo.dto.StudentDto;
import com.it.demo.entity.Course;
import com.it.demo.entity.Professor;
import com.it.demo.entity.Student;
import com.it.demo.mapper.OrikaMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(OrikaProperties.class)
public class MappingConfiguration {

    @Bean
    public OrikaMapper mapper(OrikaProperties orikaProperties) {
        MapperFactory mapperFactory = mapperFactory(orikaProperties);

        mapperFactory.classMap(Course.class, CourseDto.class)
                .field("course_id","courseId")
                .field("name","courseName")
                .field("students","studentDtos")
                .field("professor","professorDto").byDefault().register();

        mapperFactory.classMap(CourseDto.class, Course.class)
                .field("courseId","course_id")
                .field("courseName","name")
                .field("studentDtos","students")
                .field("professorDto","professor").byDefault().register();

        mapperFactory.classMap(Student.class, StudentDto.class).byDefault().register();
        mapperFactory.classMap(StudentDto.class, Student.class).byDefault().register();

        mapperFactory.classMap(Professor.class, ProfessorDto.class).byDefault().register();
        mapperFactory.classMap(ProfessorDto.class, Professor.class).byDefault().register();

        return new OrikaMapper(mapperFactory.getMapperFacade());
    }

    @Bean
    public MapperFactory mapperFactory(OrikaProperties orikaProperties) {
        DefaultMapperFactory.Builder orikaMapperFactoryBuilder = new DefaultMapperFactory.Builder();
        orikaMapperFactoryBuilder.useAutoMapping(orikaProperties.getUseDefaultMapper());
        orikaMapperFactoryBuilder.mapNulls(orikaProperties.getMapNull());
        return orikaMapperFactoryBuilder.build();
    }
}
