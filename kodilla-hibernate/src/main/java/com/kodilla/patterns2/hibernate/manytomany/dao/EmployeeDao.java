package com.kodilla.patterns2.hibernate.manytomany.dao;

import com.kodilla.patterns2.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query
    List<Employee> selectEmployeeByPartOfTheSurname(String lastname);
}