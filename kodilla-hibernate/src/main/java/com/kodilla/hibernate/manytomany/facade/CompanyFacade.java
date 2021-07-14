package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);
    private Company company;

    @Autowired
    public CompanyFacade(Company company) {
        this.company = company;
    }

    public void selectCompanyByPartOfTheName() throws CompanyException {
    }
}