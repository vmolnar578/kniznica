package com.example.demo;
 
public class CustomerDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String contact;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }
 
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
 
    public String getLastname() {
        return lastname;
    }
 
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
 
    public String getContact() {
        return contact;
    }
 
    public void setContact(String contact) {
        this.contact = contact;
    }
}
 
