package com.kodilla.patterns2.hibernate.manytomany;

import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Service
@NamedNativeQuery(
        name = "Company.retrieveCompanyNameBySubstring",
        query = "select * from companies where substring(company_name,1,3) LIKE :COMPANY_SUBSTRING",
        resultClass = Company.class
)
@NamedNativeQuery(
        name = "Company.retrieveCompanyByPartOfTheName",
        query = "select * from companies where company_name LIKE '%int%'",
        resultClass = Company.class
)

@Entity
@Table(name = "COMPANIES")
public class Company {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company() {

    }

    public Company(String name) {
        this.name = name;
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }
    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies", targetEntity = Employee.class)
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}