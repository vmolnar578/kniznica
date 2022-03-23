package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookEntity createBook(BookDto book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setAuthorFirstname(book.getAuthorFirstname());
        bookEntity.setAuthorLastname(book.getAuthorLastname());
        bookEntity.setCount(book.getCount());
        return this.bookRepository.save(bookEntity);
    }

    public List<BookEntity> getBooks(String bookTitle) {
        List<BookEntity> books = bookRepository.findAll();
        if (bookTitle == null){
            return books;
        }

        List<BookEntity> specificBooks = new ArrayList<>();
        for(BookEntity book : books){
            if (book.getTitle().equals(bookTitle)){
                specificBooks.add(book);
            }
        }
        return specificBooks;
    }

    public BookEntity getBook(int bookId) {
        Optional<BookEntity> book = bookRepository.findById((long) bookId);
        return book.orElse(null);
    }

    public void updateBook(int bookId, BookDto book) {
        Optional<BookEntity> bookEntity = bookRepository.findById((long) bookId);

        if (bookEntity.isPresent()) {
            bookEntity.get().setTitle(book.getTitle());
            bookEntity.get().setIsbn(book.getIsbn());
            bookEntity.get().setAuthorFirstname(book.getAuthorFirstname());
            bookEntity.get().setAuthorLastname(book.getAuthorLastname());
            bookEntity.get().setCount(book.getCount());
        }
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
