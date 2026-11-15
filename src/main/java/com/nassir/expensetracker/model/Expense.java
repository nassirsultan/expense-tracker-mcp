package com.nassir.expensetracker.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private String category;

    private String note;

    @Column(nullable = false)
    private LocalDate expenseDate;

    protected Expense() {}

    public Expense(BigDecimal amount, String category, String note, LocalDate expenseDate) {
        this.amount = amount;
        this.category = category;
        this.note = note;
        this.expenseDate = expenseDate;
    }

    public Long getId() { return id; }
    public BigDecimal getAmount() { return amount; }
    public String getCategory() { return category; }
    public String getNote() { return note; }
    public LocalDate getExpenseDate() { return expenseDate; }
}