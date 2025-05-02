package com.example.CRUD.dao;

import com.example.CRUD.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeDAOJpaImpl implements EmployeeDao{
   // In a Spring Boot (Java) application, the EntityManager is a JPA interface used to interact with the
    // persistence context (i.e., the database layer). It is part of the Java Persistence API (JPA), which
    // abstracts and manages all interactions with relational databases.


    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll(){
        //create a query
        //This line tells JPA to create a query that fetches all Employee objects from the database.
        //"from Employee" is a JPQL query, not SQL. It means: "Select all rows from the Employee entity."
        // (JPQL uses entity class names, not table names).
        //Employee.class tells JPA what type of result to expect.
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee" , Employee.class);

        //execute the query and get results list.
        List<Employee> employees = theQuery.getResultList();

        //return the results
        //Returns the list of employees back to the caller.
        return employees;
    }

}
