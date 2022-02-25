package com.app.dto;

import com.app.model.Book;

import java.util.List;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean isCustomer;
    private List<Book> bookList;
}
