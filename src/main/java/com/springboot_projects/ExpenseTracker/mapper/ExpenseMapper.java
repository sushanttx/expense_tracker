package com.springboot_projects.ExpenseTracker.mapper;

import com.springboot_projects.ExpenseTracker.dto.CategoryDTO;
import com.springboot_projects.ExpenseTracker.dto.ExpenseDTO;
import com.springboot_projects.ExpenseTracker.entity.Expenses;

public class ExpenseMapper {
//    Map Expense entity to ExpenseDTO
    public static ExpenseDTO mapToExpenseDTO(Expenses expense){
        return new ExpenseDTO(
                expense.getExpense_id(),
                expense.getAmount(),
                expense.getTimestamp(),
                new CategoryDTO(expense.getCategory().getCategoryid(),
                        expense.getCategory().getName())
        );
    }
}
