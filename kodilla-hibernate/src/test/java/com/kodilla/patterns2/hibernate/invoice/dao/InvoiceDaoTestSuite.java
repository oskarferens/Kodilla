package com.kodilla.patterns2.hibernate.invoice.dao;

import com.kodilla.patterns2.hibernate.invoice.Invoice;
import com.kodilla.patterns2.hibernate.invoice.Item;
import com.kodilla.patterns2.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;
import java.math.BigDecimal;

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