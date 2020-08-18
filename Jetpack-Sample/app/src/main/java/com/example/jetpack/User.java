package com.example.jetpack;

public class User {

    private final String firstName;
    private final String lastName;
    private final String contact;


    public User(String firstName, String lastName, String contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getContact() {
        return this.contact;
    }
}
