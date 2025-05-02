package com.example.CRUD.dao;

import com.example.CRUD.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();

}
