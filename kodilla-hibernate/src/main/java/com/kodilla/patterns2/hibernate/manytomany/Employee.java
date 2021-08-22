package com.kodilla.patterns2.hibernate.manytomany;

import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Service
@NamedQuery(
        name = "Company.retrieveEmployeeByLastname",
        query = "FROM Employee WHERE lastName = :LAST_NAME"
)
@NamedQuery(
        name = "Employee.selectEmployeeByPartOfTheSurname",
        query = "FROM Employee WHERE lastName LIKE'%nov%'"
)

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private List<Company> companies = new ArrayList<>();

    public Employee() {

    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "EMPLOYEE_ID", unique = true)
    public int getId() {
        return id;
    }
    @Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }
    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "JOIN_COMPANY_EMPLOYEE",
            joinColumns = {@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")})
    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}