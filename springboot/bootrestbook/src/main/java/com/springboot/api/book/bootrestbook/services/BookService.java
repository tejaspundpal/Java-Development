package com.springboot.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.springboot.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(1, "Java DSA", "abc", 200));
        list.add(new Book(2, "C++ DSA", "lmn", 150));
        list.add(new Book(3, "Python DSA", "xyz", 250));
    }

    public List<Book> getAllBooks() {
        return list;
    }

    public Book getBookById(int id) {
        Book book = null;
        try {
            book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book b) {
        list.add(b);
        return b;
    }

    public void deleteBookById(int id) {
        list = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
    }

    public Book updateBook(Book book, int id) {
        Book updatedList = null;
        updatedList = (Book) list.stream().map(b -> {
            if (b.getId() == id) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setPrice(book.getPrice());
            }
            return b;
        }).collect(Collectors.toList());
        return updatedList;
    }
}
