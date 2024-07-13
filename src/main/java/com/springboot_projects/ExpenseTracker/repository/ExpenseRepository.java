package com.springboot_projects.ExpenseTracker.repository;

import com.springboot_projects.ExpenseTracker.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expenses, Long> {
}
