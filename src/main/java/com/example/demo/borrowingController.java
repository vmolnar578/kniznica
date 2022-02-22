package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class borrowingController {
    private BorrowingService borrowingService;

    public borrowingController(BookService borrowingService) {
        this.borrowingService = borrowingService;
    }

    //Create borrowing
    //POST http://localhost:8080/api/borrowings
    @PostMapping("/api/borrowings")
    public Integer createBorrowing(@RequestBody Borrowing borrowing){
        return borrowingService.createBorrowing(borrowing);
    }

    //List borrowings
    //GET http://localhost:8080/api/borrowings
    @GetMapping("/api/borrowings")
    public List<Borrowing> getBorrowings() {
        return borrowingService.getBorrowings();
    }

    //Get borrowing by id
    //GET http://localhost:8080/api/borrowings/{borrowingId}
    @GetMapping("/api/borrowings/{borrowingId}")
    public Borrowing getBorrowing(@PathVariable Integer borrowingId){
        return borrowingService.getBorrowing(borrowingId);
    }

    //Return book (delete borrowing)
    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowing(@PathVariable Integer borrowingId){
        borrowingService.deleteBorrowing(borrowingId);
    }
}
