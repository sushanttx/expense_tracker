package com.springboot_projects.ExpenseTracker.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExpenseDTO(Long id, BigDecimal amount, LocalDateTime expenseDate, CategoryDTO categoryDTO) {
}
