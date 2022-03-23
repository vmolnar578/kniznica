package com.example.demo;

import com.example.demo.BookEntity;
import com.example.demo.CustomerEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class borrowingController {
    private BorrowingService borrowingService;

    public borrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    //Create borrowing
    //POST http://localhost:8080/api/borrowings
    @PostMapping("/api/borrowings")
    public BorrowingEntity createBorrowing(@RequestBody BorrowingDto borrowingDto){
        return borrowingService.createBorrowing(borrowingDto);
    }

    //List borrowings
    //GET http://localhost:8080/api/borrowings
    @GetMapping("/api/borrowings")
    public List<BorrowingEntity> getBorrowings() {
        return borrowingService.getBorrowings();
    }

    //Get borrowing by id
    //GET http://localhost:8080/api/borrowings/{borrowingId}
    @GetMapping("/api/borrowings/{borrowingId}")
    public BorrowingDto getBorrowing(@PathVariable Long borrowingId){
        BorrowingEntity borrowingEntity = borrowingService.getBorrowing(borrowingId);
        BookEntity bookEntity = borrowingEntity.getBook();
        BorrowingDto borrowingDto = new BorrowingDto();
        CustomerEntity customer = borrowingEntity.getCustomer();
        borrowingDto.setId(borrowingEntity.getId());
        borrowingDto.setCustomerId(customer.getId());
        borrowingDto.setCustomerFirstname(customer.getFirstname());
        borrowingDto.setCustomerLastname(customer.getLastname());
        borrowingDto.setAuthorFirstname(bookEntity.getAuthorFirstname());
        borrowingDto.setAuthorLastname(bookEntity.getAuthorLastname());
        borrowingDto.setTitle(bookEntity.getTitle());
        borrowingDto.setBookId(bookEntity.getId());
        return borrowingDto;
    }

    //Return book (delete borrowing)
    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowing(@PathVariable Long borrowingId){
        borrowingService.deleteBorrowing(borrowingId);
    }
}
