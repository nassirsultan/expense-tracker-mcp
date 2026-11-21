package com.nassir.expensetracker.tools;

import com.nassir.expensetracker.model.Expense;
import com.nassir.expensetracker.repository.ExpenseRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class ExpenseTools {

    private final ExpenseRepository repository;

    public ExpenseTools(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Tool(description = "Adds a new expense. Use when the user says they spent money on something. The expense is dated today.")
    public String add_expense(
            @ToolParam(description = "Amount spent in rupees, e.g. 250") BigDecimal amount,
            @ToolParam(description = "Short category such as food, travel, rent, shopping") String category,
            @ToolParam(description = "Optional short note, e.g. 'lunch'", required = false) String note) {

        if (amount == null || amount.signum() <= 0) {
            return "Error: amount must be greater than 0.";
        }
        if (category == null || category.isBlank()) {
            return "Error: category is required.";
        }

        Expense saved = repository.save(new Expense(
                amount,
                category.trim().toLowerCase(),
                note,
                LocalDate.now()));

        return "Saved expense #" + saved.getId() + ": ₹" + saved.getAmount()
                + " on " + saved.getCategory() + " (" + saved.getExpenseDate() + ")";
    }
}