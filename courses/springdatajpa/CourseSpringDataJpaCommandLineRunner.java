package com.project.springboot.learn_jpa_and_hibernate.courses.springdatajpa;

import com.project.springboot.learn_jpa_and_hibernate.courses.Course;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseSpringDataJpaCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseSpringDataJpaRepo repo;

    @Override
    public void run(String... args) throws Exception {
        repo.save(new Course(1, "Learn Spring", "MoCode"));
        repo.save(new Course(2, "Learn Javah", "SuCode"));
        repo.save(new Course(3, "Learn Everything", "RaCode"));

        repo.deleteById(1L);

        System.out.println(repo.findById(3L).get());
        System.out.println(repo.findById(2L).get());
        System.out.println(repo.findAll()); // -> SELECT * FROM COURSE;
        System.out.println(repo.count()); // -> SELECT COUNT(*) FROM COURSE;
    }
}