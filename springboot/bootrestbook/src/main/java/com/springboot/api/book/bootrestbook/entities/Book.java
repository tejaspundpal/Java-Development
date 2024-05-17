package com.springboot.api.book.bootrestbook.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
    private int price;

    public Book(int id, Author author, String title, int price) {
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
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


// package com.springboot.api.book.bootrestbook.entities;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "books")
// public class Book {

//     @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//     private int id;
//     private String title;
//     private String author;
//     private int price;

//     public Book(int id, String author, String title, int price) {
//         this.author = author;
//         this.id = id;
//         this.price = price;
//         this.title = title;
//     }
    
//     public Book(){
//     }

//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public void setTitle(String title) {
//         this.title = title;
//     }

//     public String getAuthor() {
//         return author;
//     }

//     public void setAuthor(String author) {
//         this.author = author;
//     }

//     public int getPrice() {
//         return price;
//     }

//     public void setPrice(int price) {
//         this.price = price;
//     }

//     @Override
//     public String toString() {
//         return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
//     }

// }


