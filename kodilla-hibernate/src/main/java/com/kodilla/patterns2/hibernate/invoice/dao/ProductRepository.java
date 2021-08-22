package com.kodilla.patterns2.hibernate.invoice.dao;

import com.kodilla.patterns2.hibernate.invoice.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer>{

}
