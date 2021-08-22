package com.kodilla.patterns2.hibernate.manytomany.dao;

import com.kodilla.patterns2.hibernate.manytomany.Company;
import com.kodilla.patterns2.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMasters.getEmployees().add(stephanieClarckson);
        dataMasters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMasters);
        int dataMaestersId = dataMasters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }
    @Test
    void testEmployeeQuery() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");

        Company dataMasters = new Company("Data Masters");
        Company softwareMachine = new Company("Software Machine");
        Company greyMatter = new Company("Grey Matter");

        dataMasters.getEmployees().add(lindaKovalsky);
        softwareMachine.getEmployees().add(johnSmith);
        softwareMachine.getEmployees().add(stephanieClarckson);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        lindaKovalsky.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(softwareMachine);

        companyDao.save(dataMasters);
        int dataMastersId = dataMasters.getId();

        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();

        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //When
        String lastName1 = johnSmith.getLastName();
        List<Employee> employeeLastName1 = companyDao.retrieveEmployeeByLastname(lastName1);

        String lastName2 = lindaKovalsky.getLastName();
        List<Employee> employeeLastName2 = companyDao.retrieveEmployeeByLastname(lastName2);

        String lastName3 = stephanieClarckson.getLastName();
        List<Employee> employeeLastName3 = companyDao.retrieveEmployeeByLastname(lastName3);

        //Then
        assertEquals(1, employeeLastName1.size());
        assertEquals(1, employeeLastName2.size());
        assertEquals(1, employeeLastName3.size());

        //CleanUp
        try {
            companyDao.deleteById(dataMastersId);
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //Do nothing
        }
    }
    @Test
    void testCompanyQuery() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");

        Company dataMasters = new Company("Data Masters");
        Company softwareMachine = new Company("Software Machine");
        Company greyMatter = new Company("Grey Matter");

        dataMasters.getEmployees().add(lindaKovalsky);
        softwareMachine.getEmployees().add(johnSmith);
        softwareMachine.getEmployees().add(stephanieClarckson);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        lindaKovalsky.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(softwareMachine);

        companyDao.save(dataMasters);
        int dataMastersId = dataMasters.getId();

        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();

        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //When
        String companySubs1 = "Dat";
        List<Company> companyName1 = companyDao.retrieveCompanyNameBySubstring(companySubs1);

        String companySubs2 = "Sof";
        List<Company> companyName2 = companyDao.retrieveCompanyNameBySubstring(companySubs2);

        String companySubs3 = "Gre";
        List<Company> companyName3 = companyDao.retrieveCompanyNameBySubstring(companySubs3);

        //Then
        assertEquals(1, companyName1.size());
        assertEquals(1, companyName2.size());
        assertEquals(1, companyName3.size());

        //CleanUp
        try {
            companyDao.deleteById(dataMastersId);
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //Do nothing
        }
    }
}