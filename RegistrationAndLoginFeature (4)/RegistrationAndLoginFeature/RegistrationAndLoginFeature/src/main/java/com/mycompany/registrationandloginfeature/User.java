package com.mycompany.registrationandloginfeature;

public class User {
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    protected String phoneNumber;

    public User() {
    }

    public User(String firstName, String lastName, String username, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}