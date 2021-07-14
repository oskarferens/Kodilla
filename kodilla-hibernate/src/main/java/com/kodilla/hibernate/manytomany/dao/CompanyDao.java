package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query
    List<Employee> retrieveEmployeeByLastname(@Param("LAST_NAME") String lastname);

    @Query(nativeQuery = true)
    List<Company> retrieveCompanyNameBySubstring(@Param("COMPANY_SUBSTRING") String companySubstring);

    @Query(nativeQuery = true)
    List<Company> retrieveCompanyByPartOfTheName(String name);
}