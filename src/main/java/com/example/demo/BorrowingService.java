package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class BorrowingService {
    private final BookService bookService;
    private final BorrowingRepository borrowingRepository;
    private final CustomerService customersService;

    public BorrowingService(BorrowingRepository borrowings, CustomerService customers, BookService books) {
        this.bookService = books;
        this.borrowingRepository = borrowings;
        this.customersService = customers;
    }

    public List<BorrowingEntity> getBorrowings() {
        return borrowingRepository.findAll();
    }

    public BorrowingEntity createBorrowing(BorrowingDto request) {
        BorrowingEntity borrowing = new BorrowingEntity();
        CustomerEntity customer = customersService.getCustomer(Math.toIntExact(request.getCustomerId()));
        BookEntity book = bookService.getBook(request.getBookId());
        if (customer != null && book != null) {
            borrowing.setCustomer(customer);
            borrowing.setBook(book);
            return borrowingRepository.save(borrowing);
        }
        return null;
    }

    public BorrowingEntity getBorrowing(Long borrowingId) {
        Optional<BorrowingEntity> borrowing = borrowingRepository.findById(borrowingId);
        return borrowing.orElse(null);
    }

    public void deleteBorrowing(Long borrowingId){
        borrowingRepository.deleteById(borrowingId);
    }
}


