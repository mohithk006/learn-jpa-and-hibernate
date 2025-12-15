package com.project.springboot.learn_jpa_and_hibernate.courses.jdbc;

import com.project.springboot.learn_jpa_and_hibernate.courses.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository     // -> a repository that talks to the course table in the database
// to run this repo we again need command line runner component that uses the methods indi==side this repository
public class CourseJdbcRepo {
    @Autowired
    // this allows you to fire queries using spring jdbc
    private JdbcTemplate jdbcTemplate;

    /* Inside jdbcTemplate we have several methods out of which few of them are explained below
        jdbcTemplate.update() -> here all the delete, update and insert ops are performed by effectively running sql
        commands
        jdbcTemplate.queryForObject() -> to retrieve data; this means querying for a specific object
     */
    public void insert(Course course) {
        // when the application starts in main(), this query is fired up
        // this is practically called by spring boot's command line runner
        String QUERY = """
           INSERT INTO COURSE(id, name, author)
            VALUES(?, ?, ?);
           \s""";

        //below order should match the above order in the query
        jdbcTemplate.update(QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(long id) {
        String QUERY = """
                DELETE FROM COURSE WHERE ID = ?;
                """;

        jdbcTemplate.update(QUERY, id);
    }

    public Course retrieveByID(long id) {
        String QUERY = """
                SELECT * FROM COURSE WHERE ID = ?;
                """;
        // below -> the BeanPropertyRowMapper automatically turns a row of raw SQL data into a usable Java object (Bean).
        return jdbcTemplate.queryForObject(QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }

}



