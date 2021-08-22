package com.kodilla.patterns2.hibernate.invoice.dao;

import com.kodilla.patterns2.hibernate.invoice.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface InvoiceRepository extends CrudRepository<Invoice,Integer> {
Invoice findById(int id);
}
