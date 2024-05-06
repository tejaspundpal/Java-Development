package com.springboot.api.book.bootrestbook.entities;

public class Book {

    private int id;
    private String title;
    private String author;
    private int price;

    public Book(int id, String author, String title, int price) {
        this.author = author;
        this.id = id;
        this.price = price;
        this.title = title;
    }
    
    public Book(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
    }

}
