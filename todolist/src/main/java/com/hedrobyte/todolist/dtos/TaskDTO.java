package com.hedrobyte.todolist.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskDTO (Long id,
                       @NotBlank(message = "The task field is required.") String task,
                       @NotBlank(message = "The category field is required.") String category,
                       @NotNull(message = "The completion status field is required.") boolean completed) {
}