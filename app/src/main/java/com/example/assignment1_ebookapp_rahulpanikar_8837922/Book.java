package com.example.assignment1_ebookapp_rahulpanikar_8837922;

public class Book {
    private final String name;
    private final String description;
    private final String price;

    public Book(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }
}

