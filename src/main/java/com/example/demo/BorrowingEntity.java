package com.example.demo;

import com.example.demo.BookEntity;
import com.example.demo.CustomerEntity;
import javax.persistence.*;

public class BorrowingEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private BookEntity bookEntity;
    private CustomerEntity customersEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookEntity getBook() {
        return bookEntity;
    }

    public void setBook(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    public CustomerEntity getCustomer() {
        return customersEntity;
    }

    public void setCustomer(CustomerEntity customersEntity) {
        this.customersEntity = customersEntity;
    }
}
