package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Optional;


@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("111");
        Product product = new Product("product1");
        Product product2 = new Product("product2");
        Item item = new Item(new BigDecimal(564), 32, new BigDecimal("3453"));
        Item item2 = new Item(new BigDecimal(356), 65, new BigDecimal("3875"));
        Item item3 = new Item(new BigDecimal(535), 2, new BigDecimal("3544"));

        invoice.getItems().add(item);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        item.setProduct(product);
        item2.setProduct(product);
        item3.setProduct(product2);

        item.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

        //When
        productDao.save(product);
        int idProd1 = product.getId();
        productDao.save(product2);
        int idProd2 = product2.getId();
        invoiceDao.save(invoice);
        int idInv = invoice.getId();
        itemDao.save(item);
        int idItem1 = item.getId();
        itemDao.save(item2);
        int idItem2 = item2.getId();


        //Then
        assertNotEquals(0, idProd1);
        assertNotEquals(0, idProd2);
        assertNotEquals(0, idInv);
        assertNotEquals(0, idItem1);
        assertNotEquals(0, idItem2);

        //CleanUp
        productDao.deleteAll();
        itemDao.deleteAll();
        invoiceDao.deleteAll();
    }
}
