package com.kodilla.patterns2.hibernate.manytomany.facade;

import com.kodilla.patterns2.hibernate.manytomany.Company;
import com.kodilla.patterns2.hibernate.manytomany.Employee;
import com.kodilla.patterns2.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.patterns2.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class FacadeTestSuite {
    @Autowired
    private CompanyFacade companyFacade;
    @Autowired
    private EmployeeFacade employeeFacade;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyDao companyDao;

    @Test
    void testEmployeeSearchByPartOfTheSurname() {
        //Given
        Employee johnDoe = new Employee("John", "Doe");
        Employee markMiller = new Employee("Mark", "Miller");
        Employee claraNovak = new Employee("Clara", "Novak");

        Company softwareSpec = new Company("Software Spec");
        Company dataGuru = new Company("Data Guru");
        Company fintechMasters = new Company("Fintech Masters");

        softwareSpec.getEmployees().add(johnDoe);
        dataGuru.getEmployees().add(markMiller);
        dataGuru.getEmployees().add(claraNovak);
        fintechMasters.getEmployees().add(johnDoe);
        fintechMasters.getEmployees().add(claraNovak);

        johnDoe.getCompanies().add(softwareSpec);
        johnDoe.getCompanies().add(fintechMasters);
        markMiller.getCompanies().add(dataGuru);
        claraNovak.getCompanies().add(dataGuru);
        claraNovak.getCompanies().add(fintechMasters);

        //When
        companyDao.save(softwareSpec);
        int softwareSpecId = softwareSpec.getId();
        companyDao.save(dataGuru);
        int dataGuruId = dataGuru.getId();
        companyDao.save(fintechMasters);
        int fintechMastersId = fintechMasters.getId();
        List<Employee> expectedEmployeeName = employeeDao.selectEmployeeByPartOfTheSurname("nov");

        //Then
        assertNotEquals(0, softwareSpecId);
        assertNotEquals(0, dataGuruId);
        assertNotEquals(0, fintechMastersId);
        assertEquals(1, expectedEmployeeName.size());

        //CleanUp
        try {
            companyDao.deleteById(softwareSpecId);
            companyDao.deleteById(dataGuruId);
            companyDao.deleteById(fintechMastersId);
        } catch (Exception e) {
            //do nothing
        }
        try {
            employeeFacade.selectEmployeeByPartOfTheSurname("");
        } catch (EmployeeException e){
            System.out.println("Please correct employee surname");
        }
    }

    @Test
    void testCompanySearchByPartOfTheName() {
        //Given
        Employee johnDoe = new Employee("John", "Doe");
        Employee markMiller = new Employee("Mark", "Miller");
        Employee claraNovak = new Employee("Clara", "Novak");

        Company softwareSpec = new Company("Software Spec");
        Company dataGuru = new Company("Data Guru");
        Company fintechMasters = new Company("Fintech Masters");

        softwareSpec.getEmployees().add(johnDoe);
        dataGuru.getEmployees().add(markMiller);
        dataGuru.getEmployees().add(claraNovak);
        fintechMasters.getEmployees().add(johnDoe);
        fintechMasters.getEmployees().add(claraNovak);

        johnDoe.getCompanies().add(softwareSpec);
        johnDoe.getCompanies().add(fintechMasters);
        markMiller.getCompanies().add(dataGuru);
        claraNovak.getCompanies().add(dataGuru);
        claraNovak.getCompanies().add(fintechMasters);

        //When
        companyDao.save(softwareSpec);
        int softwareSpecId = softwareSpec.getId();
        companyDao.save(dataGuru);
        int dataGuruId = dataGuru.getId();
        companyDao.save(fintechMasters);
        int fintechMastersId = fintechMasters.getId();
        List<Company> expectedCompanyName = companyDao.retrieveCompanyByPartOfTheName("int");

        //Then
        assertNotEquals(0, softwareSpecId);
        assertNotEquals(0, dataGuruId);
        assertNotEquals(0, fintechMastersId);
        assertEquals(1, expectedCompanyName.size());

        //CleanUp

        try {
            companyDao.deleteById(softwareSpecId);
            companyDao.deleteById(dataGuruId);
            companyDao.deleteById(fintechMastersId);
        } catch (Exception e) {
            //do nothing
        }
        try {
            companyFacade.selectCompanyByPartOfTheName("");
        } catch (CompanyException e) {
            System.out.println("Please correct company name");
        }
    }
}