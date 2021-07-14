package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);


    @Autowired
    private CompanyDao companydao;

    public List<Company> selectCompanyByPartOfTheName(String name) throws CompanyException {
    return companydao.retrieveCompanyByPartOfTheName(name);
    }
}