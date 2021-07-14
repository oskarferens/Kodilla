package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);
    private Employee employee;

    @Autowired
    public EmployeeFacade(Employee employee) {
        this.employee = employee;
    }

    public void selectEmployeeByPartOfTheSurname() throws EmployeeException {
    }
}