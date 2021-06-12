package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Transactional
@SpringBootTest


public class InvoiceDaoTestSuite {
    @Autowired
   private ProductRepository productRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Test public void invoiceDaoSave() {
        Product product = new Product("Zelazko");
        Invoice invoice = new Invoice("FV2000/2021");
        Item item = new Item(product, new BigDecimal("100"), 1, new BigDecimal("100"));

        Product product1 = new Product("Miotla");
        Item item1 = new Item(product, new BigDecimal("50"), 1, new BigDecimal("50"));

        product.getItems().add(item);
        item.setInvoice(invoice);
        invoice.getItems().add(item);

        product1.getItems().add(item1);
        item1.setInvoice(invoice);
        invoice.getItems().add(item1);

        //When
        productRepository.save(product);
        invoiceRepository.save(invoice);
        itemRepository.save(item);
        int id = invoice.getId();

        //Then
        Assertions.assertEquals("Zelazko",product.getName());
        Assertions.assertEquals("Miotla",product1.getName());
        //CleanUp
        invoiceRepository.deleteById(id);
    }
}
//
//@SpringBootTest
//public class InvoiceDaoTestSuite {
//
//    @Autowired
//    private InvoiceDao invoiceDao;
//
//    @Test
//    void testInvoiceDaoSave() {
//        //Given
//        Product product1 = new Product("pencil");
//        Product product2 = new Product("pen");
//        Item item1 = new Item(product1, BigDecimal.valueOf(1.5), 4,BigDecimal.valueOf(6));
//        Item item2 = new Item(product2, BigDecimal.valueOf(2.3), 4,BigDecimal.valueOf(9.2));
//        Invoice invoice = new Invoice("2021/05/14/001");
//
//        item1.setInvoice(invoice);
//        item2.setInvoice(invoice);
//
//        List<Item> itemList = new ArrayList<>();
//        itemList.add(item1);
//        itemList.add(item2);
//        invoice.setItems(itemList);
//
//        //When
//        invoiceDao.save(invoice);
//        int id = invoice.getId();
//        int itemsSize = invoice.getItems().size();
//        Invoice invoiceDB = invoiceDao.findById(id);
//        String productDB = invoiceDB.getItems().get(0).getProduct().getName();
//
//        //Then
//        Assertions.assertEquals(1,invoiceDao.count() );
//        Assertions.assertEquals("pencil", productDB);
//        Assertions.assertEquals(itemsSize, invoiceDB.getItems().size());
//
//        //CleanUp
//        invoiceDao.deleteById(id);
//
//    }
//}

