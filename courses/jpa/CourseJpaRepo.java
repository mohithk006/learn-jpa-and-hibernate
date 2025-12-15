package com.project.springboot.learn_jpa_and_hibernate.courses.jpa;

import com.project.springboot.learn_jpa_and_hibernate.courses.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository

// whenever you want to execute queries using jpa, we have to use @Transactional
@Transactional
public class CourseJpaRepo {

    // instead of @Autowired we use more specific one -> @PersistenceContext
    // this expresses a dependency on a container managed entity manager and its associated persistence context
    @PersistenceContext // simply used to inject the entity manager
    // The EntityManager is the main tool defined by the JPA standard that acts as a manager
    // and communication channel for all database operations, allowing you to save, retrieve, update,
    // and remove Java objects (entities).
    // The EntityManager is the tool that saves, retrieves, and tracks all your Java objects
    // (like your Course or Person objects) while your application is running, acting as the direct
    // link to the database.

    private EntityManager entityManager;

    public void insert(Course course) {
        // to insert a row into the course table
        entityManager.merge(course);
    }

    public Course retrieveByID(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteByID(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

}
