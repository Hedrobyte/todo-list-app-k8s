import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { Task } from '../../../Task';
import { ButtonComponent } from '../button/button.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-task',
  standalone: true,
  imports: [FormsModule, ButtonComponent, CommonModule],
  templateUrl: './add-task.component.html',
  styleUrl: './add-task.component.css'
})
export class AddTaskComponent {
  @Output() onAddTask = new EventEmitter<Task>();

  task: string = '';
  category: string = '';
  completed: boolean = false;
  showAddTask: boolean = false;

  toggleVisibility(value: boolean): void {
    this.showAddTask = value;
  }

  onSubmit(): void {
    if (!this.task) {
      alert('Adicione uma tarefa!');
      return;
    }

    const newTask: Task = {
      task: this.task,
      category: this.category || 'Sem Categoria',  // Valor padrão
      completed: this.completed,
    };

    this.onAddTask.emit(newTask);

    // Limpar os campos do formulário
    this.task = '';
    this.category = '';
    this.completed = false;
  }
}
