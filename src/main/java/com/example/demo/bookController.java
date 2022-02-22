package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class bookController {
    private BookService bookService;

    public bookController(BookService bookService) {
        this.bookService = bookService;
    }

    //Create new book title
    //POST http://localhost:8080/api/books
    @PostMapping("/api/books")
    public Integer createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    //List all books & List books by title
    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required=false, name="title") String bookTitle) {
        return bookService.getBooks(bookTitle);
    }

    //Get book by id
    @GetMapping("/api/books/{bookId}")
    public Book getBook(@PathVariable Integer bookId){
        return bookService.getBook(bookId);
    }

    //Delete book by id
    //DELETE http://localhost:8080/api/books/{bookId}
    @DeleteMapping("/api/books{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        bookService.deleteBook(bookId);
    }

    //Update book title by id
    //PUT http://localhost:8080/api/books/{bookId}
    @PutMapping("/api/books{bookId}")
    public void updateBook(@PathVariable Integer bookId, @RequestBody Book book) {
        bookService.updateBook(bookId, book);
    }
}
