package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class BorrowingService {
    private List<Borrowing> borrowings;

    public BorrowingService() {
        this.borrowings = init();
    }

    private List<Borrowing> init(){
        List<Borrowing> borrowings = new ArrayList<>();
        Borrowing borrowing = new Borrowing();
        borrowing.xxx;
        borrowing.xxx;
        borrowing.xxx;
        borrowings.add(borrowing);
    }

    public Integer createBorrowing(Borrowing borrowing) {
        this.borrowings.add(borrowing);

        return this.borrowings.size() -1;
    }

    public List<Borrowing> getBorrowings() {
        return this.borrowings;
    }

    public Borrowing getBorrowing(int borrowingId) {
        return this.borrowings.get(borrowingId);
    }

    public void deleteBorrowing(int borrowingId) {
        this.borrowings.remove(borrowingId);
    }
}


