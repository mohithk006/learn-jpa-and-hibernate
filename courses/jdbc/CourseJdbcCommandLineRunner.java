package com.project.springboot.learn_jpa_and_hibernate.courses.jdbc;

import com.project.springboot.learn_jpa_and_hibernate.courses.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
//
//@Component
//public class CourseJdbcCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJdbcRepo repo;
//
//    @Override
//    public void run(String... args) throws Exception {
//        repo.insert(new Course(1, "Learn Spring", "MoCode"));
//        repo.insert(new Course(2, "Learn Javah", "SuCode"));
//        repo.insert(new Course(3, "Learn Everything", "RaCode"));
//        repo.delete(3);
//
//        System.out.println(repo.retrieveByID(1));
//        System.out.println(repo.retrieveByID(2));
//    }
//}
