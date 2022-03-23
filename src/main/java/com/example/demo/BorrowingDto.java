package com.example.demo;
 
public class BorrowingDto {
    private Integer id;
    private Long customerId;
    private Integer bookId;
    private String authorFirstname;
    private String authorLastname;
    private String customerFirstname;
    private String customerLastname;
    private String title;
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public Long getCustomerId() {
        return customerId;
    }
 
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getAuthorFirstname() {
        return authorFirstname;
    }

    public void setAuthorFirstname(String authorFirstname) {
        this.authorFirstname = authorFirstname;
    }

    public String getAuthorLastname() {
        return authorLastname;
    }

    public void setAuthorLastname(String authorLastname) {
        this.authorLastname = authorLastname;
    }

    public String getCustomerFirstname() {
        return customerFirstname;
    }

    public void setCustomerFirstname(String authorFirstname) {
        this.customerFirstname = authorFirstname;
    }

    public String getCustomerLastname() {
        return customerLastname;
    }

    public void setCustomerLastname(String authorLastname) {
        this.customerLastname = authorLastname;
    }
 
    public Integer getBookId() {
        return bookId;
    }
 
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String setTitle(String title) {
        return this.title;
    }

    public void getTitle(String title) {
        this.title = title;
    }
}
 
