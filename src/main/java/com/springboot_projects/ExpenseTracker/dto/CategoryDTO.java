package com.springboot_projects.ExpenseTracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CategoryDTO {

    @NotNull
    private long id;
    @NotBlank
    @Size(min = 3, max = 10)
    private String name;
}
