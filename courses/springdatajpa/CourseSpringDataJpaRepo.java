package com.project.springboot.learn_jpa_and_hibernate.courses.springdatajpa;

import com.project.springboot.learn_jpa_and_hibernate.courses.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Spring Data JPA Generates the Code: The methods like save(), findAll(), and custom methods (findBy...)
// are implemented by a hidden class that Spring Data JPA automatically generates at runtime, based on
// the interface you defined.

//Hibernate Executes the Action: This generated code then uses the JPA EntityManager (which is controlled by Hibernate)
// to translate the request into the final SQL command and execute it against the database.

// inside code it is recommended to use jpa instead of hibernate annotations
// internally all the jpa annotations are implemented by hibernate

// Below -> Spring Data JPA automatically generates the repository code (the 'who-to-call')
// which uses the JPA EntityManager to invoke Hibernate's underlying execution methods, translating
// the Java object commands into the final SQL.
public interface CourseSpringDataJpaRepo extends JpaRepository<Course, Long> {
    // need not do anything here; this is unlike other repository beans implemented
    // using jbc and jpa

    // The JpaRepository interface already provides standard methods like:
    // save(), findAll(), findById(), deleteById(), and count().
    // We 'need not do anything here' because Spring Data JPA generates the code automatically.

    // BUT WHEN YOU WANT CUSTOM ATTRIBUTES TO BE NAMED AFTER USING YOUR CUSTOM METHODS:
    // Spring Data JPA reads these method names and automatically constructs the SQL query.

    // Example 1: Generates: SELECT * FROM Course WHERE author = ?
    List<Course> findByAuthor(String author);

    // Example 2: Generates: SELECT * FROM Course WHERE name = ?
    List<Course> findByName(String name);
}
