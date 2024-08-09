package com.hedrobyte.todolist.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskDTO (Long id,
                       @NotBlank(message = "Title is mandatory") String title,
                       String description,
                       @NotNull(message = "Completed status is mandatory") boolean completed) {
}