package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books;

    public BookService() {
        this.books = init();
    }

    private List<Book> init(){
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setAuthorFirstname("Peter");
        book.setAuthorLastname("Lynch");
        book.setTitle("One up on Wall Street");
        book.setIsbn("ISBN12A69C");
        book.setCount(10);
        books.add(book);

        Book book2 = new Book();
        book2.setAuthorFirstname("Joanne");
        book2.setAuthorLastname("Rowling");
        book2.setTitle("Harry Potter");
        book2.setIsbn("ISBN53B44A");
        book2.setCount(20);
        books.add(book2);
        return books;
    }

    public List<Book> getBooks(String bookTitle) {
        if (bookTitle == null){
            return this.books;
        }

        List<Book> filteredBooks = new ArrayList<>();

        for(Book book : books){
            if (book.getTitle().equals(bookTitle)){
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    public Book getBook(int bookId) {
        return this.books.get(bookId);
    }

    public Integer createBook(Book book) {
        this.books.add(book);

        return this.books.size() -1;
    }

    public void deleteBook(int bookId) {
        this.books.remove(bookId);
    }

    public void updateBook(int bookId, Book book) {
        this.books.get(bookId).setTitle(book.getTitle());
    }
}
