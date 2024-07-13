package com.springboot_projects.ExpenseTracker.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expense_id;
    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;
    @Column(name = "TimeStamp", nullable = false)
    private LocalDateTime timestamp;
    @ManyToOne    //Many expenses can belong to one category.
    @JoinColumn (name = "categoryid", nullable = false)          // For expressing foreign key
    private Category category;

}
