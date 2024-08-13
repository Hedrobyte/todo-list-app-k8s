package com.hedrobyte.todolist.services;

import com.hedrobyte.todolist.dtos.TaskDTO;
import com.hedrobyte.todolist.entities.Task;
import com.hedrobyte.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<TaskDTO> getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Transactional
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = convertToEntity(taskDTO);
        task = taskRepository.save(task);
        return convertToDTO(task);
    }

    @Transactional
    public Optional<TaskDTO> updateTask(Long id, TaskDTO taskDTO) {
        return taskRepository.findById(id)
                .map(existingTask -> updateExistingTask(existingTask, taskDTO))
                .map(taskRepository::save)
                .map(this::convertToDTO);
    }

    @Transactional
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    private Task updateExistingTask(Task existingTask, TaskDTO taskDTO) {
        existingTask.setTask(taskDTO.task());
        existingTask.setCategory(taskDTO.category());
        existingTask.setCompleted(taskDTO.completed());
        return existingTask;
    }

    private TaskDTO convertToDTO(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTask(),
                task.getCategory(),
                task.isCompleted()
        );
    }

    private Task convertToEntity(TaskDTO taskDTO) {
        return new Task(
                taskDTO.id(),
                taskDTO.task(),
                taskDTO.category(),
                taskDTO.completed()
        );
    }
}

