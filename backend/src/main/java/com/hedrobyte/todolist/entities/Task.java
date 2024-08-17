package com.hedrobyte.todolist.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The task field is required.")
    private String task;

    @NotBlank(message = "The category field is required.")
    private String category;

    @NotNull(message = "The completion status field is required.")
    @Column(nullable = false)
    private boolean completed;

    public Task(Long id, String task, String category, boolean completed) {
        this.id = id;
        this.task = task;
        this.category = category;
        this.completed = completed;
    }
}
