package com.kodilla.patterns2.hibernate.invoice.dao;

import com.kodilla.patterns2.hibernate.invoice.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Integer> {

}
