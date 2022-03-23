package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class bookController {
    private BookService bookService;

    public bookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/api/books")
    public BookEntity createBook(@RequestBody BookDto book){
        return bookService.createBook(book);
    }

    @GetMapping("/api/books")
    public List<BookEntity> getBooks(@RequestParam(required=false, name="title") String bookTitle) {
        return bookService.getBooks(bookTitle);
    }

    @GetMapping("/api/books/{bookId}")
    public BookEntity getBook(@PathVariable Integer bookId){
        return bookService.getBook(bookId);
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
    }

    @PutMapping("/api/books/{bookId}")
    public BookDto updateBook(@PathVariable Integer bookId, @RequestBody BookDto book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthorFirstname(book.getAuthorFirstname());
        bookDto.setAuthorLastname(book.getAuthorLastname());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setCount(book.getCount());
        return bookDto;
    }
}
