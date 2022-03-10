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
    public BookEntity createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }
 
    @GetMapping("/api/books")
    public List<BookDto> getBooks(@RequestParam(required=false, name="title") String bookTitle) {
        return bookService.getBooks(bookTitle);
    }
 
    @GetMapping("/api/books/{bookId}")
    public BookDto getBook(@PathVariable Integer bookId){
        return addToDto(bookService.getBook(bookId));
    }
 
    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        bookService.deleteBook(bookId);
    }
 
    @PutMapping("/api/books/{bookId}")
    public void updateBook(@PathVariable Integer bookId, @RequestBody Book book) {
        bookService.updateBook(bookId, book);
    }
}